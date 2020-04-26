package com.gyxmb.qywx.controller;


import com.gyxmb.qywx.entity.Department;
import com.gyxmb.qywx.service.DepartmentService;
import com.gyxmb.qywx.vo.common.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 企业微信部门表 前端控制器
 * </p>
 *
 * @author DuXueBo
 * @since 2020-04-26
 */
@Api(tags = "部门控制类")
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;


    @ApiOperation("查询部门列表")
    @GetMapping("/list")
    public ResultVO selectDepartmentList() {
        List<Department> list = this.departmentService.list();
        return ResultVO.getSuccess("", list);
    }


}
