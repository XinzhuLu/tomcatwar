package space.xinzhu.servlet;

import com.alibaba.fastjson.JSON;
import space.xinzhu.pojo.Brand;
import space.xinzhu.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/12
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService service = new BrandService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理POST请求的乱码问题
        //request.setCharacterEncoding("utf-8");

        //1. 接收表单提交的数据，封装为一个Brand对象
        //String brandName = request.getParameter("brandName");
        //String companyName = request.getParameter("companyName");
        //String ordered = request.getParameter("ordered");
        //String description = request.getParameter("description");
        //String status = request.getParameter("status");

        //封装为一个Brand对象
        //Brand brand = new Brand();
        //brand.setBrandName(brandName);
        //brand.setCompanyName(companyName);
        //brand.setOrdered(Integer.parseInt(ordered));
        //brand.setDescription(description);
        //brand.setStatus(Integer.parseInt(status));

        //2. 调用service 完成添加
        //service.add(brand);

        //3. 转发到查询所有Servlet
        //request.getRequestDispatcher("/selectAllServlet").forward(request,response);


        //----------------------------------------------

        //1. 接收数据,request.getParameter 不能接收json的数据
       /* String brandName = request.getParameter("brandName");
        System.out.println(brandName);*/

        // 获取请求体数据
        BufferedReader br = request.getReader();
        String params = br.readLine();
        // 将JSON字符串转为Java对象
        Brand brand = JSON.parseObject(params, Brand.class);
        //2. 调用service 添加
        service.add(brand);
        //3. 响应成功标识
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}