package com.univ.action;

import com.opensymphony.xwork2.ActionSupport;

/** 
 * @author: liuml
 * @date: 2015年7月28日 上午10:18:47 
 * @version: 1.0 
 * @description: 只是为了拦截器演示使用
 */

public class IntercepterAction extends ActionSupport {

	public String execute(){
		System.out.println("访问到用来是为单个action设置的univ.action.IntercepterAction.execute()中了");
		return "success";
	}
}


