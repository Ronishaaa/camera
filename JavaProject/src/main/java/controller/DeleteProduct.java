package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductDao;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/ProductDelete")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao dao;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dao = new ProductDao();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduct() {
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
int product_id = Integer.parseInt(request.getParameter("product_id"));
        
        try {
            int row = dao.deleteProductById(product_id);
            if (row > 0) {
                response.sendRedirect(request.getContextPath() + "/ManagementUser");
            } else {
                // Handle error (e.g., product not found)
            }
        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();
        }
    
	}

}
