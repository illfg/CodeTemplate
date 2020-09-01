package dialog;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class FeedBackDialog extends DialogWrapper {

    String msg;
    public FeedBackDialog(String msg) {
        super(true);
        setTitle("反馈");
        init();
        this.msg = msg;
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setPreferredSize(new Dimension(200,100));
        JLabel jLabel = new JLabel(msg);
        jPanel.add(jLabel,BorderLayout.CENTER);
        return jPanel;
    }
}
