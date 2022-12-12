package space.xinzhu.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/11
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
@WebServlet("/req5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo5...");

        //存储数据
        request.setAttribute("msg","hello");

        Object msg = request.getAttribute("msg");
        System.out.println("msg = " + msg);

        request.removeAttribute("msg");

        //请求转发
        request.getRequestDispatcher("/req6").forward(request,response);

        //请求转发
        request.getRequestDispatcher("/req6").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
