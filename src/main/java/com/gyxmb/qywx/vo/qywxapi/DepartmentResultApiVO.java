package com.gyxmb.qywx.vo.qywxapi;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 企业微信API获取部门列表返回的对象
 * </p>
 *
 * @author DuXueBo
 * @since 2020-04-12 18:05
 */
@Data
public class DepartmentResultApiVO implements Serializable {

    private static final long serialVersionUID = 494033000438423195L;

    private Integer errcode;
    private String errmsg;
    private List<DepartmentApiVO> department;

}
