package com.hexaware.MLP319.model;
import java.util.Objects;

public class Favourite {

  private int foodId;
  private int customerId;
  private String foodName;
  private int foodPrice;



  public Favourite() {
  }

  public Favourite(final int foodId, final int customerId, final String foodName, final int foodPrice) {
    this.foodId = foodId;
    this.customerId = customerId;
    this.foodName = foodName;
    this.foodPrice=foodPrice;
  }

  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Favourite menu = (Favourite) obj;
    if (Objects.equals(foodId, menu.foodId) && Objects.equals(foodName, menu.foodName)
        && Objects.equals(customerId, menu.customerId) && Objects.equals(foodPrice, menu.foodPrice) ) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(foodId, customerId,foodName,foodPrice);
  }

  public final int getFoodId() {
    return foodId;
  }

  public final String getFoodName() {
    return foodName;
  }

  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }

  public final void setFoodName(final String argFoodName) {
    this.foodName = argFoodName;
  }

  public final int getFoodPrice() {
    return foodPrice;
  }

  public final void setFoodPrice(final int argFoodPrice) {
    this.foodPrice = argFoodPrice;
  }


  public final int getCustomerId() {
    return customerId;
  }

  public final void setCustomerId(final int argCustomerId) {
    this.customerId = argCustomerId;
  }
}
