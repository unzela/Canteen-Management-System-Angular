package com.hexaware.MLP319.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP319.model.Coupon;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * WalletMapper class used to fetch wallet data from database.
 * @author hexware
 */
public class CouponMapper implements ResultSetMapper<Coupon> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Coupon map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Coupon
       */
    return new Coupon(rs.getString("coupon_name"), rs.getDate("date_coupon"), rs.getInt("cust_id"),
                      rs.getInt("ven_id"));
  }
}
