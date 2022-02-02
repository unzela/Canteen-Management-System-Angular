package com.hexaware.MLP319.util;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP319.model.Vendor;
import com.hexaware.MLP319.factory.VendorFactory;


/**
 * @author Lazmi rajput.
 * Vendor Rest Service.
 */

/**
 * This class provides a REST interface for the vendor entity.
 */
@Path("/vendors")
public class VendorRest {
    /**
   * Returns Vendor details.
   * @return the vendor details
   */



    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public final Vendor[] show() {
        Vendor[] vendors = VendorFactory.showVendor();
        return vendors;
    }

    @GET
    @Path("/get/{vendorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public final Vendor findByVId(@PathParam("vendorId") final int vendorId)
    {
        Vendor vendor = VendorFactory.viewvendor(vendorId);
        return vendor;

    }
    @GET
    @Path("/find/{vendorEmail}/{vendorPassword}")
    @Produces(MediaType.APPLICATION_JSON)
    public final Vendor displays(@PathParam("vendorEmail") final String vendorEmail, @PathParam("vendorPassword") final String vendorPassword)
    {
        Vendor vendor1 = VendorFactory.checkVendor(vendorEmail, vendorPassword);
        return vendor1;

    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createVendor(Vendor c) {
     String msg = null;
       int n = VendorFactory.createVendor(c.getVendorId(), c.getVendorName(), c.getVendorEmail(), c.getvendorContactNo(), c.getVendorAddress(), c.getVendorPassword());
       if(n !=0) {
           msg = "Successfully vendor Record Inserted.";
       } else {
           msg = "Please try again.";
       }
     return msg;
    }
     @DELETE
    @Path("/delete/{vendorId}")
    public String deleteById(@PathParam("vendorId")int vendorId){
         String res = null;
       int n =VendorFactory.deleteVendor(vendorId);
       if(n!=0) {
           res = "Successfully Customer Deleted.";
       }else{
         res = "vendor not deleted. Please try again";
       }
       return res;
    }
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/update")
  public String updateVendorItem(Vendor vendor) {
  String str = null;
  VendorFactory.updateVendordetails(vendor);
  str = "Vendor is Successfully Updated. ";
  return str;
   }



}