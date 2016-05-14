package com.univ.interceptor;

import org.apache.struts2.dispatcher.ServletDispatcherResult;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/** 
 * @author: liuml
 * @date: 2015年7月28日 上午10:12:46 
 * @version: 1.0 
 * @description: 全局拦截器，拦截所有的action
 */

public class GlobalActionInterceptor extends AbstractInterceptor {
	/**
	 * 注意两个方法：
	 * 1：获取被拦截的action：invocation.getAction()；
	 * 2：获取被拦截的action的某个方法的返回视图资源的字符串：String result = invocation.invoke()
	 */

	private String globleName ;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//身份认证，看是否有登陆
		if(ActionContext.getContext().getSession().get("username")==null){
			System.out.println("请先登陆。");
			return "login";
		}
		System.out.println("进入到全局拦截器中了==============");
		System.out.println("为全局拦截器设置的参数名为： " + globleName);
		//获取被拦截的action的名字
		System.out.println("被拦截的action的名字为：" + invocation.getAction().getClass().getName());
		//用下面的方法也可以取得被拦截的action的名字
//		System.out.println(invocation.getInvocationContext().getName()); 
		/**
		 * 执行该拦截器后的下一个拦截器，如果该拦截器后没有其他拦截器，则直接执行action被拦截的方法
		 */
		String resultCode = invocation.invoke();
		System.out.println("被拦截的action的方法的返回视图字符串为： " + resultCode);
		
		/**如果返回类型是转发，则输出跳转到的jsp页面名称
		 * 在Action和Result运行之后，得到Result对象，并且可以强制转换成ServletDispatcherResult
		 */
		Result result = invocation.getResult();
		if (result instanceof ServletDispatcherResult) {
			ServletDispatcherResult sdr = (ServletDispatcherResult) result;
			System.out.println("action执行返回的结果视图为:" + sdr.getLastFinalLocation());
		}
		return resultCode;
	}

	/**
	 * 为globleName设置setter方法，这样就可以获取struts.xml中为拦截器配置的名为globleName的属性值。
	 * 这种方法和过滤器获取参数方法有些不同，过滤器是通过给方法传递一个参数，然后通过这个方法参数获取filter的配置参数
	 * @param globleName
	 */
	public void setGlobleName(String globleName) {
		this.globleName = globleName;
	}
	
	

}


