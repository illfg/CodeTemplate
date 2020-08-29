import util.WebUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Test {


    @org.junit.Test
    public void test(){
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
        }
    }
}
