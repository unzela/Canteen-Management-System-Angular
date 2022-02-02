package com.hexaware.MLP319.factory;
import com.hexaware.MLP319.persistence.VendorDAO;
import com.hexaware.MLP319.persistence.DbConnection;
import com.hexaware.MLP319.model.Vendor;
import java.util.List;

import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * VendorFactory class used to fetch Vendor data from database.
 * @author hexware
 */
public class VendorFactory {
    /**
     *  Protected constructor.
     */
    public VendorFactory() {

    }
    /**
     * Call the data base connection.
     * @return the connection object.
     */
    private static VendorDAO dao() {
      DbConnection db = new DbConnection();
      return db.getConnect().onDemand(VendorDAO.class);
    }
    /**
     * Call the data base connection.
     * @return the array of Vendor object.
     */
    public static Vendor[] showVendor() {
      List<Vendor> Vendor = dao().show();
      return Vendor.toArray(new Vendor[Vendor.size()]);
    }

    /**
   * @param vendorId to initialize foodId.
   * @return the vendor object.
   */
  public static Vendor viewvendor(final int vendorId) {
    DbConnection db = new DbConnection();
    VendorDAO dao = db.getConnect().onDemand(VendorDAO.class);
    Vendor vendor = dao.findByVId(vendorId);
    return vendor;
  }

  /**
   * @param vendorEmail to initialize vendor email.
   * @param vendorPassword to initialize vendor password.
   * @return vendor object.
   */
  public static Vendor checkVendor(final String vendorEmail, final String vendorPassword) {
    DbConnection db = new DbConnection();
    VendorDAO dao = db.getConnect().onDemand(VendorDAO.class);
    Vendor vendor = dao.displays(vendorEmail, vendorPassword);
    return vendor;
  }

/**
   * Insert new vendor.
   * @param vendorId to initialize vendor id.
   * @param vendorName to initialize vendorName.
   * @param vendorEmail to initialize vendorEmail.
   * @param vendorContactNo to initialize vendorPhoneNo.
   * @param vendorAddress to initialize vendorAddress.
   * @param vendorPassword to initialize vendorPassword.
   * @return new vendor record.
   */
  public static int createVendor(final int vendorId, final String vendorName, final String vendorEmail, final String vendorContactNo, final String vendorAddress, final String vendorPassword) {
    DbConnection db = new DbConnection();
    VendorDAO dao = db.getConnect().onDemand(VendorDAO.class);
    int addCusres = dao.createVendor(vendorId, vendorName, vendorEmail, vendorContactNo, vendorAddress, vendorPassword);
    try{
      //Get the session object
      Properties prop = new Properties();
      prop.put("mail.smtp.host", "smtp.gmail.com");
      prop.put("mail.smtp.socketFactory.port", "465");
      prop.put("mail.smtp.socketFactory.class",
          "javax.net.ssl.SSLSocketFactory");
      prop.put("mail.smtp.auth", "true");
      prop.put("mail.smtp.port", "465");

      Session session = Session.getInstance(prop,
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
       message.addRecipient(Message.RecipientType.TO, new InternetAddress(vendorEmail));
       message.setSubject("Vendor Account created for Canteen Management System");
       String url = "<a href= http://localhost:60320/customer> Signin </a>";
       message.setText("Hi, Greetings from MLP319. Welcome to our MLP319's Canteen Management System. Your login URL is." + url);
       System.out.println("Test mail");

      //send message
      transport.send(message);
      transport.close();
      } catch (MessagingException e) {
        System.out.println("Email Sending Problem");
     }
    return addCusres;
  }
  /**
   * Update the vendor details.
   * @param vendor to initialize Vendor object.
   * @return the updated vendor.
   */
  public static int updateVendordetails(final Vendor vendor) {
    DbConnection db = new DbConnection();
    VendorDAO dao = db.getConnect().onDemand(VendorDAO.class);
    int result1 = dao.updateVendor(vendor);
    return result1;
  }

  /**
   * Delete the vendor.
   * @param vendorId to initialize the vendorId.
   * @return result.
   */
  public static int deleteVendor(final int vendorId) {
    DbConnection db = new DbConnection();
    VendorDAO dao = db.getConnect().onDemand(VendorDAO.class);
    int result = dao.deleteById(vendorId);
    return result;
  }
}