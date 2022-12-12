package space.xinzhu.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/11
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
//loadOnstartup的取值有两类情况
//        （1）负整数:第一次访问时创建Servlet对象
//        （2）0或正整数:服务器启动时创建Servlet对象，数字越小优先级越高
@WebServlet(urlPatterns = "/demo0",loadOnStartup = 1)
public class ServletDemo1 implements Servlet {

    private ServletConfig servletConfig;
    /**
     *  初始化方法
     *  1.调用时机：默认情况下，Servlet被第一次访问时，调用
     *      * loadOnStartup: 默认为-1，修改为0或者正整数，则会在服务器启动的时候，调用
     *  2.调用次数: 1次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws
            ServletException {
        this.servletConfig=servletConfig;
        System.out.println("servlet init~");
    }

    /**
     * 提供服务
     * 1.调用时机:每一次Servlet被访问时，调用
     * 2.调用次数: 多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet hello world~");
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    //该方法用来返回Servlet的相关信息，没有什么太大的用处，一般我们返回一个空字符串即可
    @Override
    public String getServletInfo() {
        return "Servlet Info is null";
    }

    /**
     * 销毁方法
     * 1.调用时机：内存释放或者服务器关闭的时候，Servlet对象会被销毁，调用
     * 2.调用次数: 1次
     */
    @Override
    public void destroy() {
        System.out.println("servlet destroyed~");
    }

}
