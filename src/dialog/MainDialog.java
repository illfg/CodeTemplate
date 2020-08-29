package dialog;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import com.intellij.ui.components.JBScrollPane;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class MainDialog extends DialogWrapper {
    protected MainDialog() {
        super(true);
        setTitle("模板库");
        init();
    }


    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        //大面板
        JPanel main = new JPanel(new BorderLayout());


        //模板面板

        JPanel templates = new JPanel();
        Component slot = createSlot("数据库连接配置", "2020.05.13");
        templates.add(slot);
        slot = createSlot("数据库连接配置", "2020.05.13");
        templates.add(slot);
        slot = createSlot("数据库连接配置", "2020.05.13");
        templates.add(slot);
         slot = createSlot("数据库连接配置", "2020.05.13");
        templates.add(slot);
        slot = createSlot("数据库连接配置", "2020.05.13");
        templates.add(slot);
        slot = createSlot("数据库连接配置", "2020.05.13");
        templates.add(slot);
        slot = createSlot("数据库连接配置", "2020.05.13");
        templates.add(slot);
        slot = createSlot("数据库连接配置", "2020.05.13");
        templates.add(slot);
        slot = createSlot("数据库连接配置", "2020.05.13");
        templates.add(slot);
        slot = createSlot("数据库连接配置", "2020.05.13");
        templates.add(slot);
        templates.add(slot);
        slot = createSlot("数据库连接配置", "2020.05.13");
        templates.add(slot);
        slot = createSlot("数据库连接配置", "2020.05.13");
        templates.add(slot);
        slot = createSlot("数据库连接配置", "2020.05.13");
        templates.add(slot);
        slot = createSlot("数据库连接配置", "2020.05.13");
        templates.add(slot);
        templates.add(slot);
        slot = createSlot("数据库连接配置", "2020.05.13");
        templates.add(slot);
        slot = createSlot("数据库连接配置", "2020.05.13");
        templates.add(slot);
        slot = createSlot("数据库连接配置", "2020.05.13");
        templates.add(slot);
        slot = createSlot("数据库连接配置", "2020.05.13");
        templates.add(slot);

        JBScrollPane jScrollPane = new JBScrollPane(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setAutoscrolls(true);
        jScrollPane.setViewportView(templates);

        jScrollPane.setPreferredSize(new Dimension(200,600));

        main.add(jScrollPane,BorderLayout.WEST);


        //编辑面板
        JPanel editor = new JPanel();
        EditorTextField editorTextField = new EditorTextField();
        editorTextField.setPreferredSize(new Dimension(500,600));
        editor.add(editorTextField);
        main.add(editor,BorderLayout.EAST);

        return main;
    }

    Component createSlot(String _name, String _time){
        JPanel slot = new JPanel(new BorderLayout());
        JLabel name = new JLabel(_name);
        JLabel time = new JLabel(_time);
        slot.add(name,BorderLayout.CENTER);
        slot.add(time,BorderLayout.SOUTH);
        slot.setPreferredSize(new Dimension(180,50));
        return slot;
    }
}
