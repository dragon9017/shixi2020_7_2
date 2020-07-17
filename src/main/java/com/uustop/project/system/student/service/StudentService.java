package com.uustop.project.system.student.service;

import com.uustop.project.system.student.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    /*1. 显示全部学生信息*/
    public List<Student> SelectStudentList(@Param("student") Student student);

    /*2. 多条件查询*/
    public List<Student> SelectStudentBymethod(@Param("s_user_name") String s_user_name, @Param("s_dept_id")Integer s_dept_id, @Param("s_phonenumber")Integer s_phonenumber, @Param("s_user_type")char s_user_type);

    /*4. 添加学生*/
    public int InsertStudent(@Param("student") Student student);

    /*9. 根据id查询全部细腻*/
    public Student Select_student_by_id(@Param("s_user_id") Long s_user_id);

    /*10.根据用户id查询用户状态*/
    public int Select_status_by_id(@Param("s_user_id") long s_user_id);

    /*5. 修改用户信息*/
    public int UpdateStudent(@Param("student") Student student);

    /*删除用户状态，解绑*/
    public int DeleateUser(@Param("s_user_id") long s_user_id);


    /*充值用户密码*/
    public int Update_student_password(@Param("student") Student student);


    /*添加用户*/
    public int Insert_student_byid(@Param("student") Student student);


    /*检验用户是否唯一*/
    public String Select_count_loginName(@Param("s_login_name") String s_login_name);

    /*检验电话号码是否唯一*/
    public String Select_count_Phonenumber(@Param("student") Student student);

    /*检验电子邮箱是否唯一*/
    public String Select_count_email(@Param("student") Student student);



}
