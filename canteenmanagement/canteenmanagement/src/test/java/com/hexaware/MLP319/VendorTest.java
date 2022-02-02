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

public class VendorTest {

    @Before
    public void initInput(){


    }
    @Test
    public final void testVendor(){
        Vendor v = new Vendor();
        Vendor v1 = new Vendor(2);
        assertNotEquals(v1, null);
        assertEquals(v1.getVendorId(),new Vendor(2).getVendorId());
        assertEquals(v1.hashCode(), new Vendor(2).hashCode());
    }



    @Test
    public final void testListAllEmpty(@Mocked final VendorDAO dao) {
      new Expectations() {
        {
          dao.show(); result = new ArrayList<Vendor>();
        }
      };
      new MockUp<VendorFactory>() {
        @Mock
        VendorDAO dao() {
          return dao;
        }
      };
      Vendor[] me = VendorFactory.showVendor();
      assertEquals(0, me.length);
    }



    @Test
    public final void testVendorcons() {
      final Vendor m = new Vendor(1,"vendor1","vendor@gmail.com","7397361485","25/13/19","lakshman");
      assertEquals(1, m.getVendorId());
      assertEquals("vendor1",m.getVendorName());
      assertEquals("vendor@gmail.com",m.getVendorEmail());
      assertEquals("7397361485",m.getvendorContactNo());
      assertEquals("25/13/19",m.getVendorAddress());
      assertEquals("lakshman",m.getVendorPassword());
      m.setVendorId(1);
      m.setVendorEmail("vendor@gmail.com");
      m.setVendorName("vendor1");
      m.setvendorContactNo("9949230495");
      m.setVendorAddress("25/13/19");
      m.setVendorPassword("lakshman");
      assertEquals(1,m.getVendorId());
      assertEquals("vendor1",m.getVendorName());
      assertEquals("vendor@gmail.com",m.getVendorEmail());
      assertEquals("9949230495",m.getvendorContactNo());
      assertEquals("25/13/19",m.getVendorAddress());
      assertEquals("lakshman",m.getVendorPassword());
    }








  @Test
    public final void testcreateVendor(@Mocked final VendorDAO dao){
      final Vendor m = new Vendor(6,"unzela","iunzela@gmail.com","9130621501","Pune","unzela123");
      new Expectations(){

        {
          dao.createVendor(m.getVendorId(), m.getVendorName(), m.getVendorEmail(), m.getvendorContactNo(), m.getVendorAddress(), m.getVendorPassword());
          result=1;
          minTimes = 0;
        }
      };
      new MockUp<VendorFactory>() {
        @Mock
        VendorDAO dao() {
          return dao;
        }
      };

      int n=VendorFactory.createVendor(m.getVendorId(),m.getVendorName(),m.getVendorEmail(),m.getvendorContactNo(),m.getVendorAddress(),m.getVendorPassword());
      assertEquals(1,n);

 }

 @Test
 public final void testupdateVendor(@Mocked final VendorDAO dao){
   final Vendor m2 = new Vendor(3,"UNEZALA","ifsgj","9101","123ua","Pune");
   new Expectations(){

     {
       dao.updateVendor(m2);
       result=1;
       minTimes = 0;
     }
   };
   new MockUp<VendorFactory>() {
     @Mock
     VendorDAO dao() {
       return dao;
     }
   };

   int n1=VendorFactory.updateVendordetails(m2);
   assertEquals(1,n1);

 }

  @Test
  public final void testdeleteById(@Mocked final VendorDAO dao) {
    final Vendor v2 = new Vendor(10);
    new Expectations() {
      {
        dao.deleteById(10);
        result =1;
        minTimes = 0;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };
    int n2=VendorFactory.deleteVendor(v2.getVendorId());
    assertEquals(0,n2);
  }

  @Test
  public final void testfindByVId(@Mocked final VendorDAO dao) {
    new Expectations() {
      {
        dao.findByVId(1);
        result =1;
        minTimes=0;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };
    assertEquals("Guru",VendorFactory.viewvendor(1).getVendorName());
  }

  @Test
  public final void testcheckvendor(@Mocked final VendorDAO dao) {
    final Vendor v3 = new Vendor(1,"Guru","Guru@gmail.com","9182173734","Kadapa","Guru");
    new Expectations() {
      {
        dao.displays(v3.getVendorEmail(),v3.getVendorPassword());
        minTimes=0;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };

    Vendor n3=VendorFactory.checkVendor(v3.getVendorEmail(),v3.getVendorPassword());
    assertEquals("Guru@gmail.com",n3.getVendorEmail());
  }


}