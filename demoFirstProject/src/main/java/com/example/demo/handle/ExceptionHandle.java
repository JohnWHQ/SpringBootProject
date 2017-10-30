package com.example.demo.handle;

import com.example.demo.aspect.HttpAspect;
import com.example.demo.domain.Result;
import com.example.demo.utils.ResultUtil;
import com.example.demo.exception.PersonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result ExceptionHandle(Exception e){

        if (e instanceof PersonException) {
            PersonException personException = (PersonException) e;
            return ResultUtil.fail(personException.getCode(), personException.getMessage());
        }
        logger.error("内部异常{}", e);
        return ResultUtil.fail(-1, e.getMessage());
    }

}
