package com.hexaware.MLP319.model;

import com.hexaware.MLP319.model.Vendor;
import com.hexaware.MLP319.factory.VendorFactory;
import com.hexaware.MLP319.persistence.VendorDAO;
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
public class VendorFactoryTest {

    @Before
    public void initInput(){
    }

@Test
public final void testConstructor(){
 final VendorFactory exp = new VendorFactory();
 assertNotEquals(exp,null);
}




@Test
public final void testViewAllVendors(@Mocked final VendorDAO dao) {
    final Vendor v1 = new Vendor(1,"vendor1","vendor@gmail.com","7397361485","25/13/19","lakshman");
    final Vendor v2 = new Vendor(1,"vendor1","vendor@gmail.com","7397361485","25/13/19","lakshman");
    final List<Vendor> exp = new ArrayList<Vendor>();
    exp.add(v1);
    exp.add(v2);



new Expectations()
{{
   System.out.println("Mocked full Vendor Object");
   dao.show();
   result = exp;
}};

new MockUp<VendorFactory>(){
  @Mock
  VendorDAO dao(){
    System.out.println("Mocked dao for full Vendor");
    return dao;
  }
};

Vendor[] list = VendorFactory.showVendor();
List<Vendor> act = new ArrayList<Vendor>();
for(Vendor c:list)
{
  act.add(c);
}
System.out.println("length is"+list.length);

assertEquals(exp,act);

}


@Test
public final void testviewVendor() {
    Vendor v = VendorFactory.viewvendor(1);
    assertEquals(1,v.getVendorId());
}



@Test
public final void testcheckVendor() {
    Vendor v = VendorFactory.checkVendor("lakshmoji@gmail.com","lakshmoji");
    assertEquals("lakshmoji",v.getVendorPassword());
}


@Test
public final void testcreateVendor() {
    int v = VendorFactory.createVendor(1110,"vendor1","vendor@gmail.com","7397361485","25/13/19","lakshman");
    assertEquals(1,v);
}

@Test
public final void testdeleteVendor() {
    int v = VendorFactory.deleteVendor(4);
    assertEquals(1,v);
}

@Test
  public final void testupdateallvendor()
  {
    Vendor v = new Vendor(3,"UNEZALA","ifsgj","9101","123ua","Pune");
    int res=VendorFactory.updateVendordetails(v);
    assertEquals(1,res);
  }


}