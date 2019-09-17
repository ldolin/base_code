package club.ldolin.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/l1","/ll1"})
//@WebServlet("/user/lianxi")
//@WebServlet("/user/*")
//@WebServlet("/*")
//@WebServlet("*.do") //demmo4.do,demo4.action,do相当于自定义后缀，可任意更改
public class ServletLianXi1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost...");
    }
}
