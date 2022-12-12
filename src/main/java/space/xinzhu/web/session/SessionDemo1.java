package space.xinzhu.web.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/12
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
@WebServlet("/sessiondemo1")
public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //存储到Session中
        //1. 获取Session对象
        HttpSession session = request.getSession();
        //2. 存储数据
        session.setAttribute("username","zs");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

//    Cookie和Session的应用场景分别是什么?
//
//  * 区别:
//  * 存储位置：
//    Cookie 是将数据存储在客户端，Session 将数据存储在服务端
//  * 安全性：Cookie不安全，Session安全
//  * 数据大小：Cookie最大3KB，Session无大小限制
//  * 存储时间：Cookie可以通过setMaxAge()长期存储，Session默认30分钟
//  * 服务器性能：Cookie不占服务器资源，Session占用服务器资源
//* 应用场景:
//  * 购物车:使用Cookie来存储
//  * 以登录用户的名称展示:使用Session来存储
//  * 记住我功能:使用Cookie来存储
//  * 验证码:使用session来存储
//* 结论
//  * Cookie是用来保证用户在未登录情况下的身份识别
//  * Session是用来保存用户登录后的数据
}
