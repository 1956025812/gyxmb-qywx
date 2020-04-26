package com.gyxmb.qywx.service.impl;

import com.gyxmb.qywx.constant.DepartmentConstant;
import com.gyxmb.qywx.service.QywxApiService;
import com.gyxmb.qywx.service.SyncDataService;
import com.gyxmb.qywx.vo.qywxapi.DepartmentApiVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 从企业微信同步数据到数据库SERVICE接口实现类
 * </p>
 *
 * @author DuXueBo
 * @since 2020-04-12 17:38
 */
@Service
@Slf4j
public class SyncDataServiceImpl implements SyncDataService {

    @Autowired
    private QywxApiService qywxApiService;

    @Override
    public void syncDepartment() {
        log.info("同步企业微信的部门列表到数据库");

        List<DepartmentApiVO> departmentApiVOList = this.qywxApiService.selectDepartmentList(DepartmentConstant.ROOT_ID);
        if (CollectionUtils.isEmpty(departmentApiVOList)) {
            log.info("当前企业微信并没有部门，不需要同步");
            return;
        }

    }
}
