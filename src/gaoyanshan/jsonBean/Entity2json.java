package gaoyanshan.jsonBean;

import gaoyanshan.bean.FileData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Entity2json {
    public static void main(String[] args) {
		/*
		 * 1.测试单个实体转为json字符串
		 */
//        FileData fileData=new FileData("filename","filename","filename",false,"filename0");
//        Entity2json e2j = new Entity2json();
//        String jstr = e2j.beanToJSONStr(fileData);
//        System.out.println("实体类转json字符串："+jstr);
		/*
		 * 2.测试实体类List转为json字符串
		 */
//        List<FileData> ul = new ArrayList<FileData>();
//        ul.add(new FileData("filename","filename","filename",false,"filename0"));
//        ul.add(new FileData("filename","filename","filename",false,"filename0"));
//        ul.add(new FileData("filename","filename","filename",false,"filename0"));
//        String jstrl = e2j.beanListToJSONStr(ul);
//        System.out.println("实体类List转为json字符串:"+jstrl);
		/*
		 * 3.测试json字符串转为实体类
		 */
//        String j="{\"sex\":\"male\",\"address\":\"shanghai\",\"age\":23,\"name\":\"tom\"}";
//        JSONObject obj1 = JSONObject.fromObject(j);
//        User uu = (User) JSONObject.toBean(obj1,User.class);
//        System.out.println("json字符串转为实体类:"+uu);
		/*
		 * 4.测试json字符串转为实体类List
		 */
//        String json = "{\"listObject\":[{\"sex\":\"male\",\"address\":\"shanghai\",\"age\":23,\"name\":\"tom\"},{\"sex\":\"famale\",\"address\":\"beijing\",\"age\":20,\"name\":\"cherry\"},{\"sex\":\"famale\",\"address\":\"suzhou\",\"age\":19,\"name\":\"bole\"}]}";
//        JSONObject obj = JSONObject.fromObject(json);
//        List<User> ulist = (List<User>) JSONArray.toList(obj.getJSONArray("listObject"), User.class);
//        System.out.println("json字符串转为实体类List:"+ulist);
    }

    /**
     * 将对象转换成JSON格式的字符串 适用于单个对象(单个对象里可以包含List<T>)的转换
     */
    public <T> String beanToJSONStr(T t) {
        String json = "";
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,
                new JsonDateValueProcessor());
        if(t!=null){
            json = JSONObject.fromObject(t, jsonConfig).toString();
        }else{
            json="[]";
        }
        return json;
    }
    /**
     * 将实体类List转换成JSON格式的字符串
     */
    public <T> String beanListToJSONStr(List<T> t) {
        String json = "";
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,
                new JsonDateValueProcessor());
        if(t!=null){
            json = JSONArray.fromObject(t, jsonConfig).toString();
        }else{
            json="[]";
        }
        return json;
    }
}
