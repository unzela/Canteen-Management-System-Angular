package com.hexaware.MLP319.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import java.util.List;
import com.hexaware.MLP319.model.Vendor;
/**
 * VendorDAO class used to fetch data from data base.
 * @author hexware
 */
public interface VendorDAO {
    /**
     * @return the all the Vendor record.
     */
  @SqlQuery("Select * from MLP319.vendor")
    @Mapper(VendorMapper.class)
    List<Vendor> show();
    /**
     * @param vendorId gets the vendorId.
     * @return the Vendor record with this vendorId.
     */
    @SqlQuery("Select * from mlp319.vendor where vendor_id= :id")
    @Mapper(VendorMapper.class)
    Vendor findByVId(@Bind("id") int vendorId);
    /**
     * @param vendorEmail to initialize vendor email.
     * @param vendorPassword to initialize vendor password.
     * @return vendor object.
     */
    @SqlQuery("Select * from mlp319.vendor where vendor_email= :vendorEmail  AND vendor_password = :vendorPassword")
    @Mapper(VendorMapper.class)
    Vendor displays(@Bind("vendorEmail")String vendorEmail, @Bind("vendorPassword")String vendorPassword);
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
  @SqlUpdate("insert into mlp319.vendor"
              + "(vendor_id, vendor_name, vendor_email, vendor_ContactNo, vendor_address, vendor_password)"
              + "values (:id, :name, :email, :ContactNo, :address, :password)")
    @Mapper(VendorMapper.class)
    int createVendor(@Bind("id")int vendorId, @Bind("name")String vendorName, @Bind("email")String vendorEmail, @Bind("ContactNo")
                     String vendorContactNo, @Bind("address")String vendorAddress, @Bind("password")String vendorPassword);
    /**
     * Update the vendor details.
     * @param vendor to initialize Vendor object.
     * @return the updated vendor.
     */
  @SqlUpdate("update mlp319.vendor set "
             + "vendor_name =:vendor.vendorName, vendor_email=:vendor.vendorEmail, vendor_ContactNo=:vendor.vendorContactNo,"
             + "vendor_address=:vendor.vendorAddress, vendor_password =:vendor.vendorPassword where vendor_id=:vendor.vendorId")
    @Mapper(VendorMapper.class)
    int updateVendor(@BindBean("vendor")Vendor vendor);
    /**
     * Delete the vendor.
     * @param vendorId to initialize the vendorId.
     * @return result.
     */
  @SqlUpdate("delete from mlp319.vendor  where vendor_id = :vendorid")
    @Mapper(VendorMapper.class)
    int deleteById(@Bind("vendorid")int vendorId);
}