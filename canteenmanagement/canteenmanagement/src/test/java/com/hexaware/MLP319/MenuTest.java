package com.hexaware.MLP319.model;
import com.hexaware.MLP319.model.Menu;
import com.hexaware.MLP319.persistence.MenuDAO;
import com.hexaware.MLP319.factory.MenuFactory;
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

/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class MenuTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * Tests the equals/hashcode methods of the Menu class.
   */
  @Test
  public final void testMenu() {
    Menu m = new Menu();
    Menu m100 = new Menu(100);
    Menu m101 = new Menu(101);
    assertNotEquals(m100, null);
    assertNotEquals(m101, null);
    assertEquals(m100.getFoodId(),
        new Menu(100).getFoodId());
    m101.setFoodId(100);
    assertNotEquals(m101, new Menu(101));
    assertEquals(m100.hashCode(),
        new Menu(100).hashCode());
    assertEquals(m100, new Menu(100));
  }
  /**
   * tests that are empty list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final MenuDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Menu>();
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] me = MenuFactory.showMenu();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some menu items is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final MenuDAO dao) {
    final Menu m100 = new Menu(100);
    final Menu m101 = new Menu(101);
    final ArrayList<Menu> mn = new ArrayList<Menu>();
    new Expectations() {
      {
        mn.add(m100);
        mn.add(m101);
        dao.show(); result = mn;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] mn1 = MenuFactory.showMenu();
    assertEquals(2, mn1.length);
    assertEquals(new Menu(100).getFoodId(),
        mn1[0].getFoodId());
    assertEquals(new Menu(101).getFoodId(),
        mn1[1].getFoodId());
  }
  /**
   * testing by junit using asserEquals and notEquals
   */
  @Test
  public final void testMenucons() {
    final Menu m = new Menu(102,  "Tandoori", 35203,100,1);
    assertEquals(102, m.getFoodId());
    assertEquals(35203, m.getFoodQty());
    assertEquals(1, m.getVendorId());
    assertEquals("Tandoori", m.getFoodName());
    //assertEquals(100, m.getFoodPrice());
    m.setFoodName("Tandoori");
    System.out.println(m.getFoodPrice());
    m.setVendorId(1);
    m.setFoodQty(35203);
    m.setVendorId(1);
    assertEquals("Tandoori", m.getFoodName());
    assertEquals(1, m.getVendorId());
    assertEquals(35203, m.getFoodQty());
    assertEquals(1, m.getVendorId());
  }
  /**
   * Test method for creating item.
   */
  @Test
  public final void testcreateMenuItem(@Mocked final MenuDAO dao){
    final Menu m1 = new Menu(108, "poori", 352,120,3);
    new Expectations(){

      {
        dao.createMenuItem(m1.getFoodId(),m1.getFoodName(),m1.getFoodQty(),m1.getFoodPrice(),m1.getVendorId());
        result=1;
        minTimes=0;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };

    int n=MenuFactory.addingitem(m1.getFoodId(),m1.getFoodName(),m1.getFoodQty(),m1.getFoodPrice(),m1.getVendorId());
    assertEquals(1,n);

  }
  /**
   * Test method for finding item by id.
   */

  @Test
  public final void testfindById(@Mocked final MenuDAO dao) {
    new Expectations() {
      {
        dao.findById(101);
        result =1;
        minTimes=0;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    assertEquals("papad",MenuFactory.viewingitem(101).getFoodName());
  }
  /**
   * Test method for deleting item by id.
   */

  @Test
  public final void testdeleteById(@Mocked final MenuDAO dao){
    final Menu m2 = new Menu(104);
    new Expectations(){

      {
        dao.deleteById(m2.getFoodId());
        result=1;
        minTimes=0;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };

    int n1=MenuFactory.deletingitem(m2.getFoodId());
    assertEquals(1,n1);

  }
  /**
   * Test method for updating quantity by id.
   */

  @Test
  public final void testupdateQty(@Mocked final MenuDAO dao){
    final Menu m3 = new Menu(101,200);
    new Expectations(){

      {
        dao.updateQty(m3.getFoodId(),m3.getFoodQty());
        result=1;
        minTimes=0;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };

    int n3=MenuFactory.updatequantity(m3.getFoodId(),m3.getFoodQty());
    assertEquals(1,n3);

  }
  /**
   * Test method for updating food price.
   */

  @Test
  public final void testupdatePrice(@Mocked final MenuDAO dao){
    final Menu m4 = new Menu(101, "Rajma", 110,800,1);
    new Expectations(){

      {
        dao.updatePrice(m4.getFoodId(),m4.getFoodQty());
        result=1;
        minTimes=0;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };

    int n4=MenuFactory.updateprice(m4.getFoodId(),m4.getFoodPrice());
    assertEquals(1,n4);

  }
  /**
   * Test method for updating food Name.
   */

  @Test
  public final void testupdatename(@Mocked final MenuDAO dao){
    final Menu m5 = new Menu(102, "Rajmalaa", 110,800,1);
    new Expectations(){

      {
        dao.updateFName(m5.getFoodId(),m5.getFoodName());
        result=1;
        minTimes=0;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };

    int n5=MenuFactory.updatefname(m5.getFoodId(),m5.getFoodName());
    assertEquals(1,n5);

  }
  @Test
  public final void testUpdateAllMenu()
  {
    Menu m = new Menu(101,"papad",50,50,1);
    int res=MenuFactory.updateMenudetails(m);
    assertEquals(1,res);
  }


}
