package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import appConstant.ViewPages;
import model.Product;
import service.ProductDao;

/**
 * Servlet implementation class AddProduct
 */


@WebServlet(asyncSupported = true, urlPatterns = { "/AddNewProduct" })
@MultipartConfig
public class AddProduct extends HttpServlet {
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
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			request.getRequestDispatcher(ViewPages.ADD_PRODUCT_PAGE).forward(request, response);
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
					

        Part imagePart = request.getPart("productImage");
        byte[] imageData = convertImageToByteArray(imagePart);
         
		
//                Part productImage = request.getPart("productImage");
	    String productName = request.getParameter("productName");
	    String productDescription = request.getParameter("productDescription");
	    int unitPrice = Integer.parseInt(request.getParameter("unitPrice"));
	    int stock = Integer.parseInt(request.getParameter("stock"));

	    // Create a new Product object with the submitted data
	    Product newProduct = new Product();
	    newProduct.setProduct_name(productName); // Ensure productName is not null
	    newProduct.setProduct_description(productDescription);
	    newProduct.setUnit_price(unitPrice);
	    newProduct.setStock(stock);
	    newProduct.setProduct_image(imageData);
	
	    // Save the product using ProductDao
	    ProductDao dao = new ProductDao();
	    boolean success = dao.setData(newProduct);

	    // Redirect back to the doGet method to refresh the product list
	    if (success) {
	        response.sendRedirect(request.getContextPath() + "/ManagementUser");
	    } else {
	        // Handle failure (e.g., display error message)
	        response.getWriter().println("Failed to add product.");
	    }
	}
	private byte[] convertImageToByteArray(Part imagePart) throws IOException {
		// TODO Auto-generated method stub
		ByteArrayOutputStream byteoutput = new ByteArrayOutputStream();
		byte[] imagebyte = new byte[1024];
		int byteread;
		try (InputStream inputStream = imagePart.getInputStream()) {
			while ((byteread = inputStream.read(imagebyte)) != -1) {
				byteoutput.write(imagebyte, 0, byteread);
			}
		}
		return byteoutput.toByteArray();
	}

	}