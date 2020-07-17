package com.uustop.project.system.student.domain;

import com.uustop.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 学生信息类
 */
public class Student extends BaseEntity {
    /*
   学生id
     */
    private int s_user_id;

    /*学生部门id*/
    private int s_dept_id;

    /*学生登录姓名*/
    private String s_user_name;

    /*学生类型*/
    private String s_user_type;


    /*学生邮箱*/
    private String s_email;

    /*学生电话*/
    private long s_phonenumber;
    /*学生性别*/
    private char s_sex;

    /*学生头像路径*/
    private String s_avatar;

    /*学生密码*/
    private String s_password;

    /*盐加密*/
    private String s_salt;

    /*学生张皓状态*/
    private String s_status;

    /*删除标志*/
    private String s_del_flag;

    /*最后登录的io的值*/
    private String s_login_ip;

    /*学生最后登录的事件*/

    private Date s_login_date;

    /*学生创造者*/
    private String s_create_by;

    /*学生创造事件*/
    private Date s_create_time;

    /*学生信息更新热*/
    private String s_update_by;

    /*学生根性事件*/
    private Date s_update_time;

    /*学生备注*/
    private String s_remark;

    /*学生生日*/
    private Date s_birthday;

    /*学生的qq*/
    private String s_QQ;

    /*增加的根性事件*/
    private Date update_time;

    private String s_login_name;

    public Student(int s_user_id, int s_dept_id, String s_user_name, String s_user_type, String s_email, long s_phonenumber, char s_sex, String s_avatar, String s_password, String s_salt, String s_status, String s_del_flag, String s_login_ip, Date s_login_date, String s_create_by, Date s_create_time, String s_update_by, Date s_update_time, String s_remark, Date s_birthday, String s_QQ, Date update_time, String s_login_name) {
        this.s_user_id = s_user_id;
        this.s_dept_id = s_dept_id;
        this.s_user_name = s_user_name;
        this.s_user_type = s_user_type;
        this.s_email = s_email;
        this.s_phonenumber = s_phonenumber;
        this.s_sex = s_sex;
        this.s_avatar = s_avatar;
        this.s_password = s_password;
        this.s_salt = s_salt;
        this.s_status = s_status;
        this.s_del_flag = s_del_flag;
        this.s_login_ip = s_login_ip;
        this.s_login_date = s_login_date;
        this.s_create_by = s_create_by;
        this.s_create_time = s_create_time;
        this.s_update_by = s_update_by;
        this.s_update_time = s_update_time;
        this.s_remark = s_remark;
        this.s_birthday = s_birthday;
        this.s_QQ = s_QQ;
        this.update_time = update_time;
        this.s_login_name = s_login_name;
    }


    public String getS_login_name() {
        return s_login_name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "s_user_id=" + s_user_id +
                ", s_dept_id=" + s_dept_id +
                ", s_user_name='" + s_user_name + '\'' +
                ", s_user_type='" + s_user_type + '\'' +
                ", s_email='" + s_email + '\'' +
                ", s_phonenumber=" + s_phonenumber +
                ", s_sex=" + s_sex +
                ", s_avatar='" + s_avatar + '\'' +
                ", s_password='" + s_password + '\'' +
                ", s_salt='" + s_salt + '\'' +
                ", s_status=" + s_status +
                ", s_del_flag=" + s_del_flag +
                ", s_login_ip='" + s_login_ip + '\'' +
                ", s_login_date=" + s_login_date +
                ", s_create_by='" + s_create_by + '\'' +
                ", s_create_time=" + s_create_time +
                ", s_update_by='" + s_update_by + '\'' +
                ", s_update_time=" + s_update_time +
                ", s_remark='" + s_remark + '\'' +
                ", s_birthday=" + s_birthday +
                ", s_QQ='" + s_QQ + '\'' +
                ", update_time=" + update_time +
                ", s_login_name='" + s_login_name + '\'' +
                '}';
    }

    public void setS_login_name(String s_login_name) {
        this.s_login_name = s_login_name;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Student(int s_user_id, int s_dept_id, String s_user_name, String s_user_type, String s_email, long s_phonenumber, char s_sex, String s_avatar, String s_password, String s_salt, String s_status, String s_del_flag, String s_login_ip, Date s_login_date, String s_create_by, Date s_create_time, String s_update_by, Date s_update_time, String s_remark, Date s_birthday, String s_QQ, Date update_time) {
        this.s_user_id = s_user_id;
        this.s_dept_id = s_dept_id;
        this.s_user_name = s_user_name;
        this.s_user_type = s_user_type;
        this.s_email = s_email;
        this.s_phonenumber = s_phonenumber;
        this.s_sex = s_sex;
        this.s_avatar = s_avatar;
        this.s_password = s_password;
        this.s_salt = s_salt;
        this.s_status = s_status;
        this.s_del_flag = s_del_flag;
        this.s_login_ip = s_login_ip;
        this.s_login_date = s_login_date;
        this.s_create_by = s_create_by;
        this.s_create_time = s_create_time;
        this.s_update_by = s_update_by;
        this.s_update_time = s_update_time;
        this.s_remark = s_remark;
        this.s_birthday = s_birthday;
        this.s_QQ = s_QQ;
        this.update_time = update_time;
    }

    public Student(int s_user_id, int s_dept_id, String s_user_name, String s_user_type, String s_email, long s_phonenumber, char s_sex, String s_avatar, String s_password, String s_salt, String s_status, String s_del_flag, String s_login_ip, Date s_login_date, String s_create_by, Date s_create_time, String s_update_by, Date s_update_time, String s_remark, Date s_birthday, String s_QQ) {
        this.s_user_id = s_user_id;
        this.s_dept_id = s_dept_id;
        this.s_user_name = s_user_name;
        this.s_user_type = s_user_type;
        this.s_email = s_email;
        this.s_phonenumber = s_phonenumber;
        this.s_sex = s_sex;
        this.s_avatar = s_avatar;
        this.s_password = s_password;
        this.s_salt = s_salt;
        this.s_status = s_status;
        this.s_del_flag = s_del_flag;
        this.s_login_ip = s_login_ip;
        this.s_login_date = s_login_date;
        this.s_create_by = s_create_by;
        this.s_create_time = s_create_time;
        this.s_update_by = s_update_by;
        this.s_update_time = s_update_time;
        this.s_remark = s_remark;
        this.s_birthday = s_birthday;
        this.s_QQ = s_QQ;
    }

    public int getS_user_id() {
        return s_user_id;
    }

    public void setS_user_id(int s_user_id) {
        this.s_user_id = s_user_id;
    }

    public int getS_dept_id() {
        return s_dept_id;
    }

    public void setS_dept_id(int s_dept_id) {
        this.s_dept_id = s_dept_id;
    }

    public String getS_user_name() {
        return s_user_name;
    }

    public void setS_user_name(String s_user_name) {
        this.s_user_name = s_user_name;
    }

    public String getS_user_type() {
        return s_user_type;
    }

    public void setS_user_type(String s_user_type) {
        this.s_user_type = s_user_type;
    }

    public String getS_email() {
        return s_email;
    }

    public void setS_email(String s_email) {
        this.s_email = s_email;
    }

    public long getS_phonenumber() {
        return s_phonenumber;
    }

    public void setS_phonenumber(long s_phonenumber) {
        this.s_phonenumber = s_phonenumber;
    }

    public char getS_sex() {
        return s_sex;
    }

    public void setS_sex(char s_sex) {
        this.s_sex = s_sex;
    }

    public String gets_avatar() {
        return s_avatar;
    }

    public void sets_avatar(String s_avatar) {
        this.s_avatar = s_avatar;
    }

    public String getS_password() {
        return s_password;
    }

    public void setS_password(String s_password) {
        this.s_password = s_password;
    }

    public String getS_salt() {
        return s_salt;
    }

    public void setS_salt(String s_salt) {
        this.s_salt = s_salt;
    }

    public String getS_status() {
        return s_status;
    }

    public void setS_status(String s_status) {
        this.s_status = s_status;
    }

    public String getS_del_flag() {
        return s_del_flag;
    }

    public void setS_del_flag(String s_del_flag) {
        this.s_del_flag = s_del_flag;
    }

    public String getS_login_ip() {
        return s_login_ip;
    }

    public void setS_login_ip(String s_login_ip) {
        this.s_login_ip = s_login_ip;
    }

    public Date getS_login_date() {
        return s_login_date;
    }

    public void setS_login_date(Date s_login_date) {
        this.s_login_date = s_login_date;
    }

    public String getS_create_by() {
        return s_create_by;
    }

    public void setS_create_by(String s_create_by) {
        this.s_create_by = s_create_by;
    }

    public Date getS_create_time() {
        return s_create_time;
    }

    public void setS_create_time(Date s_create_time) {
        this.s_create_time = s_create_time;
    }

    public String getS_update_by() {
        return s_update_by;
    }

    public void setS_update_by(String s_update_by) {
        this.s_update_by = s_update_by;
    }

    public Date getS_update_time() {
        return s_update_time;
    }

    public void setS_update_time(Date s_update_time) {
        this.s_update_time = s_update_time;
    }

    public String getS_remark() {
        return s_remark;
    }

    public void setS_remark(String s_remark) {
        this.s_remark = s_remark;
    }

    public Date getS_birthday() {
        return s_birthday;
    }

    public void setS_birthday(Date s_birthday) {
        this.s_birthday = s_birthday;
    }

    public String getS_QQ() {
        return s_QQ;
    }

    public void setS_QQ(String s_QQ) {
        this.s_QQ = s_QQ;
    }

    public Student() {}
}
