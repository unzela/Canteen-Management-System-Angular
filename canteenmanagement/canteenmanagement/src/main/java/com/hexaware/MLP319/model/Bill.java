package com.hexaware.MLP319.model;

import java.util.Objects;

/**
 * Bill class used to display bill information.
 * @author hexware
 */
public class Bill {
  private int customerId;
  private int foodId;
  private String foodName;
  private String walletName;
  private double walletAmount;
  private int foodQty;
  private double foodPrice;
  private int orderId;
  /**
   * Default Constructor.
   */
  public Bill() {

  }
  public Bill(final int argCustomerId) {
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
  public Bill(final int argCustomerId, final int argFoodId, final String argFoodName, final String argWalletName, final double argWalletAmount, final int argFoodQty, final double argFoodPrice, final int argOrderId) {
    this.customerId = argCustomerId;
	  this.foodId = argFoodId;
    this.foodName = argFoodName;
	  this.walletName = argWalletName;
	  this.walletAmount = argWalletAmount;
	  this.foodQty = argFoodQty;
	  this.foodPrice = argFoodPrice;
    this.orderId = argOrderId;
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
  public final String getWalletName() {
    return walletName;
  }
    /**
     * @param argWalletName gets the customer walletName.
     */
  public final void setWalletName(final String argWalletName) {
    this.walletName = argWalletName;
  }
    /**
     * @return this customer walletAmount.
     */
  public final double getWalletAmount() {
    return walletAmount;
  }
    /**
     * @param argWalletAmount gets the customer walletAmount.
     */
  public final void setWalletAmount(final double argWalletAmount) {
    this.walletAmount = argWalletAmount;
  }
  	/**
     * @return this foodQuantity.
     */
  public final int getFoodQty() {
    return foodQty;
  }
    /**
     * @param argFoodQty gets the food Quantity.
     */
  public final void setFoodQty(final int argFoodQty) {
    this.foodQty = argFoodQty;
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

  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Bill bill = (Bill) obj;
    if (Objects.equals(customerId, bill.customerId) && Objects.equals(foodId, bill.foodId)
        && Objects.equals(foodName, bill.foodName) && Objects.equals(walletName, bill.walletName) && Objects.equals(walletAmount, bill.walletAmount) && Objects.equals(foodQty, bill.foodQty) && Objects.equals(foodPrice, bill.foodPrice) && Objects.equals(orderId, bill.orderId) ) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(customerId,foodId,foodName,walletName,walletAmount,foodQty,foodPrice,orderId);
  }
}