package com.chenJ.valet.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenJ.valet.model.entity.system.SysMenuDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenuDo> {

    List<SysMenuDo> findListByUserId(@Param("userId") Long userId);
}

