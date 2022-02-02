package com.hexaware.MLP319.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP319.model.Customer;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * CustomerMapper class used to fetch customer data from database.
 * @author hexware
 */
public class CustomerMapper implements ResultSetMapper<Customer> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public  final Customer map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Customer
       */
    return new Customer(rs.getInt("customer_id"), rs.getString("customer_name"), rs.getString("customer_email"),
                        rs.getString("customer_address"), rs.getString("customer_mobile"), rs.getString("customer_password"),
                        rs.getString("wallet_name"), rs.getDouble("wallet_amount"));
  }
}
