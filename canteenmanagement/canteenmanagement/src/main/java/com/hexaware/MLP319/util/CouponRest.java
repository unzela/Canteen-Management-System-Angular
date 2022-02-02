package com.hexaware.MLP319.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP319.model.Coupon;
import com.hexaware.MLP319.factory.CouponFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/coupon")
public class CouponRest {
  /**
   * Returns Menu details.
   * @return the menu details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Coupon[] listcoupon() {
    final Coupon[] coupon = CouponFactory.show();
    return coupon;
  }
  /**
   * Returns Menu details.
   * @param cid for menu id.
    * @param vid for menu id.
   * @return the menu details.
   */
  @GET
  @Path("/count/{cid}/{vid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final int listcount(@PathParam("cid") final int cid, @PathParam("vid") final int vid) {
    final int count = CouponFactory.showcount(cid, vid);
    return count;
  }
  /**
   * Returns Menu details.
   * @param cid for menu id.
    * @param vid for menu id.
   * @return the menu details.
   */
  @GET
  @Path("{cid}/{vid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Coupon listcou(@PathParam("cid") final int cid, @PathParam("vid") final int vid) {
    final Coupon coupon = CouponFactory.showcoupon(cid, vid);
    return coupon;
  }

  @POST
  //@Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/create")
  public int createCoupon(Coupon m) {
     int result = CouponFactory.addingcoupon( m.getDateCoupon(), m.getCustId(), m.getVenId());
    return result;
  }

}
