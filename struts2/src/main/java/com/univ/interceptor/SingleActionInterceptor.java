package com.univ.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.univ.action.IntercepterAction;

/** 
 * @author: liuml
 * @date: 2015年7月28日 上午10:12:46 
 * @version: 1.0 
 * @description: 只拦截univ.action.IntercepterAction的action
 */

public class SingleActionInterceptor extends AbstractInterceptor {
	/**
	 * 注意两个方法：
	 * 1：获取被拦截的action：invocation.getAction()；
	 * 2：获取被拦截的action的某个方法的返回视图资源的字符串：String result = invocation.invoke()
	 */
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("进入到univ.interceptor.SingleActionInterceptor.intercept()中了");
		//获取被拦截的action
		IntercepterAction action = (IntercepterAction) invocation.getAction();
		System.out.println("被拦截的拦截器应该是univ.action.IntercepterAction:  " + action.getClass().getName());
		
		/**
		 * 执行该拦截器后的下一个拦截器，如果该拦截器后没有其他拦截器，则直接执行action被拦截的方法
		 */
		String result = invocation.invoke();
		
		System.out.println("被拦截的action的方法的返回视图资源的字符串为： " + result);
		return result;
	}

}


