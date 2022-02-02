package com.hexaware.MLP319.model;

import com.hexaware.MLP319.model.Order;
import com.hexaware.MLP319.factory.OrderFactory;
import com.hexaware.MLP319.model.Bill;
import com.hexaware.MLP319.persistence.OrderDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;

public class OrderTest {

    @Before
    public void initInput(){


    }
    @Test
    public final void testOrder(){
        Order o = new Order();
        Order o1 = new Order(2);
        assertNotEquals(o1, null);
        assertEquals(o1.getOrderId(),new Order(2).getOrderId());
        assertEquals(o1.hashCode(), new Order(2).hashCode());
    }


    @Test
  public final void testListAllEmpty(@Mocked final OrderDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Order>();
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };
    Order[] me = OrderFactory.showOrder();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final OrderDAO dao) {
    final Order m100 = new Order(100);
    final Order m101 = new Order(101);
    final ArrayList<Order> mn = new ArrayList<Order>();
    new Expectations() {
      {
        mn.add(m100);
        mn.add(m101);
        dao.show(); result = mn;
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };
    Order[] mn1 = OrderFactory.showOrder();
    assertEquals(2, mn1.length);
    assertEquals(new Order(100).getOrderId(),
        mn1[0].getOrderId());
    assertEquals(new Order(101).getOrderId(),
        mn1[1].getOrderId());
  }


  @Test
  public final void testOrdercons() {
    final Order m = new Order(11,101,1,1,10,"2021/02/28",500,15240,"processing","fast");
    assertEquals(11, m.getOrderId());
    assertEquals(101,m.getFoodId());
    assertEquals(1,m.getVendorId());
    assertEquals(1,m.getCustomerId());
    assertEquals(10,m.getNoOfItems());
    assertEquals("2021/02/28",m.getOrderDateTime());
    //assertEquals(500,m.getAmountToBePaid());
    assertEquals(15240,m.getTokenNumber());
    assertEquals("processing",m.getStatus());
    assertEquals("fast",m.getComment());
    m.setStatus("Placed");
    m.setNoOfItems(15);
    m.setFoodId(10);
    m.setCustomerId(2);
    m.setTokenNumber(152);
    m.setComment("spicy");
    m.setOrderDateTime("2021/03/03");
    m.setOrderId(5);
    m.setVendorId(10);
    assertEquals("Placed",m.getStatus());
    assertEquals(15,m.getNoOfItems());
    assertEquals(10,m.getFoodId());
    assertEquals(2,m.getCustomerId());
    assertEquals(152,m.getTokenNumber());
    assertEquals("2021/03/03",m.getOrderDateTime());
    assertEquals(5,m.getOrderId());
    assertEquals(10,m.getVendorId());
    assertEquals("spicy",m.getComment());
  }

  @Test
  public final void testcreateOrderItem(@Mocked final OrderDAO dao){
    final Order o = new Order(996,101,1,1,10,"2021/02/28",500,15240,"processing","fast");
    new Expectations(){

      {
        dao.createOrderItem(o.getOrderId(),o.getFoodId(),o.getVendorId(),o.getCustomerId(),o.getNoOfItems(),o.getOrderDateTime(),o.getAmountToBePaid(),o.getTokenNumber(),o.getStatus(),o.getComment());
        result=1;
        minTimes=0;
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };

    int n=OrderFactory.createOrder(o.getOrderId(),o.getFoodId(),o.getVendorId(),o.getCustomerId(),o.getNoOfItems(),o.getOrderDateTime(),o.getAmountToBePaid(),o.getTokenNumber(),o.getStatus(),o.getComment());
    assertEquals(1,n);

  }

  /*@Test
  public final void testshowByOId(@Mocked final OrderDAO dao) {
    final Order o2 = new Order(1);
    new Expectations() {
      {
        dao.showByOId(1);
        result =1;
        minTimes=0;
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };
    Order n2=OrderFactory.showOById(o2.getOrderId());
    assertEquals(101,OrderFactory.showOById(1).getFoodId());
  }*/
  @Test
  public final void testbystatus(@Mocked final OrderDAO dao) {
    final Order o = new Order(4,101,1,1,10,"2021/02/28",500,15240,"processing","fast");
    final ArrayList<Order> mn = new ArrayList<Order>();
    new Expectations() {
      {
        dao.showByStatus(o.getStatus());
        result = mn;
        minTimes=0;
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };
    Order[] mn1 = OrderFactory.showbystatus("Processing");
    assertNotEquals(100, mn1.length);
  }

  @Test
  public final void testbyorderid(@Mocked final OrderDAO dao) {
    final Order o3 = new Order(2,101,1,1,10,"2021/02/28",500,15240,"processing","fast");
    new Expectations() {
      {
        dao.showByOId(o3.getOrderId());
        minTimes=0;
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };
    Order mn2 = OrderFactory.showOById(2);
    assertEquals(2,mn2.getOrderId());
  }


  @Test
  public final void testupdatestatus(@Mocked final OrderDAO dao){
    final Order o = new Order(1,101,1,1,10,"2021/02/28",500,15240,"Declined","fast");
    new Expectations(){

      {
        dao.updateO(o.getOrderId(),o.getStatus());
        result=1;
        minTimes=0;
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };

    int n=OrderFactory.updateStatus(o.getOrderId(),o.getStatus());
    assertEquals(1,n);

  }
  @Test
  public final void testbybill(@Mocked final OrderDAO dao) {
    final Bill b = new Bill(1,103,"Pizza","aqw",760,12,100,2);
    final ArrayList<Bill> mn = new ArrayList<Bill>();
    mn.add(b);
    new Expectations() {
      {
        dao.showCart();
        result = mn;
        minTimes=0;
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };
    Bill[] mn1 = OrderFactory.showOrders();
    assertNotEquals(0,mn1.length);
  }


  @Test
 public void testshowAllOrdersOfCust()
 {
   Order[]  o =OrderFactory.showAllOrders(1);
   assertNotEquals(0,o.length);
 }

 @Test
 public void testshowAllOrdersOfVendor()
 {
   Order[]  o1 =OrderFactory.showAllVOrders(1);
   assertNotEquals(0,o1.length);
 }

}