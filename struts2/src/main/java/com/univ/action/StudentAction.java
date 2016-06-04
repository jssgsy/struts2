package com.univ.action;

import com.opensymphony.xwork2.ActionSupport;
import com.univ.entity.Student;

/** 
 * @author: liuml
 * @date: 2015年7月26日 下午4:17:22 
 * @version: 1.0 
 * @description: 
 */

public class StudentAction extends ActionSupport {
	private static final long serialVersionUID = 6586345043270452213L;
	private Student student;

    /*
    可使用数组接收复选框的值
     */
	private String[] city;

	@Override
	public String execute() throws Exception{
		System.out.println("前台传过来的student.name:" + student.getName());
		System.out.println("前台传过来的student.age:" + student.getAge());
		return SUCCESS;
	}
	
	public String test(){
		System.out.println("进入到 univ.action.StudentAction.test()");
		System.out.println("前台传过来的student.name:" + student.getName());
		System.out.println("前台传过来的student.age:" + student.getAge());
		return SUCCESS;
	}

	public String checkbox(){
		for (String c : city) {
			System.out.println(c);

		}

		return "checkbox";
	}

	//--------------------------------------getter and setter--------------------------------------
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	public String[] getCity() {
		return city;
	}

	public void setCity(String[] city) {
		this.city = city;
	}
}


