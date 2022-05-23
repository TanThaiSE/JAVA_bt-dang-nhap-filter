package bai_tap_dang_nhap_filter_jsp.filer;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bai_tap_dang_nhap_filter_jsp.common.Constant;
import bai_tap_dang_nhap_filter_jsp.pojo.Users;

@WebFilter(urlPatterns = {"/login"})
public class AuthFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		HttpSession session=req.getSession();
		Users users=(Users) session.getAttribute(Constant.COOKIE_USER);
		if(users!=null) {
			resp.sendRedirect(req.getContextPath()+"/thongtin");
		}
		else {
			chain.doFilter(request, response);
		}
//		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
