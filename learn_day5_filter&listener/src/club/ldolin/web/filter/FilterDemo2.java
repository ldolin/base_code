package club.ldolin.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//浏览器直接请求资源时，该过滤器会被执行
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
//只有转发访问index.jsp，该过滤器才会执行
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.FORWARD)
@WebFilter(value = "/index.jsp",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})

public class FilterDemo2 implements Filter {
    /**
     * 每一次请求被拦截资源时，被执行，执行多次
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request对象请求消息增强
        //放行之前之后，代码执行顺序不同
        chain.doFilter(req, resp);
        //对response对象响应消息增强
    }

    /**
     * 服务器启动后，会创建Filter对象，调用init方法。用于加载资源
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {

    }

    /**
     * 服务器关闭后，销毁Filter对象，如果是正常关闭，执行destroy方法。用于释放资源
     */
    public void destroy() {
    }

}
