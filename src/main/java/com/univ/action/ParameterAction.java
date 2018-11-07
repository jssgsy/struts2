package com.univ.action;

import com.opensymphony.xwork2.ActionSupport;
import com.univ.entity.Student;

import java.util.Arrays;
import java.util.List;

/**
 * Univ
 * 2017/1/14 19:43
 */

/**
 * 用来测试前台传值的各种形式
 *
 * 简单类型传值的形式：name="id";
 * 复合类型传值的形式为：name="student.name";
 * List类型传值的形式为：name="stuList[0].name
 * 普通数组类型传值的形式：name="strArr";和简单类型传值的方式一模一样,不过可以传递多个值，如checkbox，当然用集合来接收也可以
 * 一般都不会传set类型，因为set类型无序
 *
 */
public class ParameterAction extends ActionSupport {

    private Long id;//普通类型

    private Student student;//复合类型

    private List<Student> stuList;//List类型

    private String[] strArr;//简单数组类型

    public String parameter(){
        System.out.println("id值为： " + id);
        System.out.println("student.name值为： " + student.getName());
        System.out.println("stuList[0].name值为： " + stuList.get(0).getName());
        System.out.println("strArr值为： " + Arrays.toString(strArr));
        return "parameter";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStuList() {
        return stuList;
    }

    public void setStuList(List<Student> stuList) {
        this.stuList = stuList;
    }

    public String[] getStrArr() {
        return strArr;
    }

    public void setStrArr(String[] strArr) {
        this.strArr = strArr;
    }
}
