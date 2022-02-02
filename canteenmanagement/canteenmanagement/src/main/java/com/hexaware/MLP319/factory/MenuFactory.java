package com.hexaware.MLP319.factory;

import com.hexaware.MLP319.persistence.MenuDAO;
import com.hexaware.MLP319.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP319.model.Menu;
/**
 * MenuFactory class used to fetch menu data from database.
 * @author hexware
 */
public class MenuFactory {
  /**
   *  Protected constructor.
   */
  public MenuFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static MenuDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(MenuDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Menu[] showMenu() {
    List<Menu> menu = dao().show();
    return menu.toArray(new Menu[menu.size()]);
  }
  public static int addingitem(final int foodId, final String foodName, final int foodQty, final double foodPrice, final int vendorId) {
    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
    int result=dao.createMenuItem(foodId, foodName, foodQty, foodPrice, vendorId);
    return result;
  }
  public static Menu viewingitem(final int foodId) {

    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
    Menu menu = dao.findById(foodId);
    return menu;
  }

  public static int deletingitem(final int foodId) {
    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
    int result1=dao.deleteById(foodId);
    return result1;
  }

  public static int updatequantity(final int foodId, final int foodQty) {
    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
    int result2=dao.updateQty(foodId, foodQty);
    return result2;
  }
  public static int updateprice(final int foodId, final int foodPrice) {
    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
    int result3 = dao.updatePrice(foodId, foodPrice);
    return result3;
  }
  public static int updatefname(final int foodId, final String foodName) {
    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
    int result4=dao.updateFName(foodId, foodName);
    return result4;
  }
  public static int updateMenudetails(final Menu menu) {
    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
    int result1 = dao.update(menu);
    return result1;
  }



  public static int findquantity(final int foodId) {

    DbConnection db = new DbConnection();
    MenuDAO dao = db.getConnect().onDemand(MenuDAO.class);
    Menu menu = dao.findById(foodId);
    return menu.getFoodQty();
  }




}
