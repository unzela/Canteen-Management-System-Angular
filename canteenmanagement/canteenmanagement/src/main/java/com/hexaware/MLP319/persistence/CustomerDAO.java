package com.hexaware.MLP319.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import java.util.List;

import com.hexaware.MLP319.model.Customer;

/**
 * CustomerDAO class used to fetch data from data base.
 * @author hexware
 */
public interface CustomerDAO {
     /**
     * @return the all the Customer record.
     */
  @SqlQuery("Select * from customer")
    @Mapper(CustomerMapper.class)
    List<Customer> showCustomers();
    /**
     * @param customerId gets the customerId.
     * @return the Customer record with this customerId.
     */
  @SqlQuery("Select * from mlp319.customer where customer_id= :id")
    @Mapper(CustomerMapper.class)
    Customer findByCId(@Bind("id") int customerId);
    /**
     * Update the customer details.
     * @param customer to initialize Customer object.
     * @return the updated customer.
     */
  @SqlUpdate("update mlp319.customer set "
              + "customer_name= :customer.customerName, customer_email= :customer.customerEmail, customer_address= :customer.customerAddress,"
              + "customer_mobile= :customer.customerMobile, customer_password= :customer.customerPassword, wallet_name= :customer.walletName,"
              + "wallet_amount= :customer.walletAmount where customer_id= :customer.customerId")
              @Mapper(CustomerMapper.class)
    int update(@BindBean("customer")Customer customer);
    /**
     * Insert new customer.
     * @param customerId to initialize customerId.
     * @param customerName to initialize customerName.
     * @param customerEmail to initialize customerEmail.
     * @param customerAddress to initialize customerAddresss.
     * @param customerMobile to initialize customerMobileNo.
     * @param customerPassword to initialize customerPassword.
     * @param walletName to initialize walletName.
     * @param walletAmount to initialize walletAmount.
     * @return addCusres.
     */
  @SqlUpdate("insert into mlp319.customer"
              + "(customer_id, customer_name, customer_email, customer_address, customer_mobile, customer_password, wallet_name, wallet_amount)"
              + "values(:id, :name, :email, :address, :mobile, :password, :wname, :wamount)")
    @Mapper(CustomerMapper.class)
    int createCustomerId(@Bind("id")int customerId, @Bind("name")String customerName, @Bind("email")String customerEmail, @Bind("address")String
                         customerAddress, @Bind("mobile")String customerMobile, @Bind("password") String customerPassword, @Bind("wname")String
                         walletName, @Bind("wamount")double walletAmount);
    /**
     * Update the customer walletAmount.
     * @param customerId to initialize customerId.
     * @param walletAmount to initialize walletAmount.
     */
  @SqlUpdate("update  mlp319.customer set wallet_amount= :walletAmount where customer_id= :customerId")
    @Mapper(CustomerMapper.class)
    int updateWA(@Bind("customerId")int customerId, @Bind("walletAmount") double walletAmount);
    /**
     * @param customerEmail to initialize customerEmail.
     * @param customerPassword to initialize customerPassword.
     * @return customer list object.
     */
  /*@SqlQuery("Select * from mlp319.customer where customer_email= :customerEmail  AND customer_password = :customerPassword")
    @Mapper(CustomerMapper.class)
    List<Customer> display(@Bind("customerEmail") String customerEmail, @Bind("customerPassword") String customerPassword);
    */
    /**
     * Delete the customer.
     * @param customerId to initialize the customerId.
     * @return result.
     */
  @SqlUpdate("delete from mlp319.customer  where customer_id = :cid")
    @Mapper(CustomerMapper.class)
    int deleteById(@Bind("cid")int customerId);
    /**
     * @param customerEmail to initialize customer email.
     * @param customerPassword to initialize customer password.
     * @return customer object.
     */
  @SqlQuery("Select * from mlp319.customer where customer_email= :customerEmail  AND customer_password = :customerPassword")
    @Mapper(CustomerMapper.class)
    Customer displays(@Bind("customerEmail") String customerEmail, @Bind("customerPassword") String customerPassword);


  @SqlUpdate("update  mlp319.customer set customer_name= :customerName where customer_id= :customerId")
    @Mapper(CustomerMapper.class)
    int updateNA(@Bind("customerId")int customerId, @Bind("customerName") String customerName);

  @SqlUpdate("update  mlp319.customer set wallet_name= :walletName where customer_id= :customerId")
    @Mapper(CustomerMapper.class)
    int updatewalletName(@Bind("customerId")int customerId, @Bind("walletName") String walletName);


  /*@SqlQuery("Select wallet_name, wallet_amount from mlp319.customer where customer_id= :customerid")
    @Mapper(CustomerMapper.class)
    Customer findWallet(@Bind("customerid") int customerId);
    */

  @SqlUpdate("update  mlp319.customer set customer_address= :customerAddress where customer_id= :customerId")
    @Mapper(CustomerMapper.class)
    int updateAD(@Bind("customerId")int customerId, @Bind("customerAddress") String customerAddress);


  @SqlUpdate("update  mlp319.customer set customer_mobile= :customerMobile where customer_id= :customerId")
    @Mapper(CustomerMapper.class)
    int updateMO(@Bind("customerId")int customerId, @Bind("customerMobile") String customerMobile);


  @SqlUpdate("update  mlp319.customer set customer_password= :customerPassword where customer_id= :customerId")
    @Mapper(CustomerMapper.class)
    int updatePA(@Bind("customerId")int customerId, @Bind("customerPassword") String customerPassword);

  @SqlUpdate("update  mlp319.customer set customer_email= :customerEmail where customer_id= :customerId")
    @Mapper(CustomerMapper.class)
    int updateEmail(@Bind("customerId")int customerId, @Bind("customerEmail") String customerEmail);
}
