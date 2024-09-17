package com.chenJ.valet.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenJ.valet.model.entity.system.SysLoginLogDo;
import com.chenJ.valet.model.query.system.SysLoginLogQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysLoginLogMapper extends BaseMapper<SysLoginLogDo> {

    IPage<SysLoginLogDo> selectPage(Page<SysLoginLogDo> page, @Param("query") SysLoginLogQuery sysLoginLogQuery);

}
