package com.hexaware.MLP319.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP319.model.Coupon;
import java.util.Date;
// import org.skife.jdbi.v2.sqlobject.BindBean;
/**
 * CouponDAO class used to fetch data from data base.
 * @author hexware
 */
public interface CouponDAO {
    /**
     * @return the all the Vendor record.
     */
  @SqlQuery("Select * from coupon")
    @Mapper(CouponMapper.class)
    List<Coupon> show();
    /**
     * @return all the vendor record by ven_id.
     * @param cid giving ven id.
     * @param vid giving ven id.
     */
  @SqlQuery("SELECT * FROM coupon WHERE cust_id=:cid and ven_id=:vid")
    @Mapper(CouponMapper.class)
    Coupon showcoupon(@Bind("cid") int cid, @Bind("vid") int vid);
    /**
     * @return all the vendor record by ven_id.
     * @param cid giving ven id.
     * @param vid giving ven id.
     */
  @SqlQuery("SELECT count(*) FROM coupon WHERE cust_id=:cid and ven_id=:vid")
    // @Mapper(VendorMapper.class)
    int showcount(@Bind("cid") int cid, @Bind("vid") int vid);
    /**
     * @return coupondetails for all order records.
     * @param dateCoupon giving ven id.
     * @param custId giving ven id.
     * @param venId giving ven id.
     */
//   @SqlUpdate("insert into coupon(coupon_name,date_coupon,cust_id,ven_id)"
//       + "values(':coupname',:dateCoupon,:custId,:venId)")
//      int couponUpdate(@Bind("coupname") String couponName,@Bind("dateCoupon") Date dateCoupon, @Bind("custId")int custId, @Bind("venId")int venId);


     @SqlUpdate("insert into coupon(coupon_name, date_coupon,cust_id,ven_id) values(:cname, :cdate, :cid, :vid)")
     @Mapper(CouponMapper.class)
     int createCoupon(@Bind("cname")String couponName, @Bind("cdate")Date dateCoupon, @Bind("cid")int custId,@Bind("vid")int venId);

}
