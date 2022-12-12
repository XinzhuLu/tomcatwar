package space.xinzhu.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import space.xinzhu.pojo.Brand;

import java.util.List;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/12
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public interface BrandMapper {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_brand")
    //@ResultMap("brandResultMap")
    List<Brand> selectAll();

    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);
}
