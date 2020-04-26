package com.gyxmb.qywx.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 企业微信部门表
 * </p>
 *
 * @author DuXueBo
 * @since 2020-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String deptNameCn;

    /**
     * 英文名称
     */
    private String deptNameEn;

    /**
     * 父亲部门id。根部门为1
     */
    private Integer parentId;

    /**
     * 在父部门中的次序值。order值大的排序靠前。值范围是[0, 2^32)
     */
    private Integer deptOrder;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
