package com.newsmanagersys.validation;

import com.newsmanagersys.entity.UserInfo;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 这个是UserInfo的验证类
 */
public class UserInfoValidation implements Validator {
    //验证是否是UserInfo类型
    @Override
    public boolean supports(Class<?> clazz) {
        return UserInfo.class.equals(clazz);
    }


    //定义验证规则
    @Override
    public void validate(Object o, Errors errors) {
        //将Object强转为UserInfo对象
        if(o!=null){
            UserInfo userinfo=(UserInfo) o;
            if(userinfo.getUrealname()==null){
                errors.rejectValue("urealname",null,"用户真实姓名不能为空！");
            }
            if(userinfo.getUage()<6||userinfo.getUage()>60){
               errors.rejectValue("uage",null,"用户年龄输入不合法!");
        }
            if(userinfo.getUtel()!=null&&userinfo.getUtel().length()>0){
                String regex="^1[3|4|5|8][0-9]\\d{8}$";
                if(!userinfo.getUtel().matches(regex)){
                    errors.rejectValue("utel",null,"用户手机号码输入不合法!");
                }
            }
            if(userinfo.getUemail()!=null&&userinfo.getUemail().length()>0){
                String regex="^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}$";
                if(!userinfo.getUemail().matches(regex)){
                    errors.rejectValue("uemail",null,"用户邮箱输入不正确!");
                }
            }
        }
    }
}
