package space.xinzhu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/11
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private Integer id;
    private String username;
    private String password;

}
