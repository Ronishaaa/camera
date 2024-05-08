package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter  {
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String requestUrl = request.getRequestURI();

		HttpSession session = request.getSession(false);

		if (requestUrl.endsWith(".css")) {
			chain.doFilter(request, response);
			return;
		}

		else if (requestUrl.endsWith("/") || requestUrl.endsWith("login") || requestUrl.endsWith("register")
				|| requestUrl.endsWith("logout") || requestUrl.endsWith("profile") || requestUrl.endsWith("admin")  || requestUrl.endsWith("view") || requestUrl.endsWith("edit")  ||requestUrl.endsWith("update")) {

			if (session == null) {

				request.getRequestDispatcher("login").forward(request, response);
			}

			else if (session.getAttribute("username") != null) {

				chain.doFilter(request, response);
			}

			/*
			 * if (requestUrl.endsWith("logout")) {
			 * 
			 * request.getRequestDispatcher("logout").forward(request, response); } else {
			 * request.getRequestDispatcher("profile").forward(request, response);
			 * 
			 * 
			 * }
			 */

		 else if (session.getAttribute("username") == null) {

			if (requestUrl.endsWith("profile") || requestUrl.endsWith("logout") || requestUrl.endsWith("admin")) {
				response.sendRedirect(request.getContextPath() + "/login");

			}

			else {

				chain.doFilter(request, response);
			}

		}
		}

	else

	{
			
		request.getRequestDispatcher("error").forward(request, response);

	}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
