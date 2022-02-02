package com.hexaware.MLP319.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.Bind;

import java.util.List;
//import java.sql.Timestamp;
import com.hexaware.MLP319.model.Bill;
// import com.hexaware.MLP319.model.Coupon;
import com.hexaware.MLP319.model.Favourite;
import com.hexaware.MLP319.model.Shipping;

import com.hexaware.MLP319.model.Order;
/**
 * OrderDAO class used to fetch data from data base.
 * @author hexware
 */
public interface OrderDAO {
    /**
     * @return the all the Order record.
     */
  @SqlQuery("Select * from MLP319.order")
    @Mapper(OrderMapper.class)
    List<Order> show();
    /**
     * Insert order.
     * @param orderId to initialize order id.
     * @param foodId to initialize food id.
     * @param vendorId to initialize vendor id.
     * @param customerId to initialize customer id.
     * @param noOfItems to initialize no of items.
     * @param orderDateTime to initialize order datetime.
     * @param amountToBePaid to initialize amount to be paid.
     * @param tokenNumber to initialize token number.
     * @param status to initialize status.
     * @param comment to initialize comment.
     * @return new record.
     */
  @SqlUpdate("insert into MLP319.order(order_id,food_id, vendor_id, customer_id, no_of_items, order_date_time, amount_to_be_paid, token_number, status, comment) values(:ooid, :ofid, :ovid, :ocid, :onfi, :odt, :oamt, :otoken, :ostatus, :ocomment)")
    @Mapper(OrderMapper.class)
    int createOrderItem(@Bind("ooid")int orderId, @Bind("ofid")int foodId, @Bind("ovid")int vendorId, @Bind("ocid")int customerId, @Bind("onfi")int noOfItems, @Bind("odt") String orderDateTime, @Bind("oamt")double amountToBePaid, @Bind("otoken")int tokenNumber, @Bind("ostatus")String status, @Bind("ocomment")String comment);
    /**
     * @param customerId gets the customerId.
     * @return the Order record with this customerId.
     */
  @SqlQuery("Select * from MLP319.order where customer_id=:id")
    @Mapper(OrderMapper.class)
    List<Order> showById(@Bind("id")int customerId);

    @SqlQuery("Select * from MLP319.order where customer_id=:id and day(order_date_time)<10")
    @Mapper(OrderMapper.class)
    List<Order> showByDate(@Bind("id")int customerId);

    @SqlQuery("Select * from MLP319.order where customer_id=:id and vendor_id=:vid")
    @Mapper(OrderMapper.class)
    List<Order> showByVendor(@Bind("id")int customerId, @Bind("vid") int vendorId);



    @SqlQuery("Select * from MLP319.order where TOKEN_NUMBER=:token")
    @Mapper(OrderMapper.class)
    List<Order> showByToken(@Bind("token")int tokenNumber);



    /**
     * @param vendorId gets the customerId.
     * @return the Order record with this customerId.
     */
  @SqlQuery("Select * from MLP319.order where vendor_id=:id")
    @Mapper(OrderMapper.class)
    List<Order> showByVId(@Bind("id")int vendorId);
    /**
     * @param orderId gets the customerId.
     * @return the Order record with this orderId.
     */
  @SqlQuery("Select * from MLP319.order where order_id=:id")
    @Mapper(OrderMapper.class)
    Order showByOId(@Bind("id")int orderId);
    /**
     * @return the all Order record.
     */
  @SqlQuery("Select c.customer_id, c.wallet_name, c.wallet_amount, m.FOOD_ID, m.FOOD_NAME, m.FOOD_QTY, m.FOOD_PRICE, o.order_id from MLP319.order o, MLP319.customer c, MLP319.menu m Where o.customer_id=c.customer_id  AND o.food_id=m.FOOD_ID ")
   @Mapper(BillMapper.class)
   List<Bill>  showCart();

   /**
     * Update the customer walletAmount.
     * @param orderId to initialize customerId.
     * @param status to initialize walletAmount.
     */
  @SqlUpdate("update  MLP319.order set status= :status where order_id= :orderId")
    @Mapper(OrderMapper.class)
    int updateO(@Bind("orderId")int orderId, @Bind("status") String status);

  /* @SqlQuery("Select status FROM MLP319.orders where vendor_id = :id and customer_id = :cid and order_date_time = :odt");
      @Mapper(OrderMapper.class)
      List<String> showStatus(@Bind("vendor_id")int vendorId, @Bind("customer_id")int customerId, @Bind("order_date_time")String orderDateTime);
  @SqlUpdate("insert into MLP319.orders(amount_to_paid,token_number,status,comment) values(:oamt, :otn, :ostatus, :ocomment) where order_id=:id")
    @Mapper(OrderMapper.class)
    int orderStatus(@Bind())*/

    @SqlQuery("Select * from mlp319.order where status=:ostatus")
    @Mapper(OrderMapper.class)
    List<Order> showByStatus(@Bind("ostatus")String status);


  @SqlQuery("Select c.customer_id,m.FOOD_NAME, o.no_of_items, m.FOOD_PRICE, o.order_id , o.amount_to_be_paid from MLP319.order o, MLP319.customer c, MLP319.menu m Where o.customer_id=c.customer_id  AND o.food_id=m.FOOD_ID and o.order_id=:oid")
  @Mapper(ShippingMapper.class)
  Shipping showOrder(@Bind("oid") int orderId);


  @SqlQuery("Select * from mlp319.order where customer_id=:id and status!=:ostatus")
    @Mapper(OrderMapper.class)
    List<Order> showStatus(@Bind("id")int customerId, @Bind("ostatus")String status);

  @SqlQuery("Select * from mlp319.order where customer_id=:id and status=:ostatus")
    @Mapper(OrderMapper.class)
    List<Order> showStatusplaced(@Bind("id")int customerId, @Bind("ostatus")String status);


    @SqlQuery("Select * from MLP319.favourite where customer_id=:id")
    @Mapper(FavouriteMapper.class)
    List<Favourite>  showFav(@Bind("id")int customerId);


    @SqlUpdate("insert into MLP319.favourite(food_id, customer_id, food_name, food_price) values(:ofid,:ocid,:ofname, :ofprice )")
      @Mapper(FavouriteMapper.class)
      int addFav(@Bind("ofid")int foodId,@Bind("ocid")int customerId,@Bind("ofname")String foodName, @Bind("ofprice")int foodPrice );

      @SqlUpdate("delete from mlp319.favourite  where FOOD_ID=:foodId and customer_id=:customerId")
      @Mapper(FavouriteMapper.class)
      int delete(@Bind("foodId")int foodId,@Bind("customerId")int customerId);

      // @SqlQuery("select * from mlp319.coupon where customerId=:cid and vendorId=:vid")
      // @Mapper(CouponMapper.class)
      // Coupon showCoupon(@Bind("cid") int customerId, @Bind("vid") int vendorId);



}
