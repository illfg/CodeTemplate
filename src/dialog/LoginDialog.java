package dialog;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;
import util.GlobalVariable;
import util.WebUtil;

import javax.swing.*;

public class LoginDialog extends DialogWrapper {
    private JPanel panel1;
    private JButton signup;
    private JTextField username;
    private JPasswordField password;
    private JButton login;

    String content = "";

    public LoginDialog() {
        super(true);
        setTitle("登录/注册");
        init();
    }

    public LoginDialog(String content){
        this();
        this.content = content;
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {


        //登录
        login.addActionListener(e -> {
            String username = this.username.getText();
            char[] chars = this.password.getPassword();
            String password = new String(chars);


            boolean flag = WebUtil.login(username, password);
            if (flag){
                {
                    PropertiesComponent.getInstance().setValue("username",username);
                    PropertiesComponent.getInstance().setValue("password",password);
                    GlobalVariable.online = true;
                }


                LibDialog libDialog = new LibDialog(content);
                libDialog.show();
                close(0);
            }
        });

        //注册
        signup.addActionListener(e -> {
            String username = this.username.getText();
            char[] chars = this.password.getPassword();
            String password = new String(chars);

            boolean flag = WebUtil.signup(username, password);
            if (flag){
                {

                    PropertiesComponent.getInstance().setValue("username",username);
                    PropertiesComponent.getInstance().setValue("password",password);
                    GlobalVariable.online = true;
                }
                LibDialog libDialog = new LibDialog();
                libDialog.show();
                close(0);
            }
        });

        return panel1;
    }

    @Override
    protected JComponent createSouthPanel() {
        JPanel jPanel = new JPanel();
        return jPanel;
    }
}
