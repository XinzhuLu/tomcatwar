package space.xinzhu.servlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import space.xinzhu.mapper.UserMapper;
import space.xinzhu.pojo.User;
import space.xinzhu.service.UserService;
import space.xinzhu.util.SqlSessionFactoryUtils;
import sun.rmi.server.Dispatcher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username = " + username);
        System.out.println("password = " + password);

        //2. 调用MyBatis完成查询
        //2.1 获取SqlSessionFactory对象
        //String resource = "mybatis-config.xml";
        //InputStream inputStream = Resources.getResourceAsStream(resource);
        //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        ////2.2 获取SqlSession对象
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        ////2.3 获取Mapper
        //UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        ////2.4 调用方法
        //User user = userMapper.select(username, password);
        //System.out.println("user.username = " + user.getUsername());
        ////2.5 释放资源
        //sqlSession.close();
        ////获取字符输出流，并设置content type
        //response.setContentType("text/html;charset=utf-8");
        //PrintWriter writer = response.getWriter();
        ////3. 判断user释放为null
        //if(user != null){
        //    // 登陆成功
        //    //writer.write("登陆成功");
        //    request.getRequestDispatcher("/index.jsp").forward(request,response);
        //}else {
        //    // 登陆失败
        //    writer.write("登陆失败");
        //}

        //获取复选框数据
        String remember = request.getParameter("remember");

        //2. 调用service查询
        User user = service.login(username, password);

        //3. 判断
        if(user != null){
            //登录成功，跳转到查询所有的BrandServlet

            //判断用户是否勾选记住我，字符串写前面是为了避免出现空指针异常
            if("1".equals(remember)){
                //勾选了，发送Cookie
                //1. 创建Cookie对象
                Cookie c_username = new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);
                // 设置Cookie的存活时间
                c_username.setMaxAge( 60 * 60 * 24 * 7);
                c_password.setMaxAge( 60 * 60 * 24 * 7);
                //2. 发送
                response.addCookie(c_username);
                response.addCookie(c_password);
            }

            //将登陆成功后的user对象，存储到session
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");
        }else {
            // 登录失败,

            // 存储错误信息到request
            request.setAttribute("login_msg","用户名或密码错误");

            // 跳转到login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
