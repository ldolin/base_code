package club.ldolin.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemo1")
public class CookieDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建cookie
        Cookie c1 = new Cookie("msg","hello");
        Cookie c2 = new Cookie("name","yang");
        //设置path，让当前服务器下部署的所有项目共享cookie信息
        c2.setPath("/");
        //2.设置cookie存活时间
        c1.setMaxAge(0);//删除cookie，若负数就是默认值，写入内存，浏览器关闭cookie无效
        c2.setMaxAge(30);//持久化存储30秒到硬盘，浏览器关闭cookie仍然有效
        //3.发送cookie
        response.addCookie(c1);
        response.addCookie(c2);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
