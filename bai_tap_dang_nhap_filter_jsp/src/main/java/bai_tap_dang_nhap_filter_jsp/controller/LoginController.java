package bai_tap_dang_nhap_filter_jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bai_tap_dang_nhap_filter_jsp.common.Constant;
import bai_tap_dang_nhap_filter_jsp.model.UsersModel;
import bai_tap_dang_nhap_filter_jsp.pojo.Users;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	UsersModel usersModel=new UsersModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Users users= usersModel.getUser(email, password);
		if(users!=null) {
			HttpSession session=req.getSession();
			session.setAttribute(Constant.COOKIE_USER, users);
			session.setMaxInactiveInterval(1800);
			resp.sendRedirect(req.getContextPath()+"/thongtin");
			return;
		}
		
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(req, resp);
	}
}
