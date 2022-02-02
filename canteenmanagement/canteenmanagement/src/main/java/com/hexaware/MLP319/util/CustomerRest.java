package com.hexaware.MLP319.util;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP319.model.Customer;
import com.hexaware.MLP319.factory.CustomerFactory;







/**
 * @author Chandra.
 * Customer Rest Service.
 */



 @Path("/customers")
public class CustomerRest {



    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public final Customer[] showCustomers() {
        Customer[] customers = CustomerFactory.show();
        return customers;
    }



    @GET
    @Path("/get/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public final Customer findByCId(@PathParam("customerId") final int customerId) {
        Customer customer = CustomerFactory.viewcustomer(customerId);
        return customer;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public  String createCustomerId(Customer c) {
     String msg = null;
       int n = CustomerFactory.addingcustomer(c.getCustomerId(), c.getCustomerName(), c.getCustomerEmail(), c.getCustomerAddress(), c.getCustomerMobile(),c.getCustomerPassword(), c.getWalletName(), c.getWalletAmount());
       if(n !=0) {
           msg = "Successfully Customer Record Inserted.";
       } else {
           msg = "Notable to Created Customer Record.Please try again";
       }
     return msg;
    }



    @DELETE
    @Path("/delete/{customerId}")
    public String deleteById(@PathParam("customerId")int customerId) {
       String res = null;
       int n =CustomerFactory.deleting(customerId);
       if(n!=0) {
           res = "Successfully Customer Deleted.";
       }else{
         res = "Customer Notable to Deleted.Please try again";
       }
       return res;
    }



    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updatewn/{customerId}/{walletName}")
    public String updatingwalletname(@PathParam("customerId")int customerId, @PathParam("walletName")String walletName) {
    String str = null;
    int n = CustomerFactory.updatingwalletname(customerId,walletName);
    str = "Your Item"+n+"succefully updated";
    return str;
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updatewa/{customerId}/{walletAmount}")
    public String addingwallet(@PathParam("customerId")int customerId, @PathParam("walletAmount")int walletAmount) {
    String str = null;
    int n = CustomerFactory.addingwallet(customerId,walletAmount);
    str = "Your Item"+n+"succefully updated";
    return str;
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updatename/{customerId}/{customerName}")
    public String updatingname(@PathParam("customerId")int customerId, @PathParam("customerName")String customerName) {
    String str = null;
    int n = CustomerFactory.updatingname(customerId,customerName);
    str = "Your Item"+n+"succefully updated";
    return str;
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateaddr/{customerId}/{customerAddress}")
    public String updatingaddress(@PathParam("customerId")int customerId, @PathParam("customerAddress")String customerAddress) {
    String str = null;
    int n = CustomerFactory.updatingaddress(customerId,customerAddress);
    str = "Your Item"+n+"succefully updated";
    return str;
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updatemobile/{customerId}/{customerMobile}")
    public String updatingnumber(@PathParam("customerId")int customerId, @PathParam("customerMobile")String customerMobile) {
    String str = null;
    int n = CustomerFactory.updatingnumber(customerId,customerMobile);
    str = "Your Item"+n+"succefully updated";
    return str;
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updatepass/{customerId}/{customerPassword}")
    public String updatingpassword(@PathParam("customerId")int customerId, @PathParam("customerPassword")String customerPassword) {
    String str = null;
    int n = CustomerFactory.updatingpassword(customerId,customerPassword);
    str = "Your Item"+n+"succefully updated";
    return str;
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updatemail/{customerId}/{customerEmail}")
    public String updatingemail(@PathParam("customerId")int customerId, @PathParam("customerEmail")String customerEmail) {
    String str = null;
    int n = CustomerFactory.updatingemail(customerId,customerEmail);
    str = "Your Item"+n+"succefully updated";
    return str;
    }


    @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/update")
  public String updateCustomer(Customer customer) {
  String str = null;
  CustomerFactory.updatecustomerdetails(customer);
  str = "Customer is Successfully Updated. ";
  return str;
   }

   @GET
   @Path("/find/{customerEmail}/{customerPassword}")
   @Produces(MediaType.APPLICATION_JSON)
   public final Customer displays(@PathParam("customerEmail") final String customerEmail, @PathParam("customerPassword") final String customerPassword)
   {
       Customer c = CustomerFactory.checkCustomer(customerEmail, customerPassword);
       return c;

   }

   @GET
   @Path("/walletamount/{customerId}")
   @Produces(MediaType.APPLICATION_JSON)
   public final double findwalletamount(@PathParam("customerId") final int customerId) {
       double amt = CustomerFactory.findwalletamount(customerId);
       return amt;
   }





}