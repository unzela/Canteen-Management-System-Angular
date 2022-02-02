package com.hexaware.MLP319.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP319.model.Order;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * OrderMapper class used to fetch order data from database.
 * @author hexware
 */
public class OrderMapper implements ResultSetMapper<Order> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped order object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public  final Order map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Orderr
       */
    return new Order(rs.getInt("ORDER_ID"), rs.getInt("FOOD_ID"),rs.getInt("VENDOR_ID"), rs.getInt("CUSTOMER_ID"),  rs.getInt("NO_OF_ITEMS"), rs.getString("ORDER_DATE_TIME"), rs.getDouble("AMOUNT_TO_BE_PAID"), rs.getInt("TOKEN_NUMBER"), rs.getString("STATUS"), rs.getString("COMMENT"));


  }

}
