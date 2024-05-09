package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appConstant.ViewPages;
import model.Customer;
import service.CustomerDao;
import utils.PasswordHash;

/**
 * Servlet implementation class CustomerRegister
 */
@WebServlet("/Register")
public class CustomerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDao dao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	dao = new CustomerDao();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher(ViewPages.REGISTER_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
		String password = request.getParameter("password");
		String reTypePassword = request.getParameter("retypePassword");
		if (!password.equals(reTypePassword)) {
			request.setAttribute("firstName", firstName);
			request.setAttribute("error", "not matched");
			request.getRequestDispatcher(ViewPages.REGISTER_PAGE).forward(request, response);
		}
		Customer customer = new Customer();
		customer.setFirst_name(firstName);
		customer.setLast_name(lastName);
		customer.setUsername(username);
		customer.setAddress(gender);
		customer.setEmail(email);
		customer.setPhone_number(phoneNumber);
		customer.setPassword(PasswordHash.getPasswordHash(password));
		if (dao.saveCustomer(customer)) {
			
			response.sendRedirect(request.getContextPath()+"/Login");
		} else {
			request.setAttribute("error1", "username or email or phonenumber exist");
			doGet(request, response);
		}

	
	}

}
