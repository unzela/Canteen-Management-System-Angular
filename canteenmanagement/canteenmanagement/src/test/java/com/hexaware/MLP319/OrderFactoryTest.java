package com.hexaware.MLP319.model;

import com.hexaware.MLP319.model.Order;
import com.hexaware.MLP319.factory.OrderFactory;
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
import java.util.List;

public class OrderFactoryTest {

    @Before
    public void initInput(){
    }
@Test
public final void testConstructor(){
 final OrderFactory exp = new OrderFactory();
 assertNotEquals(exp,null);
}

@Test
public final void testViewAllOrder(@Mocked final OrderDAO dao) {
final List<Order> exp = new ArrayList<Order>();

new Expectations()
{{
   System.out.println("Mocked full Order Object");
   dao.show();
   //result = exp;
}};

new MockUp<OrderFactory>(){
  @Mock
  OrderDAO dao(){
    System.out.println("Mocked dao for full Order");
    return dao;
  }
};

Order[] list = OrderFactory.showOrder();
List<Order> act = new ArrayList<Order>();
for(Order c:list)
{
  act.add(c);
}
System.out.println("length is"+list.length);

assertEquals(exp,act);

}

@Test
  public final void testcreateOrderItem(@Mocked final OrderDAO dao){
    final Order o = new Order(566,101,1,1,10,"2021/02/28",500,15240,"processing","fast");
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

  @Test
  public final void testshowByOId(@Mocked final OrderDAO dao) {
    final Order o2 = new Order(2);
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
    assertNotEquals(0,OrderFactory.showOById(1).getFoodId());
  }

  @Test
  public final void testbycusid(@Mocked final OrderDAO dao) {
    final Order o3 = new Order(1,101,1,1,10,"2021/02/28",500,15240,"processing","fast");
    final ArrayList<Order> mn1 = new ArrayList<Order>();
    new Expectations() {
      {
        dao.showById(o3.getCustomerId());
        result = mn1;
        minTimes=0;
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };
    Order[] mn2 = OrderFactory.showbycusid(1);
    assertNotEquals(0, mn2.length);
  }


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

  // @Test
  // public final void testbyvid(@Mocked final OrderDAO dao) {
  //   final Order o4 = new Order(1,101,1,1,10,"2021/02/28",500,15240,"processing","fast");
  //   final ArrayList<Order> mn2 = new ArrayList<Order>();
  //   new Expectations() {
  //     {
  //       dao.showByVId(o4.getVendorId());
  //       result = mn2;
  //       minTimes=0;
  //     }
  //   };
  //   new MockUp<OrderFactory>() {
  //     @Mock
  //     OrderDAO dao() {
  //       return dao;
  //     }
  //   };
  //   Order[] mn3 = OrderFactory.showAllVOrders(1);
  //   assertNotEquals(7, mn3.length);
  // }

  @Test
  public final void testupdatestatus(@Mocked final OrderDAO dao){
    final Order o = new Order(4,101,1,1,10,"2021/02/28",500,15240,"Declined","fast");
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
    assertNotEquals(1,n);

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
    assertEquals(1,mn1.length);
  }


  // @Test
  // public final void testbycuid(@Mocked final OrderDAO dao) {
  //   final Order o4 = new Order(1,101,1,1,10,"2021/02/28",500,15240,"processing","fast");
  //   final ArrayList<Order> mn2 = new ArrayList<Order>();
  //   new Expectations() {
  //     {
  //       dao.showById(o4.getCustomerId());
  //       result = mn2;
  //       minTimes=0;
  //     }
  //   };
  //   new MockUp<OrderFactory>() {
  //     @Mock
  //     OrderDAO dao() {
  //       return dao;
  //     }
  //   };
  //   Order[] mn3 = OrderFactory.showAllOrders(1);
  //   System.out.println(mn3.length);
  //   assertNotEquals(6, mn3.length);
  // }

  @Test
  public void testshowAllOrdersOfCust()
  {
    Order[]  o =OrderFactory.showAllOrders(2);
    System.out.println(o.length);
    assertNotEquals(0,o.length);
  }

  @Test
  public void testshowAllOrdersOfVendor()
  {
    Order[]  o1 =OrderFactory.showAllVOrders(1);
    System.out.println(o1.length);
    assertNotEquals(0,o1.length);
  }


  @Test
public final void testViewAllOrders(@Mocked final OrderDAO dao) {
    final Order v1 = new Order(4,101,1,1,10,"2021/02/28",500,15240,"Declined","fast");
    final Order v2 = new Order(4,101,1,1,10,"2021/02/28",500,15240,"Declined","fast");
    final List<Order> exp = new ArrayList<Order>();
    exp.add(v1);
    exp.add(v2);



new Expectations()
{{
   System.out.println("Mocked full Order Object");
   dao.show();
   result = exp;
}};

new MockUp<OrderFactory>(){
  @Mock
  OrderDAO dao(){
    System.out.println("Mocked dao for full Order");
    return dao;
  }
};

Order[] list = OrderFactory.showOrder();
List<Order> act = new ArrayList<Order>();
for(Order c:list)
{
  act.add(c);
}
System.out.println("length is"+list.length);

assertEquals(exp,act);

}



}