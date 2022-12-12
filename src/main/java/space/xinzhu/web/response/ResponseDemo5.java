package space.xinzhu.web.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/11
 * --------------------------------------------
 * 响应字节数据-文件下载
 **/
@WebServlet("/resp5")
public class ResponseDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //向响应数据之前告诉浏览器以附件的形式解析响应体中的数据(告诉浏览器文件下载)
        response.setHeader("content-disposition","attachment;filename=a.jpg");

        //1 使用自己输入流对象读取D:\imgs中的某个图片  FileInputStream
        FileInputStream fis=new FileInputStream("D:/imgs/e.jpg");
        //2 通过Response对象获取字节输出流对象 OutputStream
        ServletOutputStream os = response.getOutputStream();
        //3 两个流对接，一边读一边写，一次读写一个字节数组
        //简化IO复制书写
        IOUtils.copy(fis,os);
        //释放资源
        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
