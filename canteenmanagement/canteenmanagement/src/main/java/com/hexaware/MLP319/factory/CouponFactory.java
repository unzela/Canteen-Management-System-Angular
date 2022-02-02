package com.hexaware.MLP319.factory;

import com.hexaware.MLP319.persistence.CouponDAO;
import com.hexaware.MLP319.persistence.DbConnection;
import java.util.List;
import com.hexaware.MLP319.model.Coupon;
import java.util.Date;
/**
 * CustomerFactory class used to fetch Customer data from database.
 * @author hexware
 */
public class CouponFactory {
  /**   *  Protected constructor.
   */
  public CouponFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  public static CouponDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CouponDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of customer object.
   */
  public static Coupon[] show() {
    List<Coupon> coupon = dao().show();
    return coupon.toArray(new Coupon[coupon.size()]);
  }
  /**
   * @param custId to initialize.
   * @param venId to initialize.
   * @return this coupon.
   */
  public static int showcount(final int custId, final int venId) {
    return dao().showcount(custId, venId);
  }
   /**
   * @param custId to initialize.
   * @param venId to initialize.
   * @return this coupon.
   */
  public static Coupon showcoupon(final int custId, final int venId) {
    Coupon coupon = dao().showcoupon(custId, venId);
    return coupon;
  }


  public static int addingcoupon(final Date cdate, final int custId, final int venId) {
   int res=dao().createCoupon("Free10",cdate,custId,venId);
    return res;
  }



}
