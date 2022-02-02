package com.hexaware.MLP319.model;
import com.hexaware.MLP319.model.Menu;
import com.hexaware.MLP319.persistence.MenuDAO;
import com.hexaware.MLP319.factory.MenuFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

//import jdk.jfr.Timestamp;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;
import java.util.List;



/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class MenuFactoryTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {

  }


  /**
 * test for constructor
 */
@Test
public final void testConstructor(){
 final MenuFactory exp = new MenuFactory();
 assertNotEquals(exp,null);
}



@Test
public final void testViewAllMenu(@Mocked final MenuDAO dao) {
final List<Menu> exp = new ArrayList<Menu>();

new Expectations()
{{
   System.out.println("Mocked full Menu Object");
   dao.show();
   //result = exp;
}};

new MockUp<MenuFactory>(){
  @Mock
  MenuDAO dao(){
    System.out.println("Mocked dao for full Menu");
    return dao;
  }
};

Menu[] list = MenuFactory.showMenu();
List<Menu> act = new ArrayList<Menu>();
for(Menu c:list)
{
  act.add(c);
}
System.out.println("length is"+list.length);

assertEquals(exp,act);

}

@Test
public void testviewitem(@Mocked final MenuDAO dao){
Menu menu = new Menu(101, "poori", 352,120,3);
new Expectations()
{{
   System.out.println("Mocked full Menu Object");
   dao.findById(101);
   minTimes=0;
}};
new MockUp<MenuFactory>(){
  @Mock
  MenuDAO dao(){
    System.out.println("Mocked dao for full Menu");
    return dao;
  }
};
Menu menu1 = MenuFactory.viewingitem(101);
assertEquals(menu.getFoodId(),menu1.getFoodId());

}

@Test
public void testDeleteitem(){
  System.out.println("Delete item");
  int result = MenuFactory.deletingitem(105);
  assertEquals(1,result);
}
@Test
public void testupdatequantity(){
  int result = MenuFactory.updatequantity(101,250);
  assertEquals(1,result);
}

@Test
public void testupdateprice(){
  int result = MenuFactory.updateprice(101,1250);
  assertEquals(1,result);
}
@Test
public void testupdatefname(){
  int result = MenuFactory.updatefname(101,"idly");
  assertEquals(1,result);
}

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
  @Test
  public final void testUpdateAllMenu()
  {
    Menu m = new Menu(101,"papad",50,50,1);
    int res=MenuFactory.updateMenudetails(m);
    assertEquals(1,res);
  }



}
