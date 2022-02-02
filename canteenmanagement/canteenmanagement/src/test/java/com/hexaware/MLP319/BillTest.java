package com.hexaware.MLP319;

import com.hexaware.MLP319.model.Bill;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.Before;

//import java.util.ArrayList;
//import java.util.List;

public class BillTest {

    @Before
    public void initInput(){

    }
    @Test
    public final void testBill(){
        Bill c = new Bill();
        Bill c1 = new Bill(2);
        assertNotEquals(c1, null);
        assertEquals(c1.getCustomerId(),new Bill(2).getCustomerId());
        assertEquals(c1.hashCode(), new Bill(2).hashCode());
    }


    @Test
    public final void testBillcons() {
      final Bill m = new Bill(3,103,"lakshmoji","lakshmoji",73,10,100,10);
      final Bill m1 = new Bill(3,103,"lakshmoji","lakshmoji",73,10,100,10);
      assertEquals(m,m1);
      assertEquals(3, m.getCustomerId());
      assertEquals("lakshmoji",m.getFoodName());
      assertEquals(103,m.getFoodId());
      assertEquals("lakshmoji",m.getWalletName());

      assertEquals(10,m.getFoodQty());

      assertEquals(10,m.getOrderId());

      m.setCustomerId(2);
      m.setFoodName("ramoji");
      m.setFoodId(104);
      m.setWalletName("hyderabad");
      m.setWalletAmount(10000);
      m.setFoodQty(10000);
      m.setFoodPrice(10000);
      m.setOrderId(11);

      assertEquals(2, m.getCustomerId());
      assertEquals("ramoji",m.getFoodName());
      assertEquals(104,m.getFoodId());
      assertEquals("hyderabad",m.getWalletName());

      assertEquals(10000,m.getFoodQty());

      assertEquals(11,m.getOrderId());

    }




}