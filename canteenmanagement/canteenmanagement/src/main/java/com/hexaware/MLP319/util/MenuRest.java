package com.hexaware.MLP319.util;



import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP319.model.Menu;
import com.hexaware.MLP319.factory.MenuFactory;



/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/menu")
public class MenuRest {
  /**
   * Returns Menu details.
   * @return the menu details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/list")
  public final Menu[] listOfMenu() {
    final Menu[] menu = MenuFactory.showMenu();
    return menu;
  }



  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/get/{foodId}")
  public final Menu findById(@PathParam("foodId")int foodId) {
    Menu menu = MenuFactory.viewingitem(foodId);
    return menu;
  }



  // @POST
  // @Path("/create/{foodId}/{foodName}/{foodQuantity}/{foodPrice}/{vendorId}")
  // public int createMenuItem(@PathParam("foodId")int foodId, @PathParam("foodName")String foodName, @PathParam("foodQuantity")int foodQuantity, @PathParam("foodPrice")double foodPrice, @PathParam("vendorId")int vendorId) {
  //   int result = MenuFactory.addingitem(foodId, foodName, foodQuantity, foodPrice, vendorId);
  //   return result;
  // }

  @POST
  //@Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/create")
  public int createMenuItem(Menu m) {
     int result = MenuFactory.addingitem(m.getFoodId(), m.getFoodName(), m.getFoodQty(), m.getFoodPrice(), m.getVendorId());
    return result;
  }



  @DELETE
  @Path("/delete/{foodId}")
  public String deleteFoodItemById(@PathParam("foodId")int foodId) {
    String msg = null;
    int result = MenuFactory.deletingitem(foodId);
    msg = "Yout Item "+result +" successfully deleted.";
    return msg;
  }

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/update/{foodId}/{foodQty}")
  public String updatequantity(@PathParam("foodId")int foodId, @PathParam("foodQty")int foodQty) {
    String str = null;
    int n = MenuFactory.updatequantity(foodId,foodQty);
    str = "Your Item"+n+"succefully updated";
    return str;
  }
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/updateP/{foodId}/{foodPrice}")
  public String updateprice(@PathParam("foodId")int foodId, @PathParam("foodPrice")int foodPrice) {
    String str = null;
    int n = MenuFactory.updateprice(foodId,foodPrice);
    str = "Your Item"+n+"succefully updated";
    return str;
  }
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/updateN/{foodId}/{foodName}")
  public String updatefname(@PathParam("foodId")int foodId, @PathParam("foodName")String foodName) {
    String str = null;
    int n = MenuFactory.updatefname(foodId,foodName);
    str = "Your Item"+n+"succefully updated";
    return str;
  }



  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/update")
  public String updateMenuItem(Menu menu) {
  String str = null;
  MenuFactory.updateMenudetails(menu);
  str = "Your Item is Successfully Updated. ";
  return str;
   }

   @GET
   @Path("/qty/{foodId}")
   @Produces(MediaType.APPLICATION_JSON)
   public final int findqty(@PathParam("foodId") final int foodId) {
       int amt = MenuFactory.findquantity(foodId);
       return amt;
   }



}