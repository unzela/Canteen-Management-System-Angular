package com.hexaware.MLP319.model;

import java.util.Objects;

/**
 * Bill class used to display bill information.
 * @author hexware
 */
public class Shipping {
  private int customerId;
  private String foodName;
  private int noOfItems;
  private double foodPrice;
  private int orderId;
  private double amountToBePaid;
  /**
   * Default Constructor.
   */
  public Shipping() {

  }
  public Shipping(final int argCustomerId) {
    this.customerId = argCustomerId;

  }

  /**
   * @param argCustomerId to initialize customerId.
   * @param argFoodId to initialize food id.
   * @param argFoodName to initialize food name.
   * @param argWalletName to initialize walletName.
   * @param argWalletAmount to initialize walletAmount.
   * @param argFoodQty to initialize food quantity.
   * @param argFoodPrice to initialize food price.
   * @param argOrderId to initialize order id.
   */




  public Shipping(final int argCustomerId,final String argFoodName,final int noOfItems, final double argFoodPrice, final int argOrderId, final double amountToBePaid) {
    this.customerId = argCustomerId;
    this.foodName = argFoodName;
    this.noOfItems = noOfItems;
	  this.foodPrice = argFoodPrice;
    this.orderId = argOrderId;
    this.amountToBePaid = amountToBePaid;
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
     * @return this food ID.
     */

    /**
     * @return this food Name.
     */
  public final String getFoodName() {
    return foodName;
  }
    /**
     * @param argFoodName gets the food name.
     */
  public final void setFoodName(final String argFoodName) {
    this.foodName = argFoodName;
  }
  	/**
     * @return this customer walletName.
     */

    /**
     * @return this customer walletAmount.
     */

  	/**
     * @return this foodQuantity.
     */
  public final int getNoOfItems() {
    return noOfItems;
  }
    /**
     * @param argFoodQty gets the food Quantity.
     */
  public final void setNoOfItems(final int noOfItems) {
    this.noOfItems = noOfItems;
  }
    /**
     * @return this foodPrice.
     */
  public final double getFoodPrice() {
    return foodPrice;
  }
    /**
     * @param argFoodPrice gets the food Price.
     */
  public final void setFoodPrice(final double argFoodPrice) {
    this.foodPrice = argFoodPrice;
  }
  	/**
     * @return this Order id.
     */
  public final int getOrderId() {
    return orderId;
  }
  	/**
     * @param argOrderId gets order id.
     */
  public final void setOrderId(final int argOrderId) {
    this.orderId = argOrderId;
  }

  public final double getAmountToBePaid() {
      return amountToBePaid;
  }

  public void setAmountToBePaid(double amountToBePaid) {
      this.amountToBePaid = amountToBePaid;
  }



  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Shipping bill = (Shipping) obj;
    if (Objects.equals(customerId, bill.customerId)
        && Objects.equals(foodName, bill.foodName) && Objects.equals(noOfItems, bill.noOfItems) && Objects.equals(foodPrice, bill.foodPrice) && Objects.equals(orderId, bill.orderId) && Objects.equals(amountToBePaid, bill.amountToBePaid) ) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(customerId,foodName,noOfItems,foodPrice,orderId,amountToBePaid);
  }
}