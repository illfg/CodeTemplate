package action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import dialog.FeedBackDialog;
import dialog.LibDialog;
import dialog.LoginDialog;
import util.GlobalVariable;
import util.WebUtil;

public class InsertTemplateAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        SelectionModel selectionModel = editor.getSelectionModel();
        int offset = selectionModel.getLeadSelectionOffset();
        Document document = editor.getDocument();


        if(!WebUtil.heartBeat()){
            new FeedBackDialog("非常抱歉，无法连接到服务器，请稍后重试，或与我联系：QQ1667248505").show();
            return;
        }

        if (!GlobalVariable.online){
            LoginDialog loginDialog = new LoginDialog();
            loginDialog.show();
        }else {
            LibDialog libDialog = new LibDialog(document,offset);
            libDialog.show();
        }
    }
}
