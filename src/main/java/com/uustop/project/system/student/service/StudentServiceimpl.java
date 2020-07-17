package com.uustop.project.system.student.service;

import com.uustop.common.constant.UserConstants;
import com.uustop.common.utils.StringUtils;
import com.uustop.common.utils.security.ShiroUtils;
import com.uustop.framework.shiro.service.PasswordService;
import com.uustop.project.system.student.domain.Student;
import com.uustop.project.system.student.mapper.StudentMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.EmptyStackException;
import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {

    @Resource
    StudentMapper studentMapper;

    @Resource
    PasswordService passwordService;
    /*1. 显示全部学生信息*/
    public List<Student> SelectStudentList(@Param("student") Student student){
        List<Student> students = studentMapper.SelectStudentList(student);
        System.out.println(students);
        return students;
    }

    /*2. 多条件查询*/
    public List<Student> SelectStudentBymethod(@Param("s_user_name") String s_user_name, @Param("s_dept_id")Integer s_dept_id, @Param("s_phonenumber")Integer s_phonenumber, @Param("s_user_type")char s_user_type){
        List<Student> students = studentMapper.SelectStudentBymethod(s_user_name, s_dept_id, s_phonenumber, s_user_type);
        System.out.println(students);
        return students;
    }

    /*4. 添加学生*//*传入值无法直接传入对象*/
    public int InsertStudent(@Param("student") Student student){
        int i = studentMapper.InsertStudent(student);
        System.out.println("插入成功"+i);
        return i;
    }

    /*9. 根据id查询全部细腻*/
    public Student Select_student_by_id(@Param("s_user_id") Long s_user_id){
        Student student = studentMapper.Select_student_by_id(s_user_id);
        System.out.println(student);
        return student;
    }

    @Override
    public int Select_status_by_id(long s_user_id) {
        Student student = studentMapper.Select_student_by_id(s_user_id);
        System.out.println("获取的学生的状态"+student.getS_status());
        /*判断c的取值*/
        if (student.getS_status().equals("1")){
            student.setS_status("0");
        }
        else {
            student.setS_status("1");
        }
        System.out.println("修改陈宫"+student.getS_status());
        /*修改完需要根性数据*/
        student.setS_update_by(ShiroUtils.getLoginName());
        return studentMapper.UpdateStudent(student);
    }


    /*修改用户信息*/
    /*5. 修改用户信息*/
    public int UpdateStudent(@Param("student") Student student){
        System.out.println("进入修改程序");
        int i = studentMapper.UpdateStudent(student);
        System.out.println("修改成功"+i);
        return i;
    }



    /*用户解绑*/

    @Override
    public int DeleateUser(long s_user_id) {
        /*判断是否为超级用户*/
        /*1. 拿到用户信息*/
        Student student = studentMapper.Select_student_by_id(s_user_id);
            student.setS_del_flag("1");
            student.setUpdateBy(ShiroUtils.getLoginName());
        System.out.println(student);
            studentMapper.UpdateStudent(student);
        return 1;
    }

    @Override
    public int Update_student_password(Student student) {
       /* student.setS_password(passwordService.encryptPassword(student.getS_login_name(), student.getS_password(), student.getS_salt()));
        int i = studentMapper.UpdateStudent(student);*/
        int i = studentMapper.UpdateStudentPassword(student);
        return i;

    }


    /*添加用户*/
    public int Insert_student_byid(@Param("student") Student student){
        int i = studentMapper.Insert_student_byid(student);
        return i;
    }

    /*检验用户是否唯一*/
    public String Select_count_loginName(@Param("s_login_name") String s_login_name){
        int i = studentMapper.Select_count_loginName(s_login_name);
        if (i > 0) {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }

    /*检验电话号码是否唯一*/
    public String Select_count_Phonenumber(@Param("student") Student student){
        /*拿到输入的用户的id*/
        int s_user_id = student.getS_user_id();
        System.out.println("用户的手机号"+student.getS_phonenumber());
        Student student1 = studentMapper.Select_count_Phonenumber(student.getS_phonenumber());

        if (StringUtils.isNotNull(student1) && student1.getS_user_id()!= s_user_id) {
            return UserConstants.USER_PHONE_NOT_UNIQUE;
        }
        return UserConstants.USER_PHONE_UNIQUE;
    }


    /*检验电子邮箱是否唯一*/
    public String Select_count_email(@Param("student") Student student){
        /*拿到输入的用户的id*/
        int s_user_id = student.getS_user_id();
        Student student1 = studentMapper.Select_count_email(student.getS_email());
        /*拿到查出的id*/

        if (StringUtils.isNotNull(student1) && student1.getS_user_id()!= s_user_id) {
            return UserConstants.USER_PHONE_NOT_UNIQUE;
        }
        return UserConstants.USER_PHONE_UNIQUE;
    }
}
