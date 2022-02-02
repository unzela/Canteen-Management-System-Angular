package com.hexaware.MLP319.util;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP319.model.Order;
import com.hexaware.MLP319.model.Favourite;
import com.hexaware.MLP319.factory.OrderFactory;
import com.hexaware.MLP319.model.Bill;
// import com.hexaware.MLP319.model.Coupon;
import com.hexaware.MLP319.model.Shipping;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/order")
public class OrderRest {
  /**
   * Returns Order details.
   * @return the order details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list")
  public final Order[] showOrder() {
    final Order[] order = OrderFactory.showOrder();
    return order;
  }

  // @POST
  //   @Path("/create/{orderId}/{foodId}/{customerId}/{vendorId}/{noofitems}/{orderdatetime}/{amounttobepaid}/{tokennumber}/{status}/{comment}")
  //   public final String createOrder(@PathParam("orderId") int orderId, @PathParam("foodId") int foodId, @PathParam("customerId") int customerId, @PathParam("vendorId") int vendorId, @PathParam("noofitems") int noOfItems,@PathParam("orderdatetime") String orderDateTime, @PathParam("amounttobepaid") double amountToBePaid, @PathParam("tokennumber") int tokenNumber, @PathParam("status") String status, @PathParam("comment") String comment) {
  //    String msg = null;
  //      int n = OrderFactory.createOrder(orderId, foodId, customerId, vendorId, noOfItems, orderDateTime, amountToBePaid, tokenNumber, status, comment);
  //      if(n !=0) {
  //          msg = "Successfully Customer Record Inserted.";
  //      } else {
  //          msg = "Notable to Created Customer Record.Please try again";
  //      }
  //    return msg;
  //   }
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public final String createOrder(Order o) {
     String msg = null;
       int n = OrderFactory.createOrder(o.getOrderId(), o.getFoodId(), o.getVendorId(), o.getCustomerId(), o.getNoOfItems(), o.getOrderDateTime(), o.getAmountToBePaid(), o.getTokenNumber(), o.getStatus(), o.getComment());
       if(n !=0) {
           msg = "Successfully Customer Record Inserted.";
       } else {
           msg = "Notable to Created Customer Record.Please try again";
       }
     return msg;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listcus/{customerId}")
    public final Order[] showAllOrders(@PathParam("customerId") int customerId) {
      final Order[] order = OrderFactory.showAllOrders(customerId);
      return order;
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/sameorder/{token}")
    public final Order[] showTokenOrders(@PathParam("token") int tokenNumber) {
      final Order[] order = OrderFactory.showByToken(tokenNumber);
      return order;
    }


    @GET
    @Path("/get/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public final Order showOById(@PathParam("orderId") final int orderId) {
        Order order = OrderFactory.showOById(orderId);
        return order;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listvendor/{vendorId}")
    public final Order[] showAllVOrders(@PathParam("vendorId") int vendorId) {
      final Order[] order = OrderFactory.showAllVOrders(vendorId);
      return order;
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updatestatus/{orderId}/{status}")
    public String updateStatus(@PathParam("orderId")int orderId, @PathParam("status")String status) {
      String str = null;
      OrderFactory.updateStatus(orderId,status);
      str = "Status is succefully updated";
      return str;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/liststatus/{status}")
    public final Order[] showbystatus(@PathParam("status") String status) {
      final Order[] order = OrderFactory.showbystatus(status);
      return order;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listall/allorders")
    public final Bill[] showByBill() {
      final Bill[] bill = OrderFactory.showOrders();
      return bill;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/bill/{orderId}")
    public final Shipping generateBill(@PathParam("orderId")int orderId)
    {
      final Shipping b = OrderFactory.generateBill(orderId);
      return b;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/count/{customerId}")
    public final int cntorderbycust(@PathParam("customerId") int customerId)
    {
      final int cnt = OrderFactory.custordcnt(customerId);
      return cnt;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cntbydate/{customerId}")
    public final int showByDate(@PathParam("customerId") int customerId) {
      final int order = OrderFactory.showByDate(customerId);
      return order;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cntbyvendor/{customerId}/{vendorId}")
    public final int showcntbyvendor(@PathParam("customerId") int customerId,@PathParam("vendorId") int vendorId) {
      final int order = OrderFactory.showcntbyvendor(customerId,vendorId);
      return order;
    }





    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list/{customerId}/{status}")
    public final Order[] showStatus(@PathParam("customerId") int customerId, @PathParam("status") String status) {
      final Order[] order = OrderFactory.showstatus(customerId, status);
      return order;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listplaced/{customerId}/{status}")
    public final Order[] showStatusplaced(@PathParam("customerId") int customerId, @PathParam("status") String status) {
      final Order[] order = OrderFactory.showstatusplaced(customerId, status);
      return order;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listfav/{customerId}")
    public final Favourite[] showAllFav(@PathParam("customerId") int customerId) {
      final Favourite[] order = OrderFactory.showbyFav(customerId);
      return order;
    }

    @POST
  @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addfav/{foodId}/{customerId}/{foodName}/{foodPrice}")
    public final String addFav(@PathParam("foodId") int foodId,@PathParam("customerId") int customerId, @PathParam("foodName") String foodName,@PathParam("foodPrice") int foodPrice) {
     String msg = null;
       int n = OrderFactory.addFav(foodId,customerId,foodName,foodPrice);
       if(n !=0) {
           msg = "Successfully Added.";
       } else {
           msg = "Notable to Add";
       }
     return msg;
    }

    @DELETE
    @Path("/del/{foodId}/{customerId}")
    public String del(@PathParam("foodId")int foodId, @PathParam("customerId")int customerId) {
      String msg = null;
      int result = OrderFactory.delete(foodId,customerId);
      msg = "Yout Item "+result +" successfully deleted.";
      return msg;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/counting/{customerId}/{vendorId}")
    public final Order[] showAll(@PathParam("customerId") int customerId,@PathParam("vendorId") int vendorId) {
      final Order[] order = OrderFactory.showtiming(customerId,vendorId);
      return order;
    }

    // @GET
    // @Path("/getcoupon/{customerId}/{vendorId}")
    // @Produces(MediaType.APPLICATION_JSON)
    // public final Coupon showCoupon(@PathParam("customerId") final int customerId,@PathParam("vendorId") final int vendorId) {
    //     Coupon cou = OrderFactory.getcoupon(customerId,vendorId);
    //     return cou;
    // }

}