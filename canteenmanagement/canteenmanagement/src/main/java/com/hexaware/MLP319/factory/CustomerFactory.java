
package com.hexaware.MLP319.factory;
import com.hexaware.MLP319.persistence.CustomerDAO;
import com.hexaware.MLP319.persistence.DbConnection;
import java.util.List;
import com.hexaware.MLP319.model.Customer;

import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CustomerFactory {

  public static Customer checkCustomer(final String customerEmail, final String customerPassword)
  {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    Customer customer = dao.displays(customerEmail, customerPassword);
    return customer;
  }

  public static int addingcustomer(final int customerId, final String customerName, final String customerEmail, final String customerAddress, final String customerMobile, final String customerPassword, final String walletName, final double walletAmount) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    int result = dao.createCustomerId(customerId, customerName, customerEmail, customerAddress, customerMobile, customerPassword, walletName, walletAmount);
    try{
      //Get the session object
      Properties props = new Properties();
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.put("mail.smtp.socketFactory.port", "465");
      props.put("mail.smtp.socketFactory.class",
          "javax.net.ssl.SSLSocketFactory");
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.port", "465");

      Session session = Session.getInstance(props,
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
       message.addRecipient(Message.RecipientType.TO, new InternetAddress(customerEmail));
       message.setSubject("Registeration Successful to Canteen Management System");
       String url = "<a href= http://localhost:60320/customer> Signin </a>";
       message.setText("Hi, Greetings from MLP319. Welcome to our MLP319's Canteen Management System. Your login URL is." + url);
       System.out.println("Test mail");

      //send message
      transport.send(message);
      transport.close();
      } catch (MessagingException e) {
        System.out.println("Email Sending Problem");
     }
    return result;
  }
  public static Customer viewcustomer(final int customerId) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    Customer customer = dao.findByCId(customerId);
    return customer;
  }
  private static CustomerDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CustomerDAO.class);
  }
  public static Customer[] show() {
    List<Customer> customer = dao().showCustomers();
    return customer.toArray(new Customer[customer.size()]);
  }
  public static int addingwallet(final int customerId, final double walletAmount) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    int result1=dao.updateWA(customerId, walletAmount);
    return result1;
  }
  public static int deleting(final int customerId) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    int result2=dao.deleteById(customerId);
    return result2;
  }
  public static int updatingname(final int customerId, final String customerName) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    int result4 = dao.updateNA(customerId, customerName);
    return result4;
  }
  public static int updatingwalletname(final int customerId, final String walletName) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    int result3 = dao.updatewalletName(customerId, walletName);
    return result3;
  }
    /*public static Customer viewwallet (final int customerId) {
      DbConnection db = new DbConnection();
      CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
      Customer customer1 = dao.findWallet(customerId);
      return customer1;
    }*/
  public static int updatingaddress(final int customerId, final String customerAddress) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    int result5 = dao.updateAD(customerId, customerAddress);
    return result5;
  }

  public static int updatingnumber(final int customerId, final String customerMobile) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    int result6 = dao.updateMO(customerId, customerMobile);
    return result6;
  }
  public static int updatingpassword(final int customerId, final String customerPassword) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    int result7 = dao.updatePA(customerId, customerPassword);
    return result7;
  }
  public static int updatingemail(final int customerId, final String customerEmail) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    int result8 = dao.updateEmail(customerId, customerEmail);
    return result8;
  }
  public static int updatecustomerdetails(final Customer customer) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    int result1 = dao.update(customer);
    return result1;
  }

  public static double findwalletamount(final int customerId) {
    DbConnection db = new DbConnection();
    CustomerDAO dao = db.getConnect().onDemand(CustomerDAO.class);
    Customer customer = dao.findByCId(customerId);
    return customer.getWalletAmount();
  }



}
