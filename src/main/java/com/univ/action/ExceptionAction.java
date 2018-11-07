package com.univ.action;

/**
 * Univ
 * 2017/1/13 16:12
 */

import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;

/**
 * 演示struts2的异常处理机制
 */
public class ExceptionAction extends ActionSupport{

    public String exception1(){
        //抛一个unchecked的空指针异常
        throw new NullPointerException("o o, 我抛出了一个空指针NullPointerException。");
    }

    public String exception2() throws SQLException{
        //抛一个checked的空指针异常
        throw new SQLException("o o, 我抛出了一个SQLException。");
    }

    public String exception3() throws Exception{
        //抛一个顶层的Exception异常
        throw new Exception("o o 我抛出了一个顶层异常。");
    }

    public String exception4() throws Exception{
        //抛一个没有struts.xml中定义但是Exception子类异常
        throw new ClassCastException("o o 抛一个没有struts.xml中定义但是Exception子类异常，看来也能被定义的Exception映射捕获");
    }

}
