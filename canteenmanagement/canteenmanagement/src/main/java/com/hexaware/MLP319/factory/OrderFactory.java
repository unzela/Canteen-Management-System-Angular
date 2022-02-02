package com.hexaware.MLP319.factory;


import com.hexaware.MLP319.persistence.DbConnection;

import com.hexaware.MLP319.persistence.OrderDAO;
import com.hexaware.MLP319.model.Bill;
// import com.hexaware.MLP319.model.Coupon;
import com.hexaware.MLP319.model.Favourite;
import java.util.List;
import com.hexaware.MLP319.model.Shipping;

//import java.sql.Timestamp;
import com.hexaware.MLP319.model.Order;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * OrderFactory class used to fetch order data from database.
 * @author hexware
 */
public class OrderFactory {
  /**
   *  Protected constructor.
   */
  public OrderFactory() {
  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OrderDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrderDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of order object.
   */
  public static Order[] showOrder() {
    List<Order> order = dao().show();
    return order.toArray(new Order[order.size()]);
  }
  /**
   * Insert order.
   * @param orderId to initialize order id.
   * @param foodId to initialize food id.
   * @param vendorId to initialize vendor id.
   * @param customerId to initialize customer id.
   * @param noOfItems to initialize no of items.
   * @param orderDateTime to initialize order date time.
   * @param amountToBePaid to initialize amount to be paid.
   * @param tokenNumber to initialize token number.
   * @param status to initialize status.
   * @param comment to initialize comment.
   * @return orderresult.
   */
  public static int createOrder(final int orderId, final int foodId, final int vendorId, final int customerId, final int noOfItems, final String orderDateTime, final double amountToBePaid, final int tokenNumber, final String status, final String comment) {
    DbConnection db = new DbConnection();
    OrderDAO dao = db.getConnect().onDemand(OrderDAO.class);
    int result1=dao.createOrderItem(orderId, foodId, vendorId, customerId, noOfItems, orderDateTime, amountToBePaid, tokenNumber, status, comment);
    try{
      //Get the session object
      Properties p = new Properties();
      p.put("mail.smtp.host", "smtp.gmail.com");
      p.put("mail.smtp.socketFactory.port", "465");
      p.put("mail.smtp.socketFactory.class",
          "javax.net.ssl.SSLSocketFactory");
      p.put("mail.smtp.auth", "true");
      p.put("mail.smtp.port", "465");

      Session session = Session.getInstance(p,
          new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication("mlp319.cms@gmail.com", "canteen123");
          }
       });

        //compose message

       Transport transport = session.getTransport("smtp");
       transport.connect();
       MimeMessage message = new MimeMessage(session);
       message.setFrom(new InternetAddress("mlp319.cms@gmail.com"));//change accordingly
       message.addRecipient(Message.RecipientType.TO, new InternetAddress("lakshmoji.seemakurthi@gmail.com"));
       message.setSubject("Order placed");
       String url = "<a href= http://localhost:60320/customer> Signin </a>";
       message.setText("Hi, Greetings from MLP319. Welcome to our MLP319's Canteen Management System. Your order has been placed. You'll recieve your food within 10 minutes. Have a great day! Your login URL is." + url);
       System.out.println("Test mail");

      //send message
      transport.send(message);
      transport.close();
      } catch (MessagingException e) {
        System.out.println("Email Sending Problem");
     }
    return result1;

  }
  /**
   * @param customerId to initialize customerId.
   * @return the array of order object.
   */
  public static Order[] showAllOrders(final int customerId) {
    List<Order> order = dao().showById(customerId);
    return order.toArray(new Order[order.size()]);
  }


  public static int showByDate(final int customerId) {
    List<Order> order = dao().showByDate(customerId);
    return order.size();
  }

  public static int showcntbyvendor(final int customerId,final int vendorId) {
    List<Order> order = dao().showByVendor(customerId,vendorId);
    return order.size();
  }

  public static Order[] showtiming(final int customerId,final int vendorId) {
    List<Order> order = dao().showByVendor(customerId,vendorId);
    return order.toArray(new Order[order.size()]);
  }


  public static Order showOById(final int orderId) {
    DbConnection db = new DbConnection();
    OrderDAO dao = db.getConnect().onDemand(OrderDAO.class);
    Order order = dao.showByOId(orderId);
    return order;
  }
  /**
   * @param vendorId to initialize customerId.
   * @return the array of order object.
   */
  public static Order[] showAllVOrders(final int vendorId) {
    List<Order> order = dao().showByVId(vendorId);
    return order.toArray(new Order[order.size()]);
  }
  /**
   * Update the customer walletAmount.
   * @param orderId to initialize customerId.
   * @param status to initialize walletAmount.
   */
  public static int updateStatus(final int orderId, final String status) {
    DbConnection db = new DbConnection();
    OrderDAO dao = db.getConnect().onDemand(OrderDAO.class);
    int result = dao.updateO(orderId, status);
    return result;
  }
  /**
   * Call the data base connection.
   * @return the array of order object.
   */
  public static Bill[] showOrders() {
    List<Bill> bills =  dao().showCart();
    return bills.toArray(new Bill[bills.size()]);
  }




  public static Order[] showbystatus(final String status) {
    DbConnection db = new DbConnection();
    OrderDAO dao = db.getConnect().onDemand(OrderDAO.class);
    List<Order> order1 = dao.showByStatus(status);
    return order1.toArray(new Order[order1.size()]);
  }

  public static Order[] showbycusid(final int customerId) {
    DbConnection db = new DbConnection();
    OrderDAO dao = db.getConnect().onDemand(OrderDAO.class);
    List<Order> order5 = dao.showById(customerId);
    return order5.toArray(new Order[order5.size()]);
  }

  public static Shipping generateBill(final int orderId)
  {
    DbConnection db = new DbConnection();
    OrderDAO dao = db.getConnect().onDemand(OrderDAO.class);
    Shipping b = dao.showOrder(orderId);
    return b;
  }

  public static int custordcnt(final int customerId) {
    List<Order> order = dao().showById(customerId);
    return order.size();
  }

  public static Order[] showstatus(final int customerId, final String status) {
    DbConnection db = new DbConnection();
    OrderDAO dao = db.getConnect().onDemand(OrderDAO.class);
    List<Order> order1 = dao.showStatus(customerId, status);
    return order1.toArray(new Order[order1.size()]);
  }
  public static Order[] showstatusplaced(final int customerId, final String status) {
    DbConnection db = new DbConnection();
    OrderDAO dao = db.getConnect().onDemand(OrderDAO.class);
    List<Order> order1 = dao.showStatusplaced(customerId, status);
    return order1.toArray(new Order[order1.size()]);
  }

  public static Order[] showByToken(final int tokenNumber) {
    List<Order> order = dao().showByToken(tokenNumber);
    return order.toArray(new Order[order.size()]);
  }


  public static Favourite[] showbyFav(final int customerId) {
    DbConnection db = new DbConnection();
    OrderDAO dao = db.getConnect().onDemand(OrderDAO.class);
    List<Favourite> order5 = dao.showFav(customerId);
    return order5.toArray(new Favourite[order5.size()]);
  }


  public static int addFav(final int foodId, final int customerId, final String foodName,final int foodPrice) {
    DbConnection db = new DbConnection();
    OrderDAO dao = db.getConnect().onDemand(OrderDAO.class);
    int result1=dao.addFav(foodId, customerId, foodName, foodPrice);
    return result1;
}

public static int delete(final int foodId, final int customerId) {
  DbConnection db = new DbConnection();
  OrderDAO dao = db.getConnect().onDemand(OrderDAO.class);
  int result1=dao.delete(foodId,customerId);
  return result1;
}

// public static Coupon getcoupon(final int customerId, final int vendorId)
// {
//   DbConnection db = new DbConnection();
//   OrderDAO dao = db.getConnect().onDemand(OrderDAO.class);
//   Coupon result1=dao.showCoupon(customerId,vendorId);
//   return result1;
// }

}
