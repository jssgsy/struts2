package com.univ.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/** 
 * @author: liuml
 * @date: 2015年8月28日 上午10:38:06 
 * @version: 1.0 
 * @description: 
 */

public class FileDownload extends ActionSupport {
	  
	//获取下载的文件名，便于在文件下载框中显示，有且只需要有get方法
    private String fileName;      
    public String getFileName() {  
        return fileName;  
    }  
  
    public InputStream getDownloadFile() throws Exception  
    {  	
    	//含有中文的文件名需要转码
    	this.fileName = new String("上大小伙伴.jpg".getBytes(), "ISO8859-1");  
    	//获取资源路径  
    	return ServletActionContext.getServletContext().getResourceAsStream("upload/上大小伙伴.jpg") ;  
    }  
      
    @Override  
    public String execute() throws Exception {  	
    	System.out.println("success");
    	return SUCCESS;  
    }  
}


