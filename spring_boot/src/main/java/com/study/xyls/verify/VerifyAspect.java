package com.study.xyls.verify;

import com.study.xyls.vo.MvcResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;


/**
 * Created by ipaynow1130 on 2017/12/7.
 */
@Aspect
@Component
public class VerifyAspect {


    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object verify(ProceedingJoinPoint joinPoint) {
        Object ret = null;
        try {
            ret = joinPoint.proceed();
            if(joinPoint.getArgs().length > 0) {
                for (Object arg : joinPoint.getArgs()){
                    if (arg instanceof BindingResult){
                        BindingResult result = (BindingResult) arg;
                        if (result.hasErrors()) {
                            StringBuilder stringBuilder = new StringBuilder();
                            for (ObjectError error : result.getAllErrors()){
                                stringBuilder.append(error.getDefaultMessage());
                            }
                            return MvcResponse.generrateFailMvcResponse(stringBuilder.toString());
                        }
                    }
                }

            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return ret;
    }


}
