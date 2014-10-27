/**
 * EasyUiUtil.java
 * Created at 2014-05-21
 * Created by weih
 * Copyright (C) 2014 Wade, All rights reserved.
 */
package org.code.util.page;

import java.io.File;
import java.io.FileWriter;
import java.util.WeakHashMap;

import org.code.util.CodeUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class EasyUiUtil {
    
    private static final String templatePrefix="/page/easyui";
    /**
     * 功能描述: 生成js<br>
     * 〈功能详细描述〉
     *
     * @throws Exception
     */
    public static void makeJs() throws Exception {
        String jsRoot = CodeUtil.getJsFileRoot() + File.separator + CodeUtil.key;
        
        Configuration cfg = CodeUtil.getCfg();
        cfg.setClassForTemplateLoading(CodeUtil.class, "/org/code/template" + templatePrefix);
        //edit js
        Template template = cfg.getTemplate("edit_js.html");
        //生成文件设置
        CodeUtil.mkdirs(jsRoot);
        String path = jsRoot + File.separator + CodeUtil.key + "Edit.js";
        FileWriter sw = new FileWriter(new File(path));
        WeakHashMap<String, Object> data = new WeakHashMap<String, Object>();
        data.put("urlPrefix", CodeUtil.urlPrefix);
        data.put("key", CodeUtil.key);
        data.put("UpperKey", CodeUtil.upperKey);
        data.put("ZhKey", CodeUtil.zhKey);
        data.put("author", CodeUtil.author);
        data.put("createDate", CodeUtil.createDate);

        template.process(data, sw);

        //list js
        Template implTemplate = cfg.getTemplate("list_js.html");
        //生成文件设置
        String listPath = jsRoot + File.separator + CodeUtil.key + "List.js";
        FileWriter listWriter = new FileWriter(new File(listPath));
        WeakHashMap<String, Object> listData = new WeakHashMap<String, Object>();
        listData.put("urlPrefix", CodeUtil.urlPrefix);
        listData.put("key", CodeUtil.key);
        listData.put("UpperKey", CodeUtil.upperKey);
        listData.put("ZhKey", CodeUtil.zhKey);
        listData.put("author", CodeUtil.author);
        listData.put("createDate", CodeUtil.createDate);
        listData.put("primaryKey", CodeUtil.primaryKey.getName());
        listData.put("fieldList", CodeUtil.fieldList);
        listData.put("width", 1000/CodeUtil.fieldList.size());

        implTemplate.process(listData, listWriter);
    }
    
    /**
     * 功能描述: 生成页面<br>
     * 〈功能详细描述〉
     *
     * @throws Exception
     */
    public static void makePage() throws Exception {
        String pageRoot = CodeUtil.getPageFileRoot() + File.separator + CodeUtil.key;
        Configuration cfg = CodeUtil.getCfg();
        cfg.setClassForTemplateLoading(CodeUtil.class, "/org/code/template" + templatePrefix);
        //list page
        Template template = cfg.getTemplate("list.html");
        //生成文件设置
        CodeUtil.mkdirs(pageRoot);
        String path = pageRoot + File.separator + CodeUtil.key + "List.jsp";
        FileWriter sw = new FileWriter(new File(path));
        WeakHashMap<String, Object> data = new WeakHashMap<String, Object>();
        data.put("urlPrefix", CodeUtil.urlPrefix);
        data.put("key", CodeUtil.key);
        data.put("UpperKey", CodeUtil.upperKey);
        data.put("ZhKey", CodeUtil.zhKey);
        data.put("author", CodeUtil.author);
        data.put("createDate", CodeUtil.createDate);
        data.put("primaryKey", CodeUtil.primaryKey.getName());
        data.put("fieldList", CodeUtil.fieldList);
        data.put("noCommonFieldList", CodeUtil.noCommonFieldList);
        
        data.put("propertyPrefix", "${");
        data.put("propertyPostfix", "}");
        template.process(data, sw);
        
        //add page
        Template addTemplate = cfg.getTemplate("add.html");
        //生成文件设置
        String adPpath = pageRoot + File.separator + CodeUtil.key + "Add.jsp";
        FileWriter addWriter = new FileWriter(new File(adPpath));
        addTemplate.process(data, addWriter);
        
        //edit page
        Template editTemplate = cfg.getTemplate("edit.html");
        //生成文件设置
        String editPath = pageRoot + File.separator + CodeUtil.key + "Edit.jsp";
        FileWriter editWriter = new FileWriter(new File(editPath));
        editTemplate.process(data, editWriter);
        
        //detail page
        Template detailTemplate = cfg.getTemplate("detail.html");
        //生成文件设置
        String detailPath = pageRoot + File.separator + CodeUtil.key + "Detail.jsp";
        FileWriter detailWriter = new FileWriter(new File(detailPath));
        detailTemplate.process(data, detailWriter);
    }
   
}

