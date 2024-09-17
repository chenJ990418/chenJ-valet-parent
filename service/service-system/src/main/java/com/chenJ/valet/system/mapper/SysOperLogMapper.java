package com.chenJ.valet.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenJ.valet.model.entity.system.SysOperLogDo;
import com.chenJ.valet.model.query.system.SysOperLogQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysOperLogMapper extends BaseMapper<SysOperLogDo> {

    IPage<SysOperLogDo> selectPage(Page<SysOperLogDo> page, @Param("query") SysOperLogQuery sysOperLogQuery);

}
