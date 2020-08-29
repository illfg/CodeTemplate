package dialog;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class AddTemplateDialog extends DialogWrapper {

    public AddTemplateDialog() {
        super(true);
        setTitle("新建模板");
        init();
    }


    public void setSelectedText(String selectedText) {
        this.selectedText = selectedText;
    }

    String selectedText;
    EditorTextField editorTextField;

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        //可指定布局方式
        //JPanel jPanel = new JPanel(new BorderLayout());
        //jPanel.add(editorTextField,BorderLayout.CENTER);

        JPanel jPanel = new JPanel();
        editorTextField = new EditorTextField();
        editorTextField.setText("输入模板名称");
        editorTextField.setPreferredSize(new Dimension(200,35));
        jPanel.add(editorTextField);
        return jPanel;
    }

    @Override
    protected JComponent createSouthPanel() {
        JPanel jPanel = new JPanel();
        JButton jButton = new JButton("新建模板");
        jPanel.add(jButton);
        jButton.addActionListener(e -> {
            MainDialog mainDialog = new MainDialog();
            mainDialog.show();
            close(0);
        });
        return jPanel;
    }
}
