package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import appConstant.ViewPages;
import model.Product;
import service.ProductDao;

/**
 * Servlet implementation class EditProduct
 */
@WebServlet("/ProductEdit")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao dao;
    
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dao=new ProductDao();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int product_id=Integer.valueOf(request.getParameter("product_id"));
		
		try {
			Product product=dao.getProductById(product_id);
			request.setAttribute("product", product);
			HttpSession session=request.getSession();
			session.setAttribute("product_id", product_id);
		
			request.getRequestDispatcher(ViewPages.UPDATE_PRODUCT_PAGE).forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
