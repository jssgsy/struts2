package com.univ.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/** 
 * @author: liuml
 * @date: 2015年7月26日 下午8:00:10 
 * @version: 1.0 
 * @description: 用来比较其和struts2的拦截器的初始化顺序，经验证，拦截器的初始化在前
 */

public class EncoderFilter implements Filter {

	private String encoding = null;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("EncoderFilter init");
		encoding = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("EncoderFilter doFilter");
		String requestEncoding = request.getCharacterEncoding();
		if(requestEncoding == null || !requestEncoding.equals(encoding)){
			request.setCharacterEncoding(encoding);
		}
		response.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// FIXME Auto-generated method stub

	}

}


