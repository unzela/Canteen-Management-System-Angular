package com.hexaware.MLP319.model;


import com.hexaware.MLP319.factory.CouponFactory;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.Before;

public class CouponTest {

    @Before
    public void initInput(){
    }

@Test
public final void testConstructor(){
 final CouponFactory exp = new CouponFactory();
 assertNotEquals(exp,null);
}





@Test
public final void testviewVendor() {
    int c = CouponFactory.showcount(1,1);
    assertEquals(0,c);
}






@Test
public final void testcreatecoupon() {
    int c = CouponFactory.addingcoupon(new Date(),3,1);
    assertEquals(1,c);
}





}