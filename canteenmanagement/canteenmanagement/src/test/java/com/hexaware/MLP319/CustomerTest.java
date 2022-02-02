package com.hexaware.MLP319.model;

import com.hexaware.MLP319.model.Customer;
import com.hexaware.MLP319.factory.CustomerFactory;
import com.hexaware.MLP319.persistence.CustomerDAO;
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

public class CustomerTest {

    @Before
    public void initInput(){

    }
    @Test
    public final void testCustomer(){
        Customer c = new Customer();
        Customer c1 = new Customer(2);
        assertNotEquals(c1, null);
        assertEquals(c1.getCustomerId(),new Customer(2).getCustomerId());
        assertEquals(c1.hashCode(), new Customer(2).hashCode());
    }


    @Test
  public final void testListAllEmpty(@Mocked final CustomerDAO dao) {
    new Expectations() {
      {
        dao.showCustomers(); result = new ArrayList<Customer>();
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };
    Customer[] me = CustomerFactory.show();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final CustomerDAO dao) {
    final Customer m100 = new Customer(100);
    final Customer m101 = new Customer(101);
    final ArrayList<Customer> mn = new ArrayList<Customer>();
    new Expectations() {
      {
        mn.add(m100);
        mn.add(m101);
        dao.showCustomers(); result = mn;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };
    Customer[] mn1 = CustomerFactory.show();
    assertEquals(2, mn1.length);

  }


  @Test
  public final void testCustomercons() {
    final Customer m = new Customer(3,"lakshmoji","lakshmoji@gmail.com","25/13/19","7397361485","lakshman","Rupay",1000);
    assertEquals(3, m.getCustomerId());
    assertEquals("lakshmoji@gmail.com",m.getCustomerEmail());
    assertEquals("25/13/19",m.getCustomerAddress());
    assertEquals("7397361485",m.getCustomerMobile());
    assertEquals("lakshman",m.getCustomerPassword());
    assertEquals("Rupay",m.getWalletName());
    //assertEquals(1000,m.getWalletAmount());
    m.setCustomerId(2);
    m.setCustomerName("ramoji");
    m.setCustomerEmail("ramoji@gmail.com");
    m.setCustomerAddress("hyderabad");
    m.setCustomerPassword("ramana");
    m.setWalletAmount(10000);
    m.setCustomerMobile("6281475925");
    assertEquals(2,m.getCustomerId());
    assertEquals("ramoji",m.getCustomerName());
    assertEquals("6281475925",m.getCustomerMobile());
    assertEquals("ramoji@gmail.com",m.getCustomerEmail());
    assertEquals("hyderabad",m.getCustomerAddress());
    assertEquals("ramana",m.getCustomerPassword());

  }




  @Test

  public final void testcreateCustomerId(@Mocked final CustomerDAO dao)

  {
    final Customer m = new Customer(5553,"lakshmoji","lakshmoji@gmail.com","25/13/19","7397361485","lakshman","Rupay",1000);
    new Expectations(){

      {
       result=dao.createCustomerId(m.getCustomerId(),m.getCustomerName(),m.getCustomerEmail(),m.getCustomerAddress(),m.getCustomerMobile(),m.getCustomerPassword(),m.getWalletName(),m.getWalletAmount());
        result=1;
        minTimes=0;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };

    int n=CustomerFactory.addingcustomer(m.getCustomerId(),m.getCustomerName(),m.getCustomerEmail(),m.getCustomerAddress(),m.getCustomerMobile(),m.getCustomerPassword(),m.getWalletName(),m.getWalletAmount());
    assertEquals(1,n);

  }

  @Test
  public final void testupdateWA(@Mocked final CustomerDAO dao){
    final Customer m1 = new Customer(3,"lakshmoji","lakshmoji@gmail.com","25/13/19","7397361485","lakshman","Rupay",500);
    new Expectations(){

      {
        dao.updateWA(m1.getCustomerId(),m1.getWalletAmount());
        result=1;
        minTimes=0;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };

    int n1=CustomerFactory.addingwallet(m1.getCustomerId(),m1.getWalletAmount());
    assertEquals(1,n1);

  }

  @Test
  public final void testupdatewalletName(@Mocked final CustomerDAO dao){
    final Customer c3 = new Customer(3,"lakshmoji","lakshmoji@gmail.com","25/13/19","7397361485","lakshman","Visa",1000);
    new Expectations(){

      {
        dao.updatewalletName(c3.getCustomerId(),c3.getWalletName());
        result=1;
        minTimes=0;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };

    int n3=CustomerFactory.updatingwalletname(c3.getCustomerId(),c3.getWalletName());
    assertEquals(1,n3);

  }

  @Test
  public final void testupdateMO(@Mocked final CustomerDAO dao){
    final Customer c5 = new Customer(3,"lakshmoji","lakshmoji@gmail.com","25/13/19","7397","lakshman","Rupay",1000);
    new Expectations(){

      {
        dao.updateMO(c5.getCustomerId(),c5.getCustomerMobile());
        result=1;
        minTimes=0;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };

    int n4=CustomerFactory.updatingnumber(c5.getCustomerId(),c5.getCustomerMobile());
    assertEquals(1,n4);

  }
  @Test
public final void testupdateaddress(@Mocked final CustomerDAO dao){
  final Customer c4 = new Customer(3,"lakshmoji","lakshmoji@gmail.com","yderabad","7397361485","lakshman","Rupay",1000);
  new Expectations(){

    {
      dao.updateAD(c4.getCustomerId(),c4.getCustomerAddress());
      result=1;
      minTimes=0;
    }
  };
  new MockUp<CustomerFactory>() {
    @Mock
    CustomerDAO dao() {
      return dao;
    }
  };

  int n5=CustomerFactory.updatingaddress(c4.getCustomerId(),c4.getCustomerAddress());
  assertEquals(1,n5);


}
@Test
public final void testupdateEmail(@Mocked final CustomerDAO dao){
  final Customer c6 = new Customer(3,"lakshmoji","lakshman@gmail.com","25/13/19","7397361485","lakshman","Rupay",1000);
  new Expectations(){

    {
      dao.updateEmail(c6.getCustomerId(),c6.getCustomerEmail());
      result=1;
      minTimes=0;
    }
  };
  new MockUp<CustomerFactory>() {
    @Mock
    CustomerDAO dao() {
      return dao;
    }
  };

  int n6=CustomerFactory.updatingemail(c6.getCustomerId(),c6.getCustomerEmail());
  assertEquals(1,n6);


}

@Test
public final void testupdatePA(@Mocked final CustomerDAO dao){
  final Customer c7 = new Customer(3,"lakshmoji","lakshmoji@gmail.com","25/13/19","7397361485","lakshmoji","Rupay",1000);
  new Expectations(){

    {
      dao.updatePA(c7.getCustomerId(),c7.getCustomerPassword());
      result=1;
      minTimes=0;
    }
  };
  new MockUp<CustomerFactory>() {
    @Mock
    CustomerDAO dao() {
      return dao;
    }
  };

  int n7=CustomerFactory.updatingpassword(c7.getCustomerId(),c7.getCustomerPassword());
  assertEquals(1,n7);
}

@Test
public final void testupdateNA(@Mocked final CustomerDAO dao){
  final Customer c8 = new Customer(3,"lakshmoji","lakshmoji@gmail.com","25/13/19","7397361485","lakshman","Rupay",1000);
  new Expectations(){

    {
      dao.updateNA(c8.getCustomerId(),c8.getCustomerName());
      result=1;
      minTimes=0;
    }
  };
  new MockUp<CustomerDAO>() {
    @Mock
    CustomerDAO dao() {
      return dao;
    }
  };

  int n8=CustomerFactory.updatingname(c8.getCustomerId(),c8.getCustomerName());
  assertEquals(1,n8);


}

@Test
public void testdeletecustomer()
{
  int result=CustomerFactory.deleting(132015);
  assertEquals(0,result);
}


@Test
public final void testViewAllCustomersforequals(@Mocked final CustomerDAO dao) {
    final Customer v1 = new Customer(3,"lakshmoji","lakshman@gmail.com","25/13/19","7397361485","lakshman","Rupay",1000);
    final Customer v2 = new Customer(3,"lakshmoji","lakshman@gmail.com","25/13/19","7397361485","lakshman","Rupay",1000);
    final List<Customer> exp = new ArrayList<Customer>();
    exp.add(v1);
    exp.add(v2);



new Expectations()
{{
   System.out.println("Mocked full Customer Object");
   dao.showCustomers();
   result = exp;
}};

new MockUp<CustomerFactory>(){
  @Mock
  CustomerDAO dao(){
    System.out.println("Mocked dao for full Customer");
    return dao;
  }
};

Customer[] list = CustomerFactory.show();
List<Customer> act = new ArrayList<Customer>();
for(Customer c:list)
{
  act.add(c);
}
System.out.println("length is"+list.length);

assertEquals(exp,act);

}



@Test
 public final void testupdatecustomer(@Mocked final CustomerDAO dao){
   final Customer m2 = new Customer(1,"Chinnu","lakshmoji@gmail.com","25/13/19","7397361485","lakshman","Rupay",1000);
   new Expectations(){

     {
       dao.update(m2);
       result=1;
       minTimes = 0;
     }
   };
   new MockUp<CustomerFactory>() {
     @Mock
     CustomerDAO dao() {
       return dao;
     }
   };

   int n1=CustomerFactory.updatecustomerdetails(m2);
   assertEquals(1,n1);

 }

}