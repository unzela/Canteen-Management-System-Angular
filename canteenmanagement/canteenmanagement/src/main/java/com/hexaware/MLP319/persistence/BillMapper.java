package com.hexaware.MLP319.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP319.model.Bill;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * BillMapper class used to fetch bill data from database.
 * @author hexware
 */
public class BillMapper implements ResultSetMapper<Bill> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped bill object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Bill map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Bill
       */
    return new Bill(rs.getInt("customer_id"), rs.getInt("FOOD_ID"), rs.getString("FOOD_NAME"), rs.getString("wallet_name"),
                    rs.getDouble("wallet_amount"), rs.getInt("FOOD_QTY"), rs.getDouble("FOOD_PRICE"), rs.getInt("order_id"));
  }
}
