package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import utils.DatabaseConnectivity;
import utils.PasswordHash;

public class CustomerDao {
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private boolean isSuccess;
	private static final String[] errorMessage = new String[2];
	private static final String insert_query = "insert into customer_register"
			+ "(first_name,last_name,username,address,email,phone_number,password)"
			+ " values(?,?,?,?,?,?,?)";

	public CustomerDao() {
		conn = DatabaseConnectivity.getDbConnection();
	}

	public boolean saveCustomer(Customer customer) {
		try {
			statement = conn.prepareStatement("select count(*) from customer_register");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				if (check(customer)) {
					isSuccess = false;
				} else {
					int row = setData(customer);
					if (row > 0) {
						isSuccess = true;
					} else {
						isSuccess = false;
					}
				}

			} else {
				int row = setData(customer);
				if (row > 0) {
					isSuccess = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;
	}

	public int setData(Customer customer) {
		int row = 0;
		try {
			statement = conn.prepareStatement(insert_query);
			statement.setString(1, customer.getFirst_name());
			statement.setString(2, customer.getLast_name());
			statement.setString(3, customer.getUsername());
			statement.setString(5, customer.getAddress());
			statement.setString(6, customer.getEmail());
			statement.setLong(7, customer.getPhone_number());
			statement.setString(8, customer.getPassword());
			row = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}

	public boolean check(Customer customer) {
		boolean isFind = false;
		try {
			statement = conn.prepareStatement("select username,email,phone_number from customer_register");
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				if (customer.getUsername().equals(resultSet.getString("user_name"))) {
					isFind = true;
					break;
				} else if (customer.getEmail().equals(resultSet.getString("email"))) {
					isFind = true;
					break;
				} else if (customer.getPhone_number() == resultSet.getLong("phone_number")) {
					isFind = true;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isFind;
	}

	public boolean customerLogin(String username, String password) throws SQLException {
		statement = conn.prepareStatement("select username,password from customer_register where username=?");
		statement.setString(1, username);
		resultSet = statement.executeQuery();
		boolean isSuccess = false;
		if (resultSet.next()) {
			String passwordFromDb = resultSet.getString("password");

			if (PasswordHash.verifyPassword(password, passwordFromDb)) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		}
		return isSuccess;

	}
	public List<Customer> getAllCustomer() throws SQLException {
		statement=conn.prepareStatement("select * from customer_register");
		resultSet=statement.executeQuery();
		List<Customer> listOfCustomer=new ArrayList<Customer>();
		while(resultSet.next())
		{
			int customer_id=resultSet.getInt("customer_id");
			String firstName=resultSet.getString("first_name");
			String lastName=resultSet.getString("last_name");
			String username=resultSet.getString("username");
			String address=resultSet.getString("address");
			String email=resultSet.getString("email");
			long phoneNumber=resultSet.getLong("phoneNumber");
			
			Customer customer=new Customer();
			customer.setFirst_name(firstName);
			customer.setLast_name(lastName);
			customer.setUsername(username);
			customer.setAddress(address);
			customer.setEmail(email);
			customer.setPhone_number(phoneNumber);
			customer.setCustomer_id(customer_id);
			
			listOfCustomer.add(customer);
		}
		return listOfCustomer;
	}
	
	public Customer getCustomerById(int id) throws SQLException {
		statement=conn.prepareStatement("select first_name,last_name,username,address,email,phoneNumber from customer_register where id=?");
		statement.setInt(1, id);
		resultSet =statement.executeQuery();
		Customer customer=new Customer();
		if(resultSet.next())
		{
			
		
			customer.setFirst_name(resultSet.getString("first_name"));
			customer.setLast_name(resultSet.getString("last_name"));
			customer.setUsername(resultSet.getString("username"));
			customer.setAddress(resultSet.getString("address"));
			customer.setEmail(resultSet.getString("email"));
			customer.setPhone_number(resultSet.getLong("phoneNumber"));
			
		}
		return customer;
		
		
	}
	
	public int updateCustomer(Customer customer) throws SQLException {
		int row=0;
		
		if(isUsernameTakenByOther(customer.getUsername(),customer.getCustomer_id()))
		{
			return row;
		}
		else if(isEmailTakenByOther(customer.getEmail(),customer.getCustomer_id()))
		{
			return row;
		}
		else if(isPhoneNumberTakenByOther(customer.getPhone_number(),customer.getCustomer_id()))
		{
			return row;
		}
		else
		{
			statement=conn.prepareStatement("update customer_register set firstName=?,lastName=?,username=?,address=?,email=?,phoneNumber=? , subject=? where id=?");
		     statement.setString(1, customer.getFirst_name());
		     statement.setString(2, customer.getLast_name());
		     statement.setString(3, customer.getUsername());
		     statement.setString(5, customer.getAddress());
		     statement.setString(6, customer.getEmail());
		     statement.setLong(7, customer.getPhone_number());
		     statement.setInt(8, customer.getCustomer_id());
		     
		      row=statement.executeUpdate();
		}
	     
		
	     return row;
	}
	
	private boolean isUsernameTakenByOther(String username, int customer_id) throws SQLException {
		// TODO Auto-generated method stub
		statement=conn.prepareStatement("select count(*) as count_id from customer_register where username=? and customer_id!=?");
		statement.setString(1, username);
		statement.setInt(2, customer_id);
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
	
	private boolean isEmailTakenByOther(String email, int customer_id) throws SQLException {
		// TODO Auto-generated method stub
		statement=conn.prepareStatement("select count(*) as count_id from customer_register where email=? and customer_id!=?");
		statement.setString(1, email);
		statement.setInt(2, customer_id);
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
	
	private boolean isPhoneNumberTakenByOther(long phoneNumber, int customer_id) throws SQLException {
		statement=conn.prepareStatement("select count(*) as count_id from customer_register where phoneNumber=? and customer_id!=?");
		statement.setLong(1, phoneNumber);
		statement.setInt(2, customer_id);
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



