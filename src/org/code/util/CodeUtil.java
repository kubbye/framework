package org.code.util;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.WeakHashMap;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class CodeUtil {
    private static String entityPackagePath = "";
    private static String daoPackagePath = "";
    private static String servicePackagePath = "";
    private static String controllerPackagePath = "";
    
    private static String key;
    private static String upperKey;
    private static String zhKey;
    private static String author;
    private static String createDate; 
    private static String urlPrefix;
    
    private static Field primaryKey;
    private static List<Field> fieldList;
    private static List<Field> noCommonFieldList;
    
    public static void main(String[] args) throws Exception {
        init();
        
        makeAll();
    }
    public static void makeAll()throws Exception{
        if(PropertyUtil.getValue("entity.only").equalsIgnoreCase("true")){
            makeEntity();
        }else{
            makeEntity();
            makeDao();
            makeService();
            makeController();
            makeSqlMap();
            makeJs();
            makePage();
        }
        
    }
    private static void init(){
        key = PropertyUtil.getValue("key");
        upperKey = StringUtil.upperFirst(PropertyUtil.getValue("key"));
        zhKey = PropertyUtil.getValue("ZhKey");
        author = PropertyUtil.getValue("copyright.author");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        createDate = format.format(new Date());
    }
    
    public static Configuration getCfg(){
        Configuration cfg=new Configuration();
        cfg.setClassForTemplateLoading(CodeUtil.class, "/org/code/template");
        return cfg;
    }
    
    /**
     * <p>Description: 生成dao相关类</p>
     */
    public static void makeDao() throws Exception {
        Configuration cfg = getCfg();
        //interface
        Template template = cfg.getTemplate("daoInterface.html");
        daoPackagePath = PropertyUtil.getValue("code.package.root") + "." + PropertyUtil.getValue("code.src.dao.root")
                + "." + key;
        //生成文件设置
        String path = getJavaFileRoot() + File.separator + PropertyUtil.getValue("code.src.dao.root") + File.separator
                + key;
        mkdirs(path);
        path += File.separator + "I" + upperKey + "Dao.java";
        FileWriter sw = new FileWriter(new File(path));
        WeakHashMap<String, Object> data = new WeakHashMap<String, Object>();
        data.put("packageName", daoPackagePath); //包名   
        data.put("UpperKey", upperKey);
        data.put("ZhKey", zhKey);
        data.put("author", author);
        data.put("createDate", createDate);

        template.process(data, sw);

        //impl
        Template implTemplate = cfg.getTemplate("dao.html");
        String daoImplPackagePath = daoPackagePath + ".impl";
        //生成文件设置
        String implPath = getJavaFileRoot() + File.separator + PropertyUtil.getValue("code.src.dao.root")
                + File.separator + key + File.separator + "impl";
        mkdirs(implPath);
        implPath += File.separator + upperKey + "DaoImpl.java";
        FileWriter implWriter = new FileWriter(new File(implPath));
        WeakHashMap<String, Object> implData = new WeakHashMap<String, Object>();
        implData.put("packageName", daoImplPackagePath); //包名   
        implData.put("key", key);
        implData.put("UpperKey", upperKey);
        implData.put("ZhKey", zhKey);
        implData.put("daoInterFace", daoPackagePath + ".I" + upperKey + "Dao");
        implData.put("author", author);
        implData.put("createDate", createDate);

        implTemplate.process(implData, implWriter);

    }
    /**
     * <p>Description: 生成service相关类</p>
     * @throws Exception 
     */
    public static void makeService() throws Exception {
        Configuration cfg = getCfg();
        //interface
        Template template = cfg.getTemplate("serviceInterface.html");
        servicePackagePath = PropertyUtil.getValue("code.package.root") + "."
                + PropertyUtil.getValue("code.src.service.root") + "." + key;
        //生成文件设置
        String path = getJavaFileRoot() + File.separator + PropertyUtil.getValue("code.src.service.root")
                + File.separator + key;
        mkdirs(path);
        path += File.separator + "I" + upperKey + "Service.java";
        FileWriter sw = new FileWriter(new File(path));
        WeakHashMap<String, Object> data = new WeakHashMap<String, Object>();
        data.put("packageName", servicePackagePath); //包名   
        data.put("EntityClass", entityPackagePath + "." + upperKey + "Entity");
        data.put("key", key);
        data.put("UpperKey", upperKey);
        data.put("ZhKey", zhKey);
        data.put("primaryKey", StringUtil.upperFirst(primaryKey.getName()));
        data.put("author", author);
        data.put("createDate", createDate);

        template.process(data, sw);

        //impl
        Template implTemplate = cfg.getTemplate("service.html");
        String serviceImplPackagePath = servicePackagePath + ".impl";
        //生成文件设置
        String implPath = getJavaFileRoot() + File.separator + PropertyUtil.getValue("code.src.service.root")
                + File.separator + key + File.separator + "impl";
        mkdirs(implPath);
        implPath += File.separator + upperKey + "ServiceImpl.java";
        FileWriter implWriter = new FileWriter(new File(implPath));
        WeakHashMap<String, Object> implData = new WeakHashMap<String, Object>();
        implData.put("packageName", serviceImplPackagePath); //包名   
        implData.put("key", key);
        implData.put("UpperKey", upperKey);
        implData.put("ZhKey", zhKey);
        implData.put("EntityClass", entityPackagePath + "." + upperKey + "Entity");
        implData.put("daoInterFace", daoPackagePath + ".I" + upperKey + "Dao");
        implData.put("serviceInterFace", servicePackagePath + ".I" + upperKey + "Service");
        implData.put("primaryKey", StringUtil.upperFirst(primaryKey.getName()));
        implData.put("author", author);
        implData.put("createDate", createDate);

        implTemplate.process(implData, implWriter);
    }
    /**
     * <p>Description: </p>
     */
    public static void makeController() throws Exception {
        Configuration cfg = getCfg();
        Template template = cfg.getTemplate("controller.html");
        controllerPackagePath = PropertyUtil.getValue("code.package.root") + "."
                + PropertyUtil.getValue("code.src.controller.root") + "." + key;
        //生成文件设置
        String path = getJavaFileRoot() + File.separator + PropertyUtil.getValue("code.src.controller.root")
                + File.separator + key;
        mkdirs(path);
        path += File.separator + upperKey + "Controller.java";
        FileWriter sw = new FileWriter(new File(path));
        WeakHashMap<String, Object> data = new WeakHashMap<String, Object>();
        data.put("packageName", controllerPackagePath); //包名   
        String prefix = PropertyUtil.getValue("code.prefix.controller");
        if (null != prefix && !"".equals(prefix)) {
            data.put("pagePrefix", prefix + "/" + key);
            prefix = "/" + prefix + "/" + key;
        } else {
            data.put("pagePrefix", key);
            prefix = "/" + key;
        }
        urlPrefix = prefix;
        data.put("urlPrefix", prefix);
        data.put("key", key);
        data.put("UpperKey", upperKey);
        data.put("ZhKey", zhKey);
        data.put("author", author);
        data.put("createDate", createDate);

        data.put("EntityClass", entityPackagePath + "." + upperKey + "Entity");
        data.put("serviceInterFace", servicePackagePath + ".I" + upperKey + "Service");
        data.put("primaryKey", primaryKey.getName());
        data.put("UpperPrimaryKey", StringUtil.upperFirst(primaryKey.getName()));

        template.process(data, sw);

    }
    public static void makeSqlMap() throws Exception {

        Configuration cfg = getCfg();
        Template template = cfg.getTemplate("sqlMap.html");
        //生成文件设置
        String path = getConfigFileRoot();
        
        mkdirs(path);
        path += File.separator + "sqlMap_"+key+".xml";
        
        FileWriter sw = new FileWriter(new File(path));
        WeakHashMap<String, Object> data = new WeakHashMap<String, Object>();
        data.put("key", key);
        data.put("UpperKey", upperKey);
        data.put("ZhKey", zhKey);
        data.put("author", author);
        data.put("createDate", createDate);
        data.put("EntityClass", entityPackagePath + "." + upperKey + "Entity");
        data.put("primaryKey", primaryKey.getName());
        data.put("primaryKeyType", MysqlUtil.getFullType(primaryKey.getType()));
        data.put("primaryColumn", primaryKey.getColumnName());
        data.put("tableName", PropertyUtil.getValue("table.name"));
        data.put("fieldList", fieldList);
        data.put("noCommonFieldList", noCommonFieldList);
        data.put("propertyPrefix", "#{");
        data.put("propertyPostfix", "}");
        template.process(data, sw);
    }

    public static void makeEntity() throws Exception {
        Configuration cfg = getCfg();
        Template template = cfg.getTemplate("entity.html");
        entityPackagePath = PropertyUtil.getValue("code.package.root") + ".entity";
        //生成文件设置
        String path = getJavaFileRoot() + File.separator + PropertyUtil.getValue("code.src.entity.root");
        mkdirs(path);
        path += File.separator + upperKey + "Entity.java";
        FileWriter sw = new FileWriter(new File(path));
        WeakHashMap<String, Object> data = new WeakHashMap<String, Object>();
        data.put("packageName", entityPackagePath);
        data.put("key", key);
        data.put("UpperKey", upperKey);
        data.put("ZhKey", zhKey);
        data.put("author", author);
        data.put("createDate", createDate);
        
        List<Field> list = MysqlUtil.getInstance().getTableField();
        noCommonFieldList = removeCommonFields(list);
        data.put("fieldList", list);
        data.put("noCommonFieldList", noCommonFieldList);

        primaryKey = MysqlUtil.getInstance().getPrimaryKey(list);
        fieldList = list;
        template.process(data, sw);
    }
    public static void makePage() throws Exception {
        String pageRoot = getPageFileRoot() + File.separator + key;
        Configuration cfg = getCfg();
        //list page
        Template template = cfg.getTemplate("list.html");
        //生成文件设置
        mkdirs(pageRoot);
        String path = pageRoot + File.separator + key + "List.jsp";
        FileWriter sw = new FileWriter(new File(path));
        WeakHashMap<String, Object> data = new WeakHashMap<String, Object>();
        data.put("urlPrefix", urlPrefix);
        data.put("key", key);
        data.put("UpperKey", upperKey);
        data.put("ZhKey", zhKey);
        data.put("author", author);
        data.put("createDate", createDate);
        data.put("primaryKey", primaryKey.getName());
        data.put("fieldList", fieldList);
        data.put("noCommonFieldList", noCommonFieldList);
        
        data.put("propertyPrefix", "${");
        data.put("propertyPostfix", "}");
        template.process(data, sw);
        
        //add page
        Template addTemplate = cfg.getTemplate("add.html");
        //生成文件设置
        String adPpath = pageRoot + File.separator + key + "Add.jsp";
        FileWriter addWriter = new FileWriter(new File(adPpath));
        addTemplate.process(data, addWriter);
        
        //edit page
        Template editTemplate = cfg.getTemplate("edit.html");
        //生成文件设置
        String editPath = pageRoot + File.separator + key + "Edit.jsp";
        FileWriter editWriter = new FileWriter(new File(editPath));
        editTemplate.process(data, editWriter);
        
        //detail page
        Template detailTemplate = cfg.getTemplate("detail.html");
        //生成文件设置
        String detailPath = pageRoot + File.separator + key + "Detail.jsp";
        FileWriter detailWriter = new FileWriter(new File(detailPath));
        detailTemplate.process(data, detailWriter);
    }
    public static void makeJs() throws Exception {
        String jsRoot = getJsFileRoot() + File.separator + key;
        
        Configuration cfg = getCfg();
        //edit js
        Template template = cfg.getTemplate("edit_js.html");
        //生成文件设置
        mkdirs(jsRoot);
        String path = jsRoot + File.separator + key + "Edit.js";
        FileWriter sw = new FileWriter(new File(path));
        WeakHashMap<String, Object> data = new WeakHashMap<String, Object>();
        data.put("urlPrefix", urlPrefix);
        data.put("key", key);
        data.put("UpperKey", upperKey);
        data.put("ZhKey", zhKey);
        data.put("author", author);
        data.put("createDate", createDate);

        template.process(data, sw);

        //list js
        Template implTemplate = cfg.getTemplate("list_js.html");
        //生成文件设置
        String listPath = jsRoot + File.separator + key + "List.js";
        FileWriter listWriter = new FileWriter(new File(listPath));
        WeakHashMap<String, Object> listData = new WeakHashMap<String, Object>();
        listData.put("urlPrefix", urlPrefix);
        listData.put("key", key);
        listData.put("UpperKey", upperKey);
        listData.put("ZhKey", zhKey);
        listData.put("author", author);
        listData.put("createDate", createDate);
        listData.put("primaryKey", primaryKey.getName());
        listData.put("fieldList", fieldList);
        listData.put("width", 1000/fieldList.size());

        implTemplate.process(listData, listWriter);
    }
    private static void mkdirs(String path){
        File f=new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
    }
    /**
     * <p>Description: java文件根路径</p>
     * @return
     */
    private static String getJavaFileRoot(){
        String root=PropertyUtil.getValue("code.package.root");
        root=root.replaceAll("\\.", "\\\\");
        String path=System.getProperty("user.dir");
        path += File.separator + PropertyUtil.getValue("code.src.root") + File.separator + root;
        
        return path;
    }
    private static List<Field> removeCommonFields(List<Field> list){
        List<Field> resList = new ArrayList<Field>();
        for(Field f : list){
            if(!f.getName().equalsIgnoreCase("updateUser")
                    && !f.getName().equalsIgnoreCase("createUser")
                    && !f.getName().equalsIgnoreCase("createTime")
                    && !f.getName().equalsIgnoreCase("updateTime")
                    && !f.getName().equalsIgnoreCase("deleteMark")){
                resList.add(f);
            }
        }
        return resList;
    }
    /**
     * <p>Description: sqlMap文件根路径</p>
     * @return
     */
    private static String getConfigFileRoot(){
        String path=System.getProperty("user.dir");
        path += File.separator + PropertyUtil.getValue("code.src.root") + File.separator + "conf"+File.separator+"sqlMap";
        return path;
    }
    
    /**
     * <p>Description: js文件根路径</p>
     * @return
     */
    private static String getJsFileRoot(){
        String path=System.getProperty("user.dir");
        path += File.separator + PropertyUtil.getValue("code.resources.root") + File.separator + "resources"+File.separator+"js";
        return path;
    }
    
    /**
     * <p>Description: 页面文件根路径</p>
     * @return
     */
    private static String getPageFileRoot(){
        String path=System.getProperty("user.dir");
        path += File.separator + PropertyUtil.getValue("code.resources.root") + File.separator + "WEB-INF"+File.separator+"jsp";
        String prefix = PropertyUtil.getValue("code.prefix.controller");
        if (null != prefix && !"".equals(prefix)) {
            path += File.separator + prefix;
        } 
        return path;
    }
}
