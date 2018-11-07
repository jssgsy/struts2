package com.univ.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * @author: liuml
 * @date: 2015年7月27日 下午1:56:19 
 * @version: 1.0 
 * @description: 用以测试在action中使用servlet中的相关对象;
 * 显然不能直接使用servlet中的request，session，servletContext等对象;
 * 重点是掌握如何在struts2的action中获取各种servlet对象的方法：
 * 1)利用ActionContext可以获得servlet中的两个域，即session和application
 * 		注意伪访问ActionContext实例的获取方法：ActionContext actionContext = ActionContext.getContext();
 * 2)利用ServletActionContext.getXXX()获得HttpServletRequest，HttpServletResponse,ServletContext等对象
 * 
 * 补充：在action中获取servlet相关对象的正确方法是，实现相应的接口。
 * 如ServletRequestAware，ServletResponseAware，SessionAware等（都是struts2中的接口）
 */

public class ServletAction extends ActionSupport implements ServletRequestAware {

	private HttpServletRequest request = null;
	/**
	 * 获得HttpServletRequest对象
	 */
	public String request(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		request.setAttribute("name", name);
		request.setAttribute("age", age);//不设置这两句否则没法传到前台
		System.out.println("从前台放在超链接中传过来的name: " + name);
		System.out.println("从前台放在超链接中传过来的age: " + age);
		return "request";
	}
	
	/**
	 * 这是正确的获取request对象的方法，利用实现接口ServletRequestAware
	 */
	public String request2(){		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		request.setAttribute("name", name);
		request.setAttribute("age", age);//不设置这两句否则没法传到前台
		System.out.println("从前台放在超链接中传过来的name: " + name);
		System.out.println("从前台放在超链接中传过来的age: " + age);
		return "request";
	}
	
	
	/** 获得HttpServletResponse对象
	 *此方法没有定义相应的视图，只是演示如何在action中获取HttpServletResponse对象
	 */
	public String response(){
		HttpServletResponse response = ServletActionContext.getResponse();		
		return "response";
	}
	
	/**
	 * 获得actionContext.getSession()对象，注意是个map
	 */
	public String session(){
		ActionContext actionContext = ActionContext.getContext();
		//actionContext.getName()的结果为：servletAction;		
			
		actionContext.getSession().put("name", "actionContext.getSession().put");
		return "session";
	}
	
	/**
	 * 获得actionContext.getApplication()对象，注意是个map
	 */
	public String servletContext(){
		ActionContext actionContext = ActionContext.getContext();
		actionContext.getApplication().put("name", "actionContext.getApplication().put");
		return "servletContext";
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}


