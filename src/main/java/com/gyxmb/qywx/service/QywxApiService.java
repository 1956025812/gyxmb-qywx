package com.gyxmb.qywx.service;

import com.gyxmb.qywx.vo.qywxapi.DepartmentApiVO;

import java.util.List;

/**
 * @author : DuXueBo
 * @date : 2020-04-12 14:50
 * @ Description : 企业微信SERVICE
 */
public interface QywxApiService {

    /**
     * 获取靠近应用的ACCESS_TOKEN
     *
     * @return ACCESS_TOKEN
     */
    String acquireKaojinAccessToken();


    /**
     * 调用API获取企业微信的部门列表及其所有子部门列表
     *
     * @param deptId 部门ID
     * @return 如果不传值，返回所有部门，传值返回指定部门及其所有子部门列表
     */
    List<DepartmentApiVO> selectDepartmentList(Integer deptId);
}
