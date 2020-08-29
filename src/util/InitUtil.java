package util;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.components.ApplicationComponent;

public class InitUtil implements ApplicationComponent {

    @Override
    public void initComponent() {

        String username = PropertiesComponent.getInstance().getValue("username");
        String password = PropertiesComponent.getInstance().getValue("password");
        //PersistentValue persistentValue = new PersistentValue();
        //persistentValue.loadState(new PersistentValue.State("1111111111","asfsdfasdf"));
        //PersistentValue.State state = persistentValue.getState();

//        System.out.println("=======================");
//        System.out.println(state.password);
        if (username != null && !"".equals(username)){
            boolean login = WebUtil.login(username, password);
            if (login){
                GlobalVariable.online = true;
            }
        }
    }
}
