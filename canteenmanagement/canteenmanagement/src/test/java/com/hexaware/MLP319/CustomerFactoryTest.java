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

@RunWith(JMockit.class)
public class CustomerFactoryTest {

@Before
public void initInput(){


}
/**
 * test for constructor
 */
@Test
public final void testConstructor(){
 final CustomerFactory exp = new CustomerFactory();
 assertNotEquals(exp,null);
}

@Test
public final void testViewAllCustomer(@Mocked final CustomerDAO dao) {
final List<Customer> exp = new ArrayList<Customer>();

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

public final void testcreateCustomerId(@Mocked final CustomerDAO dao)

{
  final Customer m = new Customer(5895,"lakshmoji","lakshmoji@gmail.com","25/13/19","7397361485","lakshman","Rupay",1000);
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
  public void testupdatewamount()
  {
    int result=CustomerFactory.addingwallet(3,1150);
    assertEquals(1,result);
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
  public void testupdatemobilenumber()
  {
    int result=CustomerFactory.updatingnumber(3,"4563258");
    assertEquals(1,result);
  }



  @Test
  public void testupdatepassword()
  {
    int result=CustomerFactory.updatingpassword(3,"458");
    assertEquals(1,result);
  }


  @Test
  public final void testupdateEmail(@Mocked final CustomerDAO dao){
    final Customer c6 = new Customer(3,"lakshmoji","lakshmoji@gmail.com","25/13/19","7397361485","lakshman","Rupay",1000);
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
  public void testdeletecustomer()
  {
    int result=CustomerFactory.deleting(132015);
    assertEquals(0,result);
  }




}