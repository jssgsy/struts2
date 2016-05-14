package com.univ.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/** 
 * @author: liuml
 * @date: 2015年7月28日 上午9:55:19 
 * @version: 1.0 
 * @description: 
 */

public class AjaxAction extends ActionSupport {

	public void processAjax() throws IOException{	//这是直接利用response响应ajax请求的示例；不用返回值；
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");//id是点击节点前的加号时自动发送ajax请传过来的。
		PrintWriter out = response.getWriter();
		String timestamp = "[{\"id\":1,\"text\":\"node1\",\"state\":\"closed\"}]";
		out.println(timestamp);
		out.close();
	}

}


