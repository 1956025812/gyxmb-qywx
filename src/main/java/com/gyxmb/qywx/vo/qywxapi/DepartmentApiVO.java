package com.gyxmb.qywx.vo.qywxapi;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 企业微信API获取部门列表返回的VO对象
 * </p>
 *
 * @author DuXueBo
 * @since 2020-04-12 17:52
 */
@Data
public class DepartmentApiVO implements Serializable {

    private Integer id;
    private String name;
    private String nameEn;
    private Integer parentId;
    private Integer order;


}
