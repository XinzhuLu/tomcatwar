package space.xinzhu.web.servlet;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/11
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
@WebServlet(urlPatterns = {"/demo5","/demo3"})
public class ServletDemo5 extends MyHttpServlet {
    @Override
    protected void doGet(ServletRequest req, ServletResponse res) {
        System.out.println("get...");
    }

    @Override
    protected void doPost(ServletRequest req, ServletResponse res) {
        System.out.println("post...");
    }
}
