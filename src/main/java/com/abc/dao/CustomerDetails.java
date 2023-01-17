package com.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.abc.dto.Customer;
import com.abc.utility.JdbcUtil;

public class CustomerDetails {

	private static final String SQL_SELECT_QUERY = "slect cid, cname,cage, caddress,cmobile, cmail";

	Connection connection = null;
	PreparedStatement pstmt = null;

	public String getCustomer(Customer customer) {
		try {

			connection = JdbcUtil.getDbConnection();
			ResultSet resultSet = null;
			if (connection != null) {
				pstmt = connection.prepareStatement(SQL_SELECT_QUERY);
			}

			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
			}

			if (resultSet.next()) {

				customer = new Customer();

				customer.setCid(resultSet.getInt(0));
				customer.setCname(resultSet.getString(2));
				customer.setCage(resultSet.getInt(3));
				customer.setCaddress(resultSet.getString(4));
				customer.setCmobile(resultSet.getInt(4));
				customer.setCmail(resultSet.getString(4));

				resultSet=pstmt.executeQuery();
				
				if(resultSet.next()) {
					return toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
