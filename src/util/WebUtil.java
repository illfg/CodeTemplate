package util;

import entity.TemplateWrapper;
import org.codehaus.plexus.component.annotations.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WebUtil {

    static RestTemplate template = new RestTemplate();

    static final String URL = "http://49.234.77.96";

    public static boolean login(String username,String password){
        Map result = null;
        try{
            result = template.getForObject(URL+"/user/login?username="
                    +username+"&password="+password, Map.class);
        }catch (Exception e){
            NotifyUtil.doNotify("登录异常","服务器访问失败");
            return false;
        }

        String info = (String) result.get("info");
        if ("success".equals(info)){
            return true;
        }else {
            String detail = (String) result.get("detail");
            NotifyUtil.doNotify("登录异常",detail);
            return false;
        }
    }

    public static boolean signup(String username,String password){
        Map result = null;
        try{
            result = template.getForObject(URL+"/user/insert?username="
                    +username+"&password="+password, Map.class);
        }catch (Exception e){
            NotifyUtil.doNotify("登录异常","服务器访问失败");
            return false;
        }

        String info = (String) result.get("info");
        if ("success".equals(info)){
            return true;
        }else {
            String detail = (String) result.get("detail");
            NotifyUtil.doNotify("登录异常",detail);
            return false;
        }
    }

    public static boolean query_Template(List<Map> callback){
        Map result = null;
        try{
            result = template.getForObject(URL+"/template/query", Map.class);
        }catch (Exception e){
            NotifyUtil.doNotify("网络异常","服务器访问失败");
            return false;
        }

        String info = (String) result.get("info");
        if ("success".equals(info)){
            List<Map> list = (List<Map>) result.get("list");
            callback.addAll(list);
            return true;
        }else {
            String detail = (String) result.get("detail");
            NotifyUtil.doNotify("网络异常",detail);
            return false;
        }
    }

    public static boolean query_TemplateById(int queryId,TemplateWrapper templateWrapper){
        Map result = null;
        try{
            result = template.getForObject(URL+"/template/queryOne?id="+queryId
                    , Map.class);
        }catch (Exception e){
            NotifyUtil.doNotify("网络异常","服务器访问失败");
            return false;
        }

        String info = (String) result.get("info");
        if ("success".equals(info)){
            Map entity = (Map) result.get("entity");
            int  id = (int) entity.get("id");
            String  template_name = (String) entity.get("template_name");
            String  content = (String) entity.get("content");
            templateWrapper.setId(id);
            templateWrapper.setTemplate_name(template_name);
            templateWrapper.setContent(content);
            return true;
        }else {
            String detail = (String) result.get("detail");
            NotifyUtil.doNotify("网络异常",detail);
            return false;
        }
    }

    public static boolean save(int id,String template_name,String content){
        Map result = null;
        try{
            result = template.postForObject(URL+"/template/update?id={1}&template_name={2}&content={3}",
                    null,Map.class,id,template_name,content);
        }catch (Exception e){
            NotifyUtil.doNotify("网络异常","服务器访问失败");
            e.printStackTrace();
            return false;
        }
        String info = (String) result.get("info");
        if ("success".equals(info)){
            return true;
        }else {
            String detail = (String) result.get("detail");
            NotifyUtil.doNotify("网络异常",detail);
            return false;
        }
    }
    public static boolean delete(int id){
        Map result = null;
        try{
            result = template.getForObject(URL+"/template/delete?id="+ id, Map.class);
        }catch (Exception e){
            NotifyUtil.doNotify("网络异常","服务器访问失败");
            return false;
        }
        String info = (String) result.get("info");
        if ("success".equals(info)){
            return true;
        }else {
            String detail = (String) result.get("detail");
            NotifyUtil.doNotify("网络异常",detail);
            return false;
        }
    }
    public static boolean insert(String template_name,String content){
        Map result = null;
        try{
            result = template.postForObject(URL+"/template/insert?template_name={1}&content={2}",
                    null,Map.class,template_name,content);
        }catch (Exception e){
            NotifyUtil.doNotify("网络异常","服务器访问失败");
            e.printStackTrace();
            return false;
        }
        String info = (String) result.get("info");
        if ("success".equals(info)){
            return true;
        }else {
            String detail = (String) result.get("detail");
            NotifyUtil.doNotify("网络异常",detail);
            return false;
        }
    }
}
