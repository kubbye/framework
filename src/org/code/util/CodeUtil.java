package org.code.util;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.WeakHashMap;

import org.code.util.db.MysqlUtil;
import org.code.util.page.EasyUiUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class CodeUtil {
    public static List<String> levels = Arrays.asList(new String[]{"all","sqlMap","dao","service","controller","page"}) ;
    public static String entityPackagePath = "";
    public static String daoPackagePath = "";
    public static String servicePackagePath = "";
    public static String controllerPackagePath = "";
    
    public static String key;
    public static String upperKey;
    public static String zhKey;
    public static String author;
    public static String createDate; 
    public static String urlPrefix;
    
    public static Field primaryKey;
    public static List<Field> fieldList;
    public static List<Field> noCommonFieldList;
    
    public static void main(String[] args) throws Exception {
        init();
      
        makeAll();
    }
    public static void makeAll()throws Exception{
        String level=PropertyUtil.getValue("created.code.level");
        if(!levels.contains(level)){
            level = "all";
        }
        
        makeEntity();
        
        switch(level){
            case "all":
                makeDao();
                makeService();
                makeController();
                if("mysql".equalsIgnoreCase(PropertyUtil.getValue("database.type"))){
                    MysqlUtil.makeSqlMap();
                }
                EasyUiUtil.makeJs();
                EasyUiUtil.makePage();
                break;
            case "entity":
                break;
            case "sqlMap":
                if("mysql".equalsIgnoreCase(PropertyUtil.getValue("database.type"))){
                    MysqlUtil.makeSqlMap();
                }
                break;
            case "dao":
                makeDao();
                break;
            case "service":
                makeService();
                break;
            case "controller":
                makeController();
                break;
            case "page":
                EasyUiUtil.makeJs();
                EasyUiUtil.makePage();
                break;
        }
    }
    /**
     * 功能描述: <br>
     *    初始化变量
     *
     */
    private static void init(){
        key = PropertyUtil.getValue("key");
        upperKey = StringUtil.upperFirst(PropertyUtil.getValue("key"));
        zhKey = PropertyUtil.getValue("ZhKey");
        author = PropertyUtil.getValue("copyright.author");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        createDate = format.format(new Date());
        
        initPachagePath();
    }
    /**
     * 功能描述: <br>
     *     初始化包路径
     *
     */
    private static void initPachagePath(){
        //entity包路径
        entityPackagePath = PropertyUtil.getValue("code.package.root") + ".entity";
        //dao包路径
        daoPackagePath = PropertyUtil.getValue("code.package.root") + "." + PropertyUtil.getValue("code.src.dao.root")
                + "." + key;
        //service包路径
        servicePackagePath = PropertyUtil.getValue("code.package.root") + "."
                + PropertyUtil.getValue("code.src.service.root") + "." + key;
        //controller包路径
        controllerPackagePath = PropertyUtil.getValue("code.package.root") + "."
                + PropertyUtil.getValue("code.src.controller.root") + "." + key;
        /*controller路径前缀*/
        String prefix = PropertyUtil.getValue("code.prefix.controller");
        if (null != prefix && !"".equals(prefix)) {
            prefix = "/" + prefix + "/" + key;
        } else {
            prefix = "/" + key;
        }
        urlPrefix = prefix;
        
        
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
        data.put("primaryKey", primaryKey.getName());
        data.put("UpperPrimaryKey", StringUtil.upperFirst(primaryKey.getName()));
        data.put("PrimaryKeyType", StringUtil.upperFirst(primaryKey.getType()));
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
        implData.put("primaryKey", primaryKey.getName());
        implData.put("UpperPrimaryKey", StringUtil.upperFirst(primaryKey.getName()));
        implData.put("PrimaryKeyType", StringUtil.upperFirst(primaryKey.getType()));
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
       
        //生成文件设置
        String path = getJavaFileRoot() + File.separator + PropertyUtil.getValue("code.src.controller.root")
                + File.separator + key;
        mkdirs(path);
        path += File.separator + upperKey + "Controller.java";
        FileWriter sw = new FileWriter(new File(path));
        WeakHashMap<String, Object> data = new WeakHashMap<String, Object>();
        data.put("packageName", controllerPackagePath); //包名   
        
        data.put("pagePrefix", urlPrefix.substring(1));
       
        
        data.put("urlPrefix", urlPrefix);
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
    

    public static void makeEntity() throws Exception {
        Configuration cfg = getCfg();
        Template template = cfg.getTemplate("entity.html");
        
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
        
        
        String level=PropertyUtil.getValue("created.code.level");
        if(!levels.contains(level)){
            level = "all";
        }
        if("all".equals(level) || "entity".equals(level)){
            template.process(data, sw);
        }
    }
   
    public static void mkdirs(String path){
        File f=new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
    }
    /**
     * <p>Description: java文件根路径</p>
     * @return
     */
    public static String getJavaFileRoot(){
        String root=PropertyUtil.getValue("code.package.root");
        root=root.replaceAll("\\.", "\\\\");
        String path=System.getProperty("user.dir");
        path += File.separator + PropertyUtil.getValue("code.src.root") + File.separator + root;
        
        return path;
    }
    public static List<Field> removeCommonFields(List<Field> list){
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
    public static String getConfigFileRoot(){
        String path=System.getProperty("user.dir");
        path += File.separator + PropertyUtil.getValue("code.src.root") + File.separator + "conf"+File.separator+"sqlMap";
        return path;
    }
    
    /**
     * <p>Description: js文件根路径</p>
     * @return
     */
    public static String getJsFileRoot(){
        String path=System.getProperty("user.dir");
        path += File.separator + PropertyUtil.getValue("code.resources.root") + File.separator + "resources"+File.separator+"js";
        return path;
    }
    
    /**
     * <p>Description: 页面文件根路径</p>
     * @return
     */
    public static String getPageFileRoot(){
        String path=System.getProperty("user.dir");
        path += File.separator + PropertyUtil.getValue("code.resources.root") + File.separator + "WEB-INF"+File.separator+"jsp";
        String prefix = PropertyUtil.getValue("code.prefix.controller");
        if (null != prefix && !"".equals(prefix)) {
            path += File.separator + prefix;
        } 
        return path;
    }
}
