package com.wade.framework.base;

import java.io.Serializable;

public class AjaxSuccessInfo implements Serializable {
    
    /**
     * message key
     */
    public static final String MESSAGE_KEY = "message";
    
    /**
     * <p>Field serialVersionUID: serialVersionUID</p>
     */
    private static final long serialVersionUID = -6840650362280756212L;
    
    /**
     * <p>Field successCode: 成功代码</p>
     */
    private String successCode = "success";
    public String getSuccessCode() {
        return successCode;
    }
    public void setSuccessCode(String successCode) {
        this.successCode = successCode;
    }
    public String getMessage() {
        return message;
    }

    /**
     * <p>Field successStatus: 状态</p>
     */
    private String successStatus; 
    /**
     * <p>Field message: 提示信息</p>
     */
    private String message;
    
    private AjaxSuccessInfo(){
        
    }
    public static AjaxSuccessInfo success(String message){
        AjaxSuccessInfo ajaxObj=new AjaxSuccessInfo();
        ajaxObj.setSuccessStatus("1");
        ajaxObj.setMessage(message);
        return  ajaxObj;
    }
    public static AjaxSuccessInfo failed(String message){
        AjaxSuccessInfo ajaxObj=new AjaxSuccessInfo();
        ajaxObj.setSuccessStatus("0");
        ajaxObj.setMessage(message);
        return  ajaxObj;
    }
    public static AjaxSuccessInfo success(){
        return  success("操作成功！");
    }
    public static AjaxSuccessInfo failed(){
        return failed("操作失败！");
    }
    public String getSuccessStatus() {
        return successStatus;
    }
    public void setSuccessStatus(String successStatus) {
        this.successStatus = successStatus;
    }

    private void setMessage(String message) {
        this.message = message;
    }
    
    
}
