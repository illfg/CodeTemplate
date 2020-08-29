package dialog;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class FeedBackDialog extends DialogWrapper {
    public FeedBackDialog() {
        super(true);
        setTitle("反馈");
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setPreferredSize(new Dimension(200,100));
        JLabel jLabel = new JLabel("QQ:1667248505,感谢您使用该插件,有任何建议或问题,请联系我");
        jPanel.add(jLabel,BorderLayout.CENTER);
        return jPanel;
    }
}
