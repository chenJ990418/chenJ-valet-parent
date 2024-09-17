package com.chenJ.valet.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenJ.valet.model.entity.system.SysUserDo;
import com.chenJ.valet.model.query.system.SysUserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserDo> {

    IPage<SysUserDo> selectPage(Page<SysUserDo> page, @Param("query") SysUserQuery userQuery);
}

