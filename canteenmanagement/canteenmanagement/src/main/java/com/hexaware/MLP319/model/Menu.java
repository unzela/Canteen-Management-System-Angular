package com.hexaware.MLP319.model;
import java.util.Objects;
/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Menu {
/**
 * foodId to store foodId.
 */
  private int foodId;
  /**
 * foodName to store foodName.
 */
  private String foodName;
 /**
 * foodQtyto store foodQty.
 */
  private int foodQty;



 /**
 * foodPrice store foodPrice.
 */
  private int foodPrice;



 /**
 * vendor id store vendorId.
 */
  private int vendorId;
  /**
  * Default Constructor.
  */
  public Menu() {
  }
   /**
 * @param argFoodId to initialize food id.
 * used to get details through constructor.
 */
  public Menu(final int argFoodId) {
    this.foodId = argFoodId;
  }

   /**
 * @param argFoodId to initialize food id.
 * @param argfoodQty to initialize food qty.
 * used to get details through constructor.
 */
public Menu(final int argFoodId, final int argfoodQty) {
  this.foodId = argFoodId;
  this.foodQty = argfoodQty;
}
/**
 * @param argFoodId to initialize food id.
 *  @param argfoodName to initialize food name.
 *  @param argfoodQty to initialize food qty.
 *  @param argfoodPrice to initialize food price.
 *  @param argvendorId to initialize vendor id.
 * used to get details through constructor.
 */
  public Menu(final int argFoodId, final String argfoodName, final int argfoodQty, final int argfoodPrice, final int argvendorId) {
    this.foodId = argFoodId;
    this.foodName = argfoodName;
    this.foodQty = argfoodQty;
    this.foodPrice = argfoodPrice;
    this.vendorId = argvendorId;
  }




  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(foodId, menu.foodId) && Objects.equals(foodName, menu.foodName)
        && Objects.equals(foodQty, menu.foodQty) && Objects.equals(foodPrice, menu.foodPrice) && Objects.equals(vendorId, menu.vendorId)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(foodId, foodName, foodQty, foodPrice, vendorId);
  }
    /**
     * @return this food ID.
     */
  public final int getFoodId() {
    return foodId;
  }



    /**
     * @return this food Name.
     */
  public final String getFoodName() {
    return foodName;
  }
    /**
     * @param argFoodId gets the food id.
     */
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }
      /**
     * @param argFoodName gets the food Name.
     */
  public final void setFoodName(final String argFoodName) {
    this.foodName = argFoodName;
  }
      /**
     * @return this food Qty.
     */
  public final int getFoodQty() {
    return foodQty;
  }
     /**
     * @param argFoodQty gets the food id.
     */
  public final void setFoodQty(final int argFoodQty) {
    this.foodQty = argFoodQty;
  }



        /**
     * @return this food Price.
     */
  public final int getFoodPrice() {
    return foodPrice;
  }
     /**
     * @param argFoodPrice gets the food price.
     */
  public final void setFoodPrice(final int argFoodPrice) {
    this.foodPrice = argFoodPrice;
  }



      /**
     * @return this vendor ID.
     */
  public final int getVendorId() {
    return vendorId;
  }



    /**
     * @param argVendorId gets the food id.
     */
  public final void setVendorId(final int argVendorId) {
    this.vendorId = argVendorId;
  }
}
