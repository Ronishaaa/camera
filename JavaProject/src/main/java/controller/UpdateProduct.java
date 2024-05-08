package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class UpdateProduct
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ProductUpdate" })
public class UpdateProduct extends HttpServlet {
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
    public UpdateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		int product_id=(Integer)(session.getAttribute("product_id"));
		Product product=new Product();
		product.setProduct_name(request.getParameter("productName"));
		product.setProduct_description(request.getParameter("productDescription"));
		product.setUnit_price(Integer.parseInt(request.getParameter("unitPrice")));
		
		product.setStock(Integer.parseInt(request.getParameter("stock")));
		product.setProduct_id(product_id);
		try {
			int row=dao.updateProduct(product);
			if(row>0)
			{
				response.sendRedirect(request.getContextPath()+"/ManagementUser");
			}
			else
			{
				request.getRequestDispatcher(ViewPages.UPDATE_PRODUCT_PAGE).forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}
