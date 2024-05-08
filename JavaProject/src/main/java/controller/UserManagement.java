package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appConstant.ViewPages;
import model.Product;
import service.ProductDao;

/**
 * Servlet implementation class UserManagement
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ManagementUser" })
public class UserManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao dao;
       

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao=new ProductDao();
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Product> listOfProduct=dao.getAllProduct();
			request.setAttribute("listOfProduct", listOfProduct);
			request.getRequestDispatcher(ViewPages.VIEW_ALL_USER).forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// Retrieve form parameters
	   
	}

}

