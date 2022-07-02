package com.wbt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wbt.domain.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 15236
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermsByUserId(@Param("userid") Long userid);
}
