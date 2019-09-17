package club.ldolin.web.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/SessionDemo1")
public class SessionDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取session
        HttpSession session = request.getSession();
        System.out.println(session);
        //期望客户端关闭，session也相同
        Cookie c = new Cookie("JSESSIONID", session.getId());
        c.setMaxAge(60*60);
        response.addCookie(c);
        //2.存储数据
        session.setAttribute("msg","hello session");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
