package com.gyxmb.qywx.controller;

import com.gyxmb.qywx.service.SyncDataService;
import com.gyxmb.qywx.vo.common.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 从企业微信同步数据到数据库CONTROLLER
 * </p>
 *
 * @author DuXueBo
 * @since 2020-04-12 17:25
 */
@RequestMapping("/sync")
@RestController
public class SyncDataController {

    @Autowired
    private SyncDataService syncDataService;


    @GetMapping("/department")
    public ResultVO syncDepartment() {
        this.syncDataService.syncDepartment();
        return ResultVO.getSuccess("同步企业微信部门列表到数据库成功");
    }


}
