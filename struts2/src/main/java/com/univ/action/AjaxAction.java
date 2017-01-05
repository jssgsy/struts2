package com.univ.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.univ.entity.Student;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author: liuml
 * @date: 2015年7月28日 上午9:55:19
 * @version: 1.0
 * @description:
 */

public class AjaxAction extends ActionSupport {
    private Map jsonMap;//用来序列化的属性只需要getter方法

    private Student stu;

    public Map getJsonMap() {
        return jsonMap;
    }

    public Student getStu() {
        return stu;
    }

    //这是直接利用response输出json的示例；不用返回值；
    public void processAjax() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        //id是点击节点前的加号时自动发送ajax请传过来的。
        String id = request.getParameter("id");
        PrintWriter out = response.getWriter();
        String timestamp = "[{\"id\":1,\"text\":\"node1\",\"state\":\"closed\"}]";
        out.println(timestamp);
        out.close();
    }

    public String processAjax2() {
        init();
        return "jsonResult2";
    }

    public String processAjax3() {
        init();
        return "jsonResult3";
    }

    public String processAjax4() {
        init();
        return "jsonResult4";
    }

    public String processAjax5() {
        stu = new Student();
        //让name属性的值为null
        stu.setAge(10);
        return "jsonResult5";
    }

    public String normal1() {
        return "normal1";
    }

    public String normal2() {
        return "normal2";
    }

    private void init() {
        jsonMap = new HashMap();
        jsonMap.put("name", "univ");
        jsonMap.put("age", 26);
        jsonMap.put("address", "hubei");
        jsonMap.put("good", true);

        stu = new Student();
        stu.setAge(100);
        stu.setName("asdf");
    }

}


