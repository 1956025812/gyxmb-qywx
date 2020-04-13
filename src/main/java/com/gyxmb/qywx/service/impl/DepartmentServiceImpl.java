package com.gyxmb.qywx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gyxmb.qywx.entity.Department;
import com.gyxmb.qywx.mapper.DepartmentMapper;
import com.gyxmb.qywx.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 部门SERVICE接口实现类
 * </p>
 *
 * @author DuXueBo
 * @since 2020-04-12
 */
@Service
@Slf4j
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


}
