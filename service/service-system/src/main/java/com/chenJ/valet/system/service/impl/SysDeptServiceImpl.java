package com.chenJ.valet.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenJ.valet.common.execption.ValetException;
import com.chenJ.valet.common.result.ResultCodeEnum;
import com.chenJ.valet.model.entity.system.SysDeptDo;
import com.chenJ.valet.system.helper.DeptHelper;
import com.chenJ.valet.system.mapper.SysDeptMapper;
import com.chenJ.valet.system.service.SysDeptService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDeptDo> implements SysDeptService {

    @Resource
    private SysDeptMapper sysDeptMapper;


    @Override
    public List<SysDeptDo> findNodes() {
        List<SysDeptDo> goodsTypeList = this.list();
        return DeptHelper.buildTree(goodsTypeList, 0L);
    }

    @Override
    public List<SysDeptDo> findUserNodes() {
        List<SysDeptDo> sysDeptList = this.list(new LambdaQueryWrapper<SysDeptDo>().eq(SysDeptDo::getStatus, 1));
        return DeptHelper.buildTree(sysDeptList, 0L);
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        SysDeptDo sysDept = this.getById(id);
        sysDept.setStatus(status);
        this.updateById(sysDept);
    }


    @Override
    public boolean removeById(Serializable id) {
        long count = this.count(new LambdaQueryWrapper<SysDeptDo>().eq(SysDeptDo::getParentId, id));
        if (count > 0) {
            throw new ValetException(ResultCodeEnum.NODE_ERROR);
        }
        sysDeptMapper.deleteById(id);
        return false;
    }

}

