package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import utils.DatabaseConnectivity;

public class ProductDao {
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private boolean isSuccess;
	private static final String[] errorMessage = new String[2];
	private static final String insert_query = "insert into product"
			+ "(product_name,product_description,unit_price,stock,image)"
			+ " values(?,?,?,?,?)";

	public ProductDao() {
		conn = DatabaseConnectivity.getDbConnection();
	}

	public boolean setData(Product product) {
		int row = 0;
		try {
			statement = conn.prepareStatement(insert_query);
			statement.setString(1, product.getProduct_name());
			statement.setString(2, product.getProduct_description());
			statement.setInt(3, product.getUnit_price());
			statement.setInt(4, product.getStock());
			statement.setBytes(5, product.getProduct_image());
			row = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (row > 0 ) {
			isSuccess = true;
		}else {
			isSuccess = false;
		}
		return isSuccess;
	}

	public List<Product> getAllProduct() throws SQLException {
		
		statement=conn.prepareStatement("select * from product");
		resultSet=statement.executeQuery();
		List<Product> listOfProduct=new ArrayList<Product>();
		while(resultSet.next())
		{
			int product_id=resultSet.getInt("product_id");
			String product_name=resultSet.getString("product_name");
			String product_description=resultSet.getString("product_description");
			int unit_price=resultSet.getInt("unit_price");
			int stock=resultSet.getInt("stock");
		
			Product product=new Product();
			product.setProduct_name(product_name);
			product.setProduct_description(product_description);
			product.setStock(stock);
			product.setUnit_price(unit_price);
			product.setProduct_id(product_id);

			
			listOfProduct.add(product);
		}
		return listOfProduct;
	}
	
	public Product getProductById(int product_id) throws SQLException {
		statement=conn.prepareStatement("select product_name,product_description,unit_price,stock from product where product_id=?");
		statement.setInt(1, product_id);
		resultSet =statement.executeQuery();
		Product product=new Product();
		if(resultSet.next())
		{
			
		
			product.setProduct_name(resultSet.getString("product_name"));
			product.setProduct_description(resultSet.getString("product_description"));
			product.setUnit_price(resultSet.getInt("unit_price"));
			product.setStock(resultSet.getInt("stock"));
			
		}
		return product;
		
		
	}

	public int updateProduct(Product product) throws SQLException {
		int row=0;
		
		if(isProductnameTakenByOther(product.getProduct_name(),product.getProduct_id()))
		{
			return row;
		}
		else
		{
			statement=conn.prepareStatement("update product set product_name=?,product_description=?,unit_price=?,stock=? where product_id=?");
		     statement.setString(1, product.getProduct_name());
		     statement.setString(2, product.getProduct_description());
		     statement.setInt(3, product.getUnit_price());
		     statement.setInt(4, product.getStock());
		     statement.setInt(5, product.getProduct_id());
		     
		      row=statement.executeUpdate();
		}
	     
		
	     return row;
	}
	
	public int deleteProductById(int product_id) throws SQLException {
	    int row = 0;
	    try {
	        statement = conn.prepareStatement("delete from product where product_id=?");
	        statement.setInt(1, product_id);
	        row = statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return row;
	}


	private boolean isProductnameTakenByOther(String product_name, int product_id) throws SQLException {
		// TODO Auto-generated method stub
		statement=conn.prepareStatement("select count(*) as count_id from product where product_name=? and product_id!=?");
		statement.setString(1, product_name);
		statement.setInt(2, product_id);
		resultSet=statement.executeQuery();
		if(resultSet.next())
		{
			int row_number=resultSet.getInt("count_id");
			if(row_number>0)
			{
				return true;
			}
			
		}
		return false;
	}
	
}