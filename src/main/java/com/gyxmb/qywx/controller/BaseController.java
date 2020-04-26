package com.gyxmb.qywx.controller;

import com.gyxmb.qywx.vo.common.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 基础控制类
 * </p>
 *
 * @author DuXueBo
 * @since 2020-04-26
 */
@ControllerAdvice
@RestController
@Slf4j
public class BaseController {

    @ExceptionHandler(value = Exception.class)
    public ResultVO globalExceptionHandle(Exception e) {
        log.error("发生异常, 异常信息如下:", e);
        return ResultVO.getFailed(e.getMessage());
    }

}