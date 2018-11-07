package com.univ.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * @author: liuml
 * @date: 2015年8月28日 下午4:13:42 
 * @version: 1.0 
 * @description: 
 */

public class LoginAction extends ActionSupport {

	private String username;
	private String password;
	
	/**
	 * 登录时验证此用户是否存在
	 * @return
	 */
	public String login(){
		if ("lml".equals(username) && "123".equals(password)) {
			System.out.println("---------------hello----------------");
			//加入session中，便于在拦截器进行身份认证
			ActionContext.getContext().getSession().put("username", username);
			return "success";
		} else {
			return "login";
		}
	}
	
	/**
	 * 退出登录
	 */
	public String logout(){
		ActionContext.getContext().getSession().remove("username");
		return "login";
	}
	
	
	
	
//	 下面是getter and setter 方法
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}


