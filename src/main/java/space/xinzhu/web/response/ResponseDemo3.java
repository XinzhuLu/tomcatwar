package space.xinzhu.web.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //response.setContentType("text/html;charset=utf-8");
        //将字符数据写回到浏览器
        //1. 获取字符输出流
        //PrintWriter writer = response.getWriter();
        //writer.write("aaa");

        //-------------------------------------
        //设置响应的数据格式及数据的编码
        //response.setContentType("text/html;charset=utf-8");
        //PrintWriter writer = response.getWriter();
        //writer.write("你好");

        //-------------------------------------
        //content-type，告诉浏览器返回的数据类型是HTML类型数据，这样浏览器才会解析HTML标签
        PrintWriter writer = response.getWriter();
        response.setHeader("content-type","text/html");
        writer.write("<h1>aaa</h1>");

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
