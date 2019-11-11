package TranHieu.FinalQuanLySinhVien.Authentication;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter",urlPatterns = {"*.xhtml"})
public class AuthorizationFilter implements Filter {
	
	public AuthorizationFilter() {
		
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpServletRequest reqt =(HttpServletRequest) request;
			HttpServletResponse resp =(HttpServletResponse) response;
			HttpSession ses = reqt.getSession(false);
			
			String reqURI = reqt.getRequestURI();
			if(reqURI.indexOf("Login.xhtml") >=0 || (ses != null && ses.getAttribute("user") != null) ) {
				chain.doFilter(request, response);
			}
			else {
				System.out.println("da vao day");
				resp.sendRedirect(reqt.getContextPath() +"/Login.xhtml");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		
	}

}
