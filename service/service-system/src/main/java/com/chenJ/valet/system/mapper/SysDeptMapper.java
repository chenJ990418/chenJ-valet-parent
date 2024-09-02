package com.chenJ.valet.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenJ.valet.model.entity.system.SysDeptDo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysDeptMapper extends BaseMapper<SysDeptDo> {


}
