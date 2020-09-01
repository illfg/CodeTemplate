package dialog;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.ui.DialogWrapper;
import entity.TemplateWrapper;
import org.jetbrains.annotations.Nullable;
import org.junit.Test;
import util.GlobalVariable;
import util.WebUtil;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.FocusListener;
import java.util.*;

public class LibDialog extends DialogWrapper {
    private JPanel main;
    private JPanel rightpanel;
    private JPanel leftpanel;
    private JButton insertButton;
    private JList list1;
    private JToolBar toolbar;
    private JTextArea content;
    private JTextField t_name;
    private JLabel info;
    Vector<Integer> list_id = new Vector<>();
    int index = -1;
    Document document = null;
    int offset = -1;

    public LibDialog() {
        super(true);
        setTitle("模板库");
        init();
    }
    public LibDialog(String content){
        this();
        this.content.setText(content);
        insertButton.setEnabled(false);
    }
    public LibDialog(Document document,int offset){
        this();
        this.document =document;
        this.offset = offset;
    }



    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        listInit();
        toolbarInit();
        buttonInit();
        return main;
    }

    void buttonInit(){
        insertButton.addActionListener(e -> {
            String contentText = content.getText();

            String text = document.getText();
            StringBuilder stringBuilder = new StringBuilder(text);
            stringBuilder.insert(offset,contentText);
            document.setText(stringBuilder.toString());
            close(0);
        });
    }

    void toolbarInit(){
        JButton refresh_B = new JButton("刷新");
        toolbar.add(refresh_B);
        JButton logout_B = new JButton("登出");
        toolbar.add(logout_B);
        JButton save_B = new JButton("保存模板");
        toolbar.add(save_B);
        JButton delete_B = new JButton("删除模板");
        toolbar.add(delete_B);
        JButton feedback = new JButton("反馈/联系");
        toolbar.add(feedback);
        
        refresh_B.addActionListener(e -> {
            list_id = refresh();
        });
        logout_B.addActionListener(e -> {
            PropertiesComponent.getInstance().setValue("username","-1");
            PropertiesComponent.getInstance().setValue("password","-1");
            GlobalVariable.online = false;
            LoginDialog loginDialog = new LoginDialog();
            loginDialog.show();
            close(0);
        });
        save_B.addActionListener(e -> {
            if (index == -1){
                //新建
                String t_nameText = t_name.getText();
                String contentText = content.getText();
                if (t_nameText == null || "".equals(t_nameText)){
                    info.setText("模板名不能为空");
                }else {
                    boolean flag = WebUtil.insert(t_nameText, contentText);
                    if (flag){
                        list_id = refresh();
                        info.setText("新建成功");
                    }else {
                        info.setText("新建失败, 查看idea日志以了解更多");
                    }
                }

            }else {
                //更新
                Integer id = list_id.get(index);
                String t_nameText = t_name.getText();
                String contentText = content.getText();
                boolean flag = WebUtil.save(id, t_nameText, contentText);
                if (flag) {
                    info.setText("成功保存");
                }else {
                    info.setText("保存失败, 查看idea日志以了解更多");
                }
            }

        });
        delete_B.addActionListener(e -> {
            Integer id = list_id.get(index);
            boolean flag = WebUtil.delete(id);
            if (flag){
                list_id = refresh();
                t_name.setText(" ");
                content.setText(" ");
                info.setText("删除成功");
            }else {
                info.setText("删除失败, 查看idea日志以了解更多");
            }
        });
        feedback.addActionListener(e -> {
            FeedBackDialog feedBackDialog = new FeedBackDialog("QQ:1667248505,感谢您使用该插件,有任何建议或问题,请联系我");
            feedBackDialog.show();
        });
    }
    void listInit(){
        list_id = refresh();
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // 获取所有被选中的选项索引
                int[] indices = list1.getSelectedIndices();
                    // 获取选项数据的 ListModel
                    //ListModel<String> listModel = list1.getModel();
                    //listModel.getElementAt(0)
                index = indices[0];
                Integer integer = list_id.get(index);
                TemplateWrapper wrapper = new TemplateWrapper();
                boolean flag = WebUtil.query_TemplateById(integer, wrapper);
                if (flag){
                    content.setText(wrapper.getContent());
                    t_name.setText(wrapper.getTemplate_name());
                }
            }
        });
    }
    Vector<Integer> refresh(){
        List<Map> callback = new LinkedList<>();
        Vector<Integer> list_id = new Vector<>();
        Vector<String> list_item = new Vector<>();
        boolean flag = WebUtil.query_Template(callback);
        if (flag){
            for (Map map: callback) {
                Integer id = (Integer) map.get("id");
                String template_name = (String) map.get("template_name");
                list_id.add(id);
                list_item.add(template_name);
            }
            info.setText("列表刷新成功");
        }else {
            info.setText("列表刷新失败, 查看idea日志以了解更多");
        }
        list1.setListData(list_item);
        return list_id;
    }

    @Override
    protected JComponent createSouthPanel() {
        return null;
    }

}
