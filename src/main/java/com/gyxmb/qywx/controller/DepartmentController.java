package com.gyxmb.qywx.controller;


import com.gyxmb.qywx.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 企业微信部门CONTROLLER
 * </p>
 *
 * @author DuXueBo
 * @since 2020-04-12
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;




}
