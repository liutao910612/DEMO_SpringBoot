package com.liutao.utilitys;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 参数验证工具类
 *
 * @author LIUTAO
 * @version 2017/5/19
 * @see
 * @since
 */
public class ValidateUtility {
    /**
     * 判断是否有验证错误信息
     * @param result
     * @return
     */
    public static String judgeValidate(BindingResult result, HttpServletResponse response) {
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            StringBuilder stringBuilder = new StringBuilder();
            for(ObjectError  error:list){
                stringBuilder.append("\n"+error.getDefaultMessage());
            }
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return stringBuilder.toString();
        }
        return "ok";
    }
}
