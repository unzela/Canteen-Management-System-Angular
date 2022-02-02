package com.hexaware.MLP319.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import java.util.List;
import com.hexaware.MLP319.model.Menu;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface MenuDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from Menu")
    @Mapper(MenuMapper.class)
    List<Menu> show();
    /**
     * @param foodId gets the foodId.
     * @return the Menu record with this foodId.
     */
  @SqlQuery("Select * from mlp319.menu where FOOD_ID=:foodid")
    @Mapper(MenuMapper.class)
    Menu findById(@Bind("foodid")int foodId);
    /**
     * @param foodId to initialize foodId.
     * @param foodName to initialize foodName.
     * @param foodQty to initialize foodQty.
     * @param foodPrice to initialize foodPrice.
     * @param vendorId to initialize vendor id.
     * @return a new record.
     */
  @SqlUpdate("insert into mlp319.menu(FOOD_ID, FOOD_NAME, FOOD_QTY, FOOD_PRICE, vendor_id) values(:foodid, :foodname, :foodqty, :foodprice, :vendorid)")
    @Mapper(MenuMapper.class)
    int createMenuItem(@Bind("foodid")int foodId, @Bind("foodname")String foodName, @Bind("foodqty")int foodQty,
                       @Bind("foodprice")double foodPrice, @Bind("vendorid")int vendorId);
    /**
     * Update the food item.
     * @param menu to initialize the Menu object.
     * @return updated menu item.
     */
  @SqlUpdate("update mlp319.menu set "
              + "FOOD_NAME = :menu.foodName, FOOD_QTY= :menu.foodQty, FOOD_PRICE= :menu.foodPrice, vendor_id= :menu.vendorId where "
              + "FOOD_ID = :menu.foodId")
    int update(@BindBean("menu")Menu menu);
    /**
     * Delete the food item.
     * @param foodId to initialize the foodId.
     * @return result.
     */
  @SqlUpdate("delete from mlp319.menu  where FOOD_ID=:foodId")
    @Mapper(MenuMapper.class)
    int deleteById(@Bind("foodId")int foodId);
    /**
     * Update the food Quantity.
     * @param foodId to initialize foodId.
     * @param foodQty to initialize foodQty.
     */
  @SqlUpdate("update mlp319.menu set FOOD_QTY= :foodQty where FOOD_ID= :foodId")
    @Mapper(MenuMapper.class)
    int updateQty(@Bind("foodId")int foodId, @Bind("foodQty")int foodQty);

    @SqlUpdate("update mlp319.menu set FOOD_PRICE= :foodPrice where FOOD_ID= :foodId")
    @Mapper(MenuMapper.class)
    int updatePrice(@Bind("foodId")int foodId, @Bind("foodPrice")int foodPrice);

    @SqlUpdate("update mlp319.menu set FOOD_NAME= :foodName where FOOD_ID= :foodId")
    @Mapper(MenuMapper.class)
    int updateFName(@Bind("foodId")int foodId, @Bind("foodName")String foodName);


}
