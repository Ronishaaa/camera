package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.DatabaseConnectivity;
import utils.PasswordHash;

public class CustomerDao {
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private boolean isSuccess;
	private static final String[] errorMessage = new String[2];
	private static final String insert_query = "insert into customer_register"
			+ "(firstName,lastName,username,dob,gender,email,phoneNumber,subject,password)"
			+ " values(?,?,?,?,?,?,?,?,?)";

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
			statement.setString(1, customer.getFirstName());
			statement.setString(2, customer.getLastName());
			statement.setString(3, customer.getUsername());
			statement.setDate(4, customer.getDob());
			statement.setString(5, customer.getGender());
			statement.setString(6, customer.getEmail());
			statement.setLong(7, customer.getPhoneNumber());
			statement.setString(8, customer.getSubject());
			statement.setString(9, customer.getPassword());
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
			statement = conn.prepareStatement("select username,email,phoneNumber from customer_register");
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				if (customer.getUsername().equals(resultSet.getString("username"))) {
					isFind = true;
					break;
				} else if (customer.getEmail().equals(resultSet.getString("email"))) {
					isFind = true;
					break;
				} else if (customer.getPhoneNumber() == resultSet.getLong("phoneNumber")) {
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
		statement = conn.prepareStatement("select username,password,role_id from customer_register where username=?");
		statement.setString(1, username);
		resultSet = statement.executeQuery();
		boolean isSuccess = false;
		if (resultSet.next()) {
			String passwordFromDb = resultSet.getString("password");

			if (PasswordHash.verifyPassword(password, passwordFromDb) && resultSet.getInt("role_id")==2) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		}
		return isSuccess;

	}
	public List<Customer> getAllCustomer() throws SQLException {
		statement=conn.prepareStatement("select * from customer");
		resultSet=statement.executeQuery();
		List<Customer> listOfCustomer=new ArrayList<Customer>();
		while(resultSet.next())
		{
			int id=resultSet.getInt("id");
			String firstName=resultSet.getString("firstName");
			String lastName=resultSet.getString("lastName");
			String username=resultSet.getString("username");
			Date dob=resultSet.getDate("dob");
			String gender=resultSet.getString("gender");
			String email=resultSet.getString("email");
			long phoneNumber=resultSet.getLong("phoneNumber");
			String subject=resultSet.getString("subject");
			
			Customer customer=new Customer();
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setUsername(username);
			customer.setDob(dob);
			customer.setGender(gender);
			customer.setEmail(email);
			customer.setPhoneNumber(phoneNumber);
			customer.setSubject(subject);
			
			listOfCustomer.add(customer);
		}
		return listOfCustomer;
	}
	
}
