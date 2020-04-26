package cn.pluto.medicinal.dao;

import cn.pluto.medicinal.pojo.MenuPower;
import cn.pluto.medicinal.pojo.MenuPowerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuPowerMapper {
    long countByExample(MenuPowerExample example);

    int deleteByExample(MenuPowerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MenuPower record);

    int insertSelective(MenuPower record);

    List<MenuPower> selectByExample(MenuPowerExample example);

    MenuPower selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MenuPower record, @Param("example") MenuPowerExample example);

    int updateByExample(@Param("record") MenuPower record, @Param("example") MenuPowerExample example);

    int updateByPrimaryKeySelective(MenuPower record);

    int updateByPrimaryKey(MenuPower record);
}