package action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.editor.VisualPosition;
import com.intellij.psi.PsiFile;
import dialog.LibDialog;
import dialog.LoginDialog;
import util.GlobalVariable;

public class AddTemplateAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here

        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        SelectionModel selectionModel = editor.getSelectionModel();
        String selectedText = selectionModel.getSelectedText();


        if (!GlobalVariable.online){
            LoginDialog loginDialog = new LoginDialog(selectedText);
            loginDialog.show();
        }else {
            LibDialog libDialog = new LibDialog(selectedText);
            libDialog.show();
        }
    }
}
