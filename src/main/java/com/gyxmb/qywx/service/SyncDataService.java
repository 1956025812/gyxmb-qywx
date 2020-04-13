package com.gyxmb.qywx.service;

import com.gyxmb.qywx.vo.common.ResultVO;

/**
 * <p>
 * 从企业微信同步数据到数据库SERVICE接口
 * </p>
 *
 * @author DuXueBo
 * @since 2020-04-12 17:37
 */
public interface SyncDataService {

    /**
     * 同步企业微信部门列表到数据库
     */
    void syncDepartment();


}
