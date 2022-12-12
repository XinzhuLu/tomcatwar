package space.xinzhu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/12
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Brand {

    // id 主键
    private Integer id;
    // 品牌名称
    private String brandName;
    // 企业名称
    private String companyName;
    // 排序字段
    private Integer ordered;
    // 描述信息
    private String description;
    // 状态：0：禁用  1：启用
    private Integer status;

    public Brand(Integer id, String brandName, String companyName, String description) {
        this.id = id;
        this.brandName = brandName;
        this.companyName = companyName;
        this.description = description;
    }

}
