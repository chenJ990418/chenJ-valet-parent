package com.chenJ.valet.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenJ.valet.model.entity.system.SysPost;
import com.chenJ.valet.model.query.system.SysPostQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysPostMapper extends BaseMapper<SysPost> {

    IPage<SysPost> selectPage(Page<SysPost> page, @Param("query") SysPostQuery sysPostQuery);

}
