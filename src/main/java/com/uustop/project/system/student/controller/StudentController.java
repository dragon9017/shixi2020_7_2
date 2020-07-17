package com.uustop.project.system.student.controller;

import java.util.List;

import com.uustop.project.system.student.domain.Student;
import com.uustop.project.system.student.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.uustop.common.utils.StringUtils;
import com.uustop.common.utils.poi.ExcelUtil;
import com.uustop.framework.aspectj.lang.annotation.Log;
import com.uustop.framework.aspectj.lang.enums.BusinessType;
import com.uustop.framework.web.controller.BaseController;
import com.uustop.framework.web.domain.AjaxResult;
import com.uustop.framework.web.page.TableDataInfo;
import com.uustop.project.system.role.service.IRoleService;
import com.uustop.project.system.user.domain.User;
import com.uustop.project.system.user.service.IUserService;

/**
 * 用户信息
 *
 * @author uustop
 */
@Controller
@RequestMapping("/system/student")
public class StudentController extends BaseController
{
    private String prefix = "system/student";

    @Autowired
    private StudentService studentService;
    @Autowired
    private IRoleService roleService;

    @RequiresPermissions("system:student:view")
    @GetMapping()
    public String student()
    {
        return prefix + "/student";
    }
    @RequiresPermissions("system:student:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Student student)
    {
        /*Student student=new Student();
        if (s_login_name!=null&&s_login_name.equals("")&&s_user_name!=null&&s_user_name.equals("")&&s_phonenumber!=0){
            List<Student> students = studentService.SelectStudentList(student);
            return getDataTable(students);
        }
        student.setS_login_name(s_login_name);
        student.setS_phonenumber(s_phonenumber);
        student.setS_user_name(s_user_name);*/
        startPage();
        List<Student> students = studentService.SelectStudentList(student);
        return getDataTable(students);
    }

    /*修改用户细腻*/
    @GetMapping("/edit/{s_user_id}")
    public String edit(@PathVariable("s_user_id") Long s_user_id, ModelMap mmap)
    {
        /*通过id查询用户细腻*/
        mmap.put("student", studentService.Select_student_by_id(s_user_id));
        mmap.put("roles", roleService.selectRolesByUserId(s_user_id));
        return prefix + "/edit";
    }
    @RequiresPermissions("system:student:edit")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    /*根性数据*/
    public AjaxResult editSave(Student student) {
        System.out.println("进入修改的方法");
        /*if (StringUtils.isNotNull(student.getS_user_id()) && Student.isAdmin(student.getS_user_id()))
        {
            return error("不允许修改超级管理员用户");
        }*/
        System.out.println("修改后的信息"+student);
        return toAjax(studentService.UpdateStudent(student));
    }

    /*修改当前状态*/
    @Log(title = "用户管理", businessType = BusinessType.STATUS)
    @RequiresPermissions("system:student:status")
    @PostMapping("/status/{s_user_id}")
    @ResponseBody
    public AjaxResult status(@PathVariable("s_user_id") Long s_user_id)
    {
        try
        {
            return toAjax(studentService.Select_status_by_id(s_user_id));
        }catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    @RequiresPermissions("system:student:remove")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove/{s_user_id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("s_user_id") long s_user_id)
            /*删除就是解绑，只是解除绑定，信息还是存在的，不能删除*/ {
        try {
            return toAjax(studentService.DeleateUser(s_user_id));
        }
        catch (Exception e) {
            return error(e.getMessage());
        }
    }


    @RequiresPermissions("system:student:resetPwd")
    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @GetMapping("/resetPwd/{s_user_id}")
    public String resetPwd(@PathVariable("s_user_id") Long s_user_id, ModelMap mmap)
    {
        mmap.put("student", studentService.Select_student_by_id(s_user_id));
        return prefix + "/resetPwd";
    }

    @RequiresPermissions("system:student:resetPwd")
    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwd(Student student)
    {
        System.out.println("修改的对象"+student);
        return toAjax(studentService.Update_student_password(student));
    }


    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("roles", roleService.selectRoleAll());
        return prefix + "/add";
    }

    @RequiresPermissions("system:student:add")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(Student student)
    {
        /*if (StringUtils.isNotNull(student.getS_user_id()))
        {
            return error("不允许修改超级管理员用户");
        }*/
        return toAjax(studentService.Insert_student_byid(student));
    }

    /**
     * 检验登录名
     * @param
     * @return
     */

    @PostMapping("/checkLoginNameUnique")
    @ResponseBody
    public String checkLoginNameUnique(Student student)
    /*检验当前用户的记录数是否超过一，如果超过，则存在重复用户*/
    {
        return studentService.Select_count_loginName(student.getS_login_name());
    }

    /**
     * 检验电话号码
     * @param
     * @return
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPhoneUnique(Student student)
    {
        return studentService.Select_count_Phonenumber(student);
    }

    /**
     * 检验电子邮箱
     * @param
     * @return
     */
    @PostMapping("/checkEmailUnique")
    @ResponseBody
    public String checkEmailUnique(Student student)
    {
        return studentService.Select_count_email(student);
    }





}