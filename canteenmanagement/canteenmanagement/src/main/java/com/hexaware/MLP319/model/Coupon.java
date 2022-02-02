package com.hexaware.MLP319.model;
import java.util.Objects;
import java.util.Date;

/**
 * Wallet class used to display Wallet information.
 * @author hexware
 */
public class Coupon {
/**
 * couponName to store customerId.
 */
  private String couponName;
/**
* dateCoupon to store walletId.
 */
  private Date dateCoupon;
  /**
* custId to store CustId.
 */
  private int custId;
  /**
* venId to store VenId.
 */
  private int venId;
  /**
   * Default Constructor.
   */
  public Coupon() {

  }
/**
 * @param argCouponName to initialize customer id.
 * @param argDateCoupon to initialize wallet id.
 * @param argCustId to initialize wallet amount.
 * @param argVenId to initialize wallet source.
 * used to get details through constructor.
 */
  public Coupon(final String argCouponName, final Date argDateCoupon, final int argCustId, final int argVenId) {
    this.couponName = argCouponName;
    this.dateCoupon = argDateCoupon;
    this.custId = argCustId;
    this.venId = argVenId;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Coupon coupon = (Coupon) obj;
    if (Objects.equals(couponName, coupon.couponName) && Objects.equals(dateCoupon, coupon.dateCoupon)
        && Objects.equals(custId, coupon.custId) && Objects.equals(venId, coupon.venId)) {
      return true;
    }
    return false;
  }
  @Override
  public final String toString() {
    return String.format("%5s %20s %20s %30s", couponName, dateCoupon, custId, venId);
  }
  @Override
    public final int hashCode() {
    return Objects.hash(couponName, dateCoupon, custId, venId);
  }
    /**
     * @return this coupon name.
     */
  public final String getCouponName() {
    return couponName;
  }
     /**
     * @return this date coupon.
     */
  public final Date getDateCoupon() {
    return dateCoupon;
  }
    /**
     * @return this cust id.
     */
  public final int getCustId() {
    return custId;
  }
    /**
     * @return this ven id.
     */
  public final int getVenId() {
    return venId;
  }
    /**
     * @param argCouponName gets the customer id.
     */
  public final void setCouponName(final String argCouponName) {
    this.couponName = argCouponName;
  }
    /**
     * @param argDateCoupon gets the wallet id.
     */
  public final void setDateCoupon(final Date argDateCoupon) {
    this.dateCoupon = argDateCoupon;
  }
    /**
     * @param argCustId gets the wallet amount.
     */
  public final void setCustId(final int argCustId) {
    this.custId = argCustId;
  }
    /**
     * @param argVenId gets the Wallet source.
     */
  public final void setVenId(final int argVenId) {
    this.venId = argVenId;
  }

}

