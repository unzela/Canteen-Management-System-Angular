package com.hexaware.MLP319.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP319.model.Shipping;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * BillMapper class used to fetch bill data from database.
 * @author hexware
 */
public class ShippingMapper implements ResultSetMapper<Shipping> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped bill object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Shipping map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Bill
       */
    return new Shipping(rs.getInt("customer_id"), rs.getString("FOOD_NAME"),
                    rs.getInt("No_of_items"), rs.getDouble("FOOD_PRICE"), rs.getInt("order_id"), rs.getDouble("Amount_to_be_paid"));
  }
}