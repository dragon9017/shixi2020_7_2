package com.uustop.project.system.student.mapper;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.uustop.project.system.student.domain.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.omg.CORBA.INTERNAL;

import java.security.PublicKey;
import java.util.List;

/**
 * 学生信息管理
 */
public interface StudentMapper {

    /*根据id查询一条数据*/
    public Student SelectStudentByStudent_id(@Param("s_user_id") Integer s_user_id);
    /*1. 显示全部学生信息*/
    public List<Student> SelectStudentList(Student student);

    /*2. 根据学生姓名，学生班级，手机号，用户状态查询*/
    public List<Student> SelectStudentBymethod(@Param("s_user_name") String s_user_name,@Param("s_dept_id")Integer s_dept_id,@Param("s_phonenumber")Integer s_phonenumber,@Param("s_user_type")char s_user_type);

    /*4. 添加学生*/
    public int InsertStudent(@Param("student") Student student);

    /*5. 修改用户信息*/
    public int UpdateStudent(@Param("student") Student student);

    /*6. 修改用户状态*/
    public int UpdateStudentType(@Param("student")Student student);

    /*7. 充值姓名和密码*/
    public int UpdateStudentNamePass(@Param("s_user_id") Integer s_user_id,@Param("s_user_name") String s_user_name,@Param("s_user_password") String s_user_password);

    /*8. 删除信息*/
    public int DeleateStudent(@Param("s_user_id") Integer s_user_id);


    /*9. 根据id查询全部细腻*/
    public Student Select_student_by_id(@Param("s_user_id") Long s_user_id);


    /*根据用户id查询用户状态*/
    public int Select_status_by_id(@Param("s_user_id") long s_user_id);


    /*修改密码*/
    public int UpdateStudentPassword(@Param("student") Student student);


    /*添加用户*/
    public int Insert_student_byid(@Param("student") Student student);


    /*检验用户是否唯一*/
    public int Select_count_loginName(@Param("s_login_name") String s_login_name);

    /*检验电话号码是否唯一*/
    public Student Select_count_Phonenumber(@Param("s_phonenumber") long s_phonenumber);

    /*检验电子邮箱是否唯一*/
    public Student Select_count_email(@Param("s_email") String s_email);

}
