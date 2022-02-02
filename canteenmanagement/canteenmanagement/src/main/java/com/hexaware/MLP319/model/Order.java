package com.hexaware.MLP319.model;
import java.util.Objects;

/**
 * Order class used to display order information.
 * @author hexware
 */
public class Order {
  private int orderId;
  private int foodId;
  private int vendorId;
  private int customerId;
  private int noOfItems;
  private String orderDateTime;
  private double amountToBePaid;
  private int tokenNumber;
  private String status;
  private String comment;


  /**
   * Default Constructor.
   */
  public Order() {
  }
 /**
   * @param argOrderId to initialize order id.
   * constructor to initialize the order id.
   */
  public Order(final int argOrderId) {
    this.orderId = argOrderId;
  }

  /**
   * Insert order.
   * @param argOrderId to initialize order id.
   * @param argFoodId to initialize food id.
   * @param argVendorId to initialize vendor id.
   * @param argCustomerId to initialize customer id.
   * @param argNoOfItems to initialize no of items.
   * @param argOrderDateTime to initialize order date time.
   * @param argAmountToBePaid to initialize amount to be paid.
   * @param argTokenNumber to initialize token number.
   * @param argStatus to initialize status.
   * @param argComment to initialize comment.
   */
  public Order(final int argOrderId,
       final int argFoodId, final int argVendorId, final int argCustomerId, final int argNoOfItems,
           final String argOrderDateTime, final double argAmountToBePaid, final int argTokenNumber,
              final String argStatus, final String argComment) {
    this.orderId = argOrderId;
    this.foodId = argFoodId;
    this.vendorId = argVendorId;
    this.customerId = argCustomerId;


    this.noOfItems = argNoOfItems;
    this.orderDateTime = argOrderDateTime;
    this.amountToBePaid = argAmountToBePaid;
    this.tokenNumber = argTokenNumber;
    this.status = argStatus;
    this.comment = argComment;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Order order = (Order) obj;
    if (Objects.equals(orderId, order.orderId)
        && Objects.equals(foodId, order.foodId)
        && Objects.equals(vendorId, order.vendorId)
        && Objects.equals(customerId, order.customerId)
        && Objects.equals(noOfItems, order.noOfItems)
        && Objects.equals(orderDateTime, order.orderDateTime)
        && Objects.equals(amountToBePaid, order.amountToBePaid)
        && Objects.equals(tokenNumber, order.tokenNumber)
        && Objects.equals(status, order.status)
        && Objects.equals(comment, order.comment)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(orderId, foodId, vendorId, customerId, noOfItems, orderDateTime, amountToBePaid, tokenNumber, status, comment);
  }
    /**
     * @return this order ID.
     */
  public final int getOrderId() {
    return orderId;
  }
    /**
     * @param argOrderId gets the order id.
     */
  public final void setOrderId(final int argOrderId) {
    this.orderId = argOrderId;
  }
    /**
     * @return this food ID.
     */
  public final int getFoodId() {
    return foodId;
  }
    /**
     * @param argFoodId gets the food id.
     */
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }
    /**
     * @return vendorId.
     */
  public final int getVendorId() {
    return vendorId;
  }
    /**
     * @param argVendorId gets the vendor id.
     */
  public final void setVendorId(final int argVendorId) {
    this.vendorId = argVendorId;
  }
    /**
     * @return this customer ID.
     */
  public final int getCustomerId() {
    return customerId;
  }
    /**
     * @param argCustomerId gets the customer id.
     */
  public final void setCustomerId(final int argCustomerId) {
    this.customerId = argCustomerId;
  }
    /**
     * @return this no of items.
     */
  public final int getNoOfItems() {
    return noOfItems;
  }
    /**
     * @param argNoOfItems gets the no of items.
     */
  public final void setNoOfItems(final int argNoOfItems) {
    this.noOfItems = argNoOfItems;
  }
    /**
     * @return this orderdatetime.
     */
  public final String getOrderDateTime() {
    return orderDateTime;
  }
    /**
     * @param argOrderDateTime gets the orderdatetime.
     */
  public final void setOrderDateTime(final String argOrderDateTime) {
    this.orderDateTime = argOrderDateTime;
  }
    /**
     * @return this amount to be paid.
     */
  public final double getAmountToBePaid() {
    return amountToBePaid;
  }
    /**
     * @param argAmountToBePaid gets the amount to be paid.
     */
  public final void setAmountToBePaid(final double argAmountToBePaid) {
    this.amountToBePaid = argAmountToBePaid;
  }
    /**
     * @return this token number.
     */
  public final int getTokenNumber() {
    return tokenNumber;
  }
    /**
     * @param argTokenNumber gets the token number.
     */
  public final void setTokenNumber(final int argTokenNumber) {
    this.tokenNumber = argTokenNumber;
  }
    /**
     * @return this status.
     */
  public final String getStatus() {
    return status;
  }
    /**
     * @param argStatus gets the Status.
     */
  public final void setStatus(final String argStatus) {
    this.status = argStatus;
  }
    /**
     * @return this Comment.
     */
  public final String getComment() {
    return comment;
  }
    /**
     * @param argComment gets the Comment.
     */
  public final void setComment(final String argComment) {
    this.comment = argComment;
  }
}
