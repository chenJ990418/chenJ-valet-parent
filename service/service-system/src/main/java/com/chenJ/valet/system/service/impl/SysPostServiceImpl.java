package com.chenJ.valet.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenJ.valet.model.entity.system.SysPostDo;
import com.chenJ.valet.model.query.system.SysPostQuery;
import com.chenJ.valet.model.vo.base.PageVo;
import com.chenJ.valet.system.mapper.SysPostMapper;
import com.chenJ.valet.system.service.SysPostService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPostDo> implements SysPostService {

    @Resource
    private SysPostMapper sysPostMapper;

    @Override
    public PageVo<SysPostDo> findPage(Page<SysPostDo> pageParam, SysPostQuery sysPostQuery) {
        IPage<SysPostDo> pageInfo = sysPostMapper.selectPage(pageParam, sysPostQuery);
        return new PageVo(pageInfo.getRecords(), pageInfo.getPages(), pageInfo.getTotal());
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        SysPostDo sysPost = this.getById(id);
        sysPost.setStatus(status);
        this.updateById(sysPost);
    }

    @Override
    public List<SysPostDo> findAll() {
        List<SysPostDo> sysPostList = this.list(new LambdaQueryWrapper<SysPostDo>().eq(SysPostDo::getStatus, 1));
        return sysPostList;
    }

}
