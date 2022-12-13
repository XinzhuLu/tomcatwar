package space.xinzhu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/13
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
@WebFilter("/*")
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("filter init~~~~");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter doFilter~~~~");

        //放行
        chain.doFilter(request,response);

        System.out.println("filter 放行了");
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy~~~~");

    }
}
