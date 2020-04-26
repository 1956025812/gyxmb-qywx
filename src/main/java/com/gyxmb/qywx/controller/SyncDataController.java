package com.gyxmb.qywx.controller;

import com.gyxmb.qywx.service.SyncDataService;
import com.gyxmb.qywx.vo.common.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 从企业微信同步数据到数据库CONTROLLER
 * </p>
 *
 * @author DuXueBo
 * @since 2020-04-12 17:25
 */
@Api(tags = "同步数据控制类")
@RequestMapping("/sync")
@RestController
public class SyncDataController extends BaseController {

    @Resource
    private SyncDataService syncDataService;


    @ApiOperation("同步部门数据")
    @GetMapping("/department")
    public ResultVO syncDepartment() {
        this.syncDataService.syncDepartment();
        return ResultVO.getSuccess("同步企业微信部门列表到数据库成功");
    }


}
