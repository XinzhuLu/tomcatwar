package space.xinzhu.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import space.xinzhu.mapper.UserMapper;
import space.xinzhu.pojo.User;
import space.xinzhu.util.SqlSessionFactoryUtils;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/12
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class UserService {

    //1.使用工具类获取SqlSessionFactory
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4. 调用方法
        User user = mapper.select(username, password);
        //释放资源
        sqlSession.close();

        return  user;
    }
}
