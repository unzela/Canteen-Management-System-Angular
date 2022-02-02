package com.hexaware.MLP319.util;
import java.util.Scanner;
import com.hexaware.MLP319.factory.OrderFactory;
import com.hexaware.MLP319.model.Bill;
import com.hexaware.MLP319.factory.MenuFactory;
import com.hexaware.MLP319.model.Menu;
import com.hexaware.MLP319.factory.CustomerFactory;
import com.hexaware.MLP319.model.Customer;
import com.hexaware.MLP319.model.Order;
import com.hexaware.MLP319.factory.CouponFactory;
import java.util.Date;


public class CliMain {

  static Scanner option = new Scanner(System.in, "UTF-8");
/**
 * mainMenu method  used to display the option we had in the application.
 */
  private static void mainMenu() {
    while (true) {

      System.out.println("Canteen Management System");
      System.out.println("-------------------------");
      System.out.println("      1. Vendor          ");
      System.out.println("      2. Customer        ");
      System.out.println("      3. Exit            ");
      System.out.println("-------------------------");
      System.out.println("enter your choice...");
      int choice1 = option.nextInt();
      switch (choice1) {

        case 1:System.out.println(" vendor main menu ");
               vendorMenuDetails();
               break;
        case 2:System.out.println(" customer main menu");
               customerMenuDetails();
               break;
        case 3:System.exit(0);
               break;
        default:System.out.println("enter either 1 or 2 or 3");
               break;
      }
    }
  }
/**
 *vendorMenuDetails method  process the option selected from main menu.
 */
  private static void vendorMenuDetails() {
    while (true) {
      System.out.println("------------------------");
      System.out.println("    Vendor Main Menu    ");
      System.out.println("------------------------");
      System.out.println("       1. Menu          ");
      System.out.println("       2. Orders        ");
      System.out.println("       3. Customers     ");
      System.out.println("       4. Back          ");
      System.out.println("------------------------");
      System.out.println("enter your choice");
      int choice2 = option.nextInt();
      switch (choice2) {
        case 1:System.out.println("Menu items");
               menuItems();
               break;
        case 2:System.out.println("Orders");
               orderItems();
               break;
        case 3:System.out.println("Customers");
               customerDetails();
               break;
        case 4:CliMain.mainMenu();
               break;
        default:System.out.println("enter valid value");
               break;

      }
    }
  }
  private static void menuItems() {
    while (true) {
      System.out.println("-------------------------");
      System.out.println("    Menu Items           ");
      System.out.println("-------------------------");
      System.out.println("1. Add Items             ");
      System.out.println("2. View Item             ");
      System.out.println("3. View All Items        ");
      System.out.println("4. Update Items          ");
      System.out.println("5. Delete Items          ");
      System.out.println("6. Back                  ");
      System.out.println("-------------------------");
      System.out.println("enter your choice");
      int choice3 = option.nextInt();
      switch (choice3) {
        case 1:System.out.println("Enter food id");
          int foodId = option.nextInt();
               System.out.println("Enter food name");
          String foodName = option.next();
               System.out.println("Enter food quantity");
          int foodQty = option.nextInt();
               System.out.println("Enter food price");
          double foodPrice = option.nextDouble();
               System.out.println("Enter the vendor id");
          int vendorId = option.nextInt();
               MenuFactory.addingitem(foodId, foodName, foodQty, foodPrice, vendorId);
               System.out.println("added");
               break;
        case 2:System.out.println("enter search food id..");
          int foodId1 = option.nextInt();
          Menu menu = MenuFactory.viewingitem(foodId1);
               System.out.println(menu.getFoodId() + " " + menu.getFoodName() + " " + menu.getFoodQty() + " " + menu.getFoodPrice() + " " + menu.getVendorId());
               break;
        case 3:System.out.println("All items displaying...");
          Menu[] menu1 = MenuFactory.showMenu();
               System.out.println("Menu_Id" + "\t" + "Menu_Name" + "\t" + "Menu_Qty" + "\t" + "Menu_Price" + "\t" + "Vendor_Id");
          for (Menu m : menu1) {
            System.out.println(m.getFoodId() + "\t" + m.getFoodName() + "\t\t" + m.getFoodQty() + "\t\t" + m.getFoodPrice() + "\t\t" + m.getVendorId());
          }
                 break;
        case 4:System.out.println("Enter food id which needs to be updated...");
          int fid = option.nextInt();
               System.out.println("-------------UPDATE-------------");
               System.out.println("         1. Food Name           ");
               System.out.println("         2. Food Qty            ");
               System.out.println("         3. Food Price          ");
               System.out.println("--------------------------------");
               System.out.println("enter your choice..");
          int choice13 = option.nextInt();
          switch (choice13) {
                      case 1:System.out.println("enter food name to update..");
                             String name3 = option.next();
                             MenuFactory.updatefname(fid, name3);
                             System.out.println("food name updated");
                             break;
                      case 2:System.out.println("Enter food Qty to update");
                             int fqty = option.nextInt();
                             MenuFactory.updatequantity(fid, fqty);
                             System.out.println("Quantity updated..");
                             break;
                      case 3:System.out.println("Enter food price to update.");
                             int foodPrice1 = option.nextInt();
                             MenuFactory.updateprice(fid, foodPrice1);
                             System.out.println("price updated");
                             break;
                      default:System.out.println("enter valid choice");
                             break;
                     }
                     break;

                      case 5:System.out.println("Enter food id to delete");
                             int foodId2 = option.nextInt();
                             MenuFactory.deletingitem(foodId2);
                             System.out.println("deleted");
                             break;
                      case 6:vendorMenuDetails();
                             break;
                      default:System.out.println("enter valid choice");
                             break;
      }
    }
  }
  private static void orderItems() {
       while (true) {
         System.out.println("--------Orders------------- ");
         System.out.println("     1. Accept Orders       ");
         System.out.println("     2. Decline Orders      ");
         System.out.println("     3. Order status        ");
         System.out.println("     4. Back                ");
         System.out.println("enter your choice");
         int choice4 = option.nextInt();
         switch (choice4) {
           case 1:System.out.println("Unplaced orders are shown here");
                  Order[] order1 = OrderFactory.showbystatus("Processing");
                  System.out.println("OrderId" + " " + "FoodId" + " " + "Status" + " " + "Quantity");
                  for(Order o : order1){
                        System.out.println(o.getOrderId() + "\t" + o.getFoodId() + "\t" + o.getStatus() + "\t" + o.getNoOfItems());
                  }
                  System.out.println("enter order id to accept order...");
                  int orderId2 = option.nextInt();
                  OrderFactory.updateStatus(orderId2, "placed");
                  System.out.println("order accepted");
                  break;
           case 2:System.out.println("declined Orders");
                  System.out.println("Unplaced orders are shown here");
                  Order[] order2 = OrderFactory.showbystatus("Processing");
                  System.out.println("OrderId" + " " + "FoodId" + " " + "Status" + " " + "Quantity");
                  for(Order o : order2) {
                    System.out.println(o.getOrderId() + "\t" + o.getFoodId() + "\t" + o.getStatus() + "\t" + o.getNoOfItems());
                  }
                  System.out.println("enter order id to accept order...");
                  int orderId3 = option.nextInt();
                  OrderFactory.updateStatus(orderId3, "declined");
                  System.out.println("order declined");

                  break;
           case 3:System.out.println("order status");
                  Order[] order3 = OrderFactory.showOrder();
                  System.out.println("OrderId" + " " + "FoodId" + " " + "Status");
                  for (Order o1 : order3) {
                     System.out.println(o1.getOrderId() + "\t" + o1.getFoodId() + "\t" + o1.getStatus());
                  }
                  break;
           case 4:vendorMenuDetails();
                  break;
           default:System.out.println("enter valid value");
                  break;

         }
       }
}
  private static void customerDetails() {
       while (true){
         System.out.println("--------Customers-----------");
         System.out.println("     1. Add customers       ");
         System.out.println("     2. View customers      ");
         System.out.println("     3. View all customers  ");
         System.out.println("     4. Update customers    ");
         System.out.println("     5. Delete customers    ");
         System.out.println("     6. Back                ");
         System.out.println("enter your choice");
         int choice5 = option.nextInt();
         switch (choice5) {
           case 1:System.out.println("Adding customers");
                  System.out.println("enter customer id..");
                  int customerId = option.nextInt();
                  System.out.println("enter customer name..");
                  String customerName = option.next();
                  System.out.println("enter customer email..");
                  String customerEmail = option.next();
                  System.out.println("enter customer address..");
                  String customerAddress = option.next();
                  System.out.println("enter customer mobile..");
                  String customerMobile = option.next();
                  System.out.println("enter customer Password..");
                  String customerPassword = option.next();
                  System.out.println("enter customer wallet name..");
                  String walletName = option.next();
                  System.out.println("enter customer wallet amount..");
                  double walletAmount = option.nextInt();
                  CustomerFactory.addingcustomer(customerId, customerName, customerEmail, customerAddress, customerMobile, customerPassword, walletName, walletAmount);
                  System.out.println("added customers");
                  break;
           case 2:System.out.println("viewing customer");
                  System.out.println("enter customer id..");
                  int customerId1 = option.nextInt();
                  Customer c = CustomerFactory.viewcustomer(customerId1);
                  System.out.println(c.getCustomerId() + " " + c.getCustomerName() + " " + c.getCustomerEmail() + " " + c.getCustomerAddress() + " " + c.getCustomerMobile() + " " + c.getCustomerPassword() + " " + c.getWalletName() + " " + c.getWalletAmount());
                  break;
           case 3:System.out.println("viewing all customers");
                  Customer[] customer1 = CustomerFactory.show();
                  System.out.println("c_Id" + "\t" + "c_Name" + "\t" + "c_email" + "\t" + "c_address" + "\t" + "c_mobile" + "\t" + "c_password" + "\t" + "c_walletname" + "\t" + "c_walletamount");
                  for (Customer c1 : customer1) {
                     System.out.println(c1.getCustomerId() + " " + c1.getCustomerName() + " " + c1.getCustomerEmail() + " " + c1.getCustomerAddress() + " " + c1.getCustomerMobile() + " " + c1.getCustomerPassword() + " " + c1.getWalletName() + " " + c1.getWalletAmount());
                  }
                  break;
           case 4:System.out.println("Updating customer");
                  System.out.println("enter customer id..");
                  int customerId2 = option.nextInt();
                  System.out.println("    1. Name    ");
                  System.out.println("    2. Email   ");
                  System.out.println("    3. Address    ");
                  System.out.println("    4. Mobile    ");
                  System.out.println("    5. Password    ");
                  System.out.println("    6. walletName    ");
                  System.out.println("    7. walletAmount    ");
                  System.out.println("    8. Back         ");
                  System.out.println("enter your choice...");
                  int choice6 = option.nextInt();
                  switch (choice6) {
                         case 1:System.out.println("enter name to update..");
                                String name1 = option.next();
                                CustomerFactory.updatingname(customerId2, name1);
                                System.out.println("name updated");
                                break;
                         case 2:System.out.println("Enter your email");
                                String e = option.next();
                                CustomerFactory.updatingemail(customerId2, e);
                                System.out.println("Updated Email");
                                break;

                         case 3:System.out.println("enter your address");
                                String a = option.next();
                                CustomerFactory.updatingaddress(customerId2, a);
                                System.out.println("Updated Address");
                                break;
                         case 4:System.out.println("enter mobile number");
                                String m = option.next();
                                CustomerFactory.updatingnumber(customerId2, m);
                                System.out.println("Mobile number is updated");
                                break;
                         case 5:System.out.println("enter your password");
                                String pa = option.next();
                                CustomerFactory.updatingpassword(customerId2, pa);
                                System.out.println("Password is updated");
                                break;
                         case 6:System.out.println("enter wallet name to be updated..");
                                String wn = option.next();
                                CustomerFactory.updatingwalletname(customerId2, wn);
                                System.out.println("updated name");
                                break;
                         case 7:System.out.println("enter new walletamount");
                                double walletAmount1 = option.nextInt();
                                CustomerFactory.addingwallet(customerId2, walletAmount1);
                                System.out.println("amount updated");
                                break;
                         case 8:customerDetails();
                                break;
                         default:System.out.println("enter valid choice");
                                break;
                  }

                  break;
           case 5:System.out.println("deleting customer");
                  System.out.println("enter customer id..");
                  int customerId3 = option.nextInt();
                  CustomerFactory.deleting(customerId3);
                  System.out.println("delete succesfully");
                  break;
           case 6:vendorMenuDetails();
                  break;
           default:System.out.println("enter valid value");
                  break;

         }
       }
}

private static void customerMenuDetails() {
       while (true) {
              System.out.println("-----Customer Main Menu------");
              System.out.println("-----------------------------");
              System.out.println("     1. Profile              ");
              System.out.println("     2. food Menu              ");
              System.out.println("     3. Orders              ");
              System.out.println("     4. Back              ");
              System.out.println("enter your chooice...");
              int choice7 = option.nextInt();
              switch (choice7) {
                     case 1:System.out.println("viewing profile");
                            customerProfile();
                            break;
                     case 2:System.out.println("viewing food menu");
                            foodMenu();
                            break;
                     case 3:System.out.println("viewing orders");
                            customersOrders();
                            break;
                     case 4:CliMain.mainMenu();
                            break;
                     default:System.out.println("enter valid choice");
                            break;
              }
       }
}

private static void customerProfile() {
       while (true) {
              System.out.println("----------Profile-----------");
              System.out.println("      1. View Profile       ");
              System.out.println("      2. Edit Profile       ");
              System.out.println("      3. Wallet             ");
              System.out.println("      4. Back               ");
              System.out.println("enter your choice..");
              int choice8 = option.nextInt();
              switch (choice8) {
                     case 1:System.out.println("customer profile");
                            System.out.println("enter customer id..");
                            int customerId4 = option.nextInt();
                            Customer c2 = CustomerFactory.viewcustomer(customerId4);
                            System.out.println(c2.getCustomerId() + " " + c2.getCustomerName() + " " + c2.getCustomerEmail() + " " + c2.getCustomerAddress() + " " + c2.getCustomerMobile() + " " + c2.getCustomerPassword() + " " + c2.getWalletName() + " " + c2.getWalletAmount());
                            break;
                     case 2:System.out.println("editing profile");
                            System.out.println("enter customer id..");
                            int customerId5 = option.nextInt();
                            System.out.println("    1. Name    ");
                            System.out.println("    2. Email   ");
                            System.out.println("    3. Address    ");
                            System.out.println("    4. Mobile    ");
                            System.out.println("    5. Password    ");
                            System.out.println("    6. walletName    ");
                            System.out.println("    7. walletAmount    ");
                            System.out.println("    8. Back         ");
                            System.out.println("enter your choice...");
                            int choice9 = option.nextInt();
                            switch (choice9) {
                            case 1:System.out.println("enter name to update..");
                                String name2 = option.next();
                                CustomerFactory.updatingname(customerId5, name2);
                                System.out.println("name updated");
                                break;
                            case 2 :System.out.println("Enter your email");
                                String e2 = option.next();
                                CustomerFactory.updatingemail(customerId5, e2);
                                System.out.println("Updated Email");
                                break;

                            case 3 : System.out.println("enter your address");
                                String a2 = option.next();
                                CustomerFactory.updatingaddress(customerId5, a2);
                                System.out.println("Updated Address");
                                break;
                            case 4: System.out.println("enter mobile number");
                                String m2 = option.next();
                                CustomerFactory.updatingnumber(customerId5, m2);
                                System.out.println("Mobile number is updated");
                                break;
                            case 5:System.out.println("enter your password");
                                String pa2 = option.next();
                                CustomerFactory.updatingpassword(customerId5, pa2);
                                System.out.println("Password is updated");
                                break;
                            case 6:System.out.println("enter wallet name to be updated..");
                                String wn1 = option.next();
                                CustomerFactory.updatingwalletname(customerId5, wn1);
                                System.out.println("updated name");
                                break;
                         case 7:System.out.println("enter new walletamount");
                                double walletAmount2 = option.nextInt();
                                CustomerFactory.addingwallet(customerId5, walletAmount2);
                                System.out.println("amount updated");
                                break;
                         case 8:customerProfile();
                         default:System.out.println("enter valid choice");
                                break;
                  }
                            break;
                     case 3:System.out.println("wallet details");
                            System.out.println("enter customer id..");
                            int customerId6 = option.nextInt();
                            Customer customer2 = CustomerFactory.viewcustomer(customerId6);
                            System.out.println("wallet name is:" + customer2.getWalletName() + "\t" + "wallet amoount:" + customer2.getWalletAmount());
                            break;
                     case 4:customerMenuDetails();
                            break;
                     default:System.out.println("enter valid choice");
                            break;
              }
       }
}

private static void foodMenu() {
       while (true) {
       System.out.println("------------------------------");
       System.out.println("      FOOD MENU               ");
       System.out.println("------------------------------");
       System.out.println("  1. View Food Item           ");
       System.out.println("  2. View All Food Item       ");
       System.out.println("  3. Order Food               ");
       System.out.println("  4. Back                     ");
       System.out.println("------------------------------");
       System.out.println("enter your choice...");
       int choice10 = option.nextInt();
       switch(choice10) {
              case 1:System.out.println("enter food id..");
                     int foodId3 = option.nextInt();
                     Menu menu1 = MenuFactory.viewingitem(foodId3);
                     System.out.println(menu1.getFoodId() + " " + menu1.getFoodName() + " " + menu1.getFoodQty() + " " + menu1.getFoodPrice() + " " + menu1.getVendorId());
                     break;
              case 2:System.out.println("viewing food items");
                     Menu[] menu2 = MenuFactory.showMenu();
                     System.out.println("Menu_Id" + "\t" + "Menu_Name" + "\t" + "Menu_Qty" + "\t" + "Menu_Price" + "\t" + "Vendor_Id");
                     for (Menu m2 : menu2) {
                     System.out.println(m2.getFoodId() + "\t" + m2.getFoodName() + "\t\t" + m2.getFoodQty() + "\t\t" + m2.getFoodPrice() + "\t\t" + m2.getVendorId());
                     }
                     break;
              case 3:System.out.println("ordering items");
                     System.out.println("enter food id to order...");
                     int foodId4 = option.nextInt();
                     Menu menu3 = MenuFactory.viewingitem(foodId4);
                     System.out.println("your food name is.." + menu3.getFoodName());
                     System.out.println("enter Y to continue or N to go back...");
                     char choice11 = option.next().charAt(0);
                     switch(choice11) {
                            case 'Y':System.out.println("Enter food quantity");
                           int foodQty1 = option.nextInt();
                           System.out.println("Enter you customer id");
                           int customerId7 = option.nextInt();
                           System.out.println("Food Id \tFood Name\tFood Quantity\tFood Price ");
                           double price = foodQty1 * menu3.getFoodPrice();
                           System.out.println(menu3.getFoodId() + "\t" + menu3.getFoodName() + "\t" + foodQty1 + "\t" + price);
                           System.out.println("Enter the below details to continue");
                           String status = "Processing";
                           String comment = "Good";
                           System.out.println("Enter the vendor id");
                           int vendorid1 = option.nextInt();
                           System.out.println("enter the order id");
                           int orderId = option.nextInt();
                            System.out.println("enter the token number");
                           int tokenNumber = option.nextInt();
                           String date1 = "2021/04/07";
                           Order[] o =OrderFactory.showAllOrders(customerId7);

                            if(o.length==0)
                            {
                                   System.out.println("new user");
                                   System.out.println("Hurray you got a discount of 30 rupeees");
                                   price-=30;

                            }


                            int noOfOrders=OrderFactory.showcntbyvendor(customerId7,vendorid1);
                            if(noOfOrders==1)
                            {
                                   System.out.println("You got a coupon of discount 10% on next order");
                                   CouponFactory.addingcoupon( new Date(),customerId7,vendorid1);

                            }

                           OrderFactory.createOrder(orderId, foodId4, vendorid1, customerId7, foodQty1, date1, price, tokenNumber, status, comment);
                           Bill[] billItems = OrderFactory.showOrders();
                           boolean accept = false;

                               System.out.println("-----------------------------------------");
                               System.out.println("               Bill                      ");
                               System.out.println("------------------------------------------");
                               System.out.println("    Food Name            :" + menu3.getFoodName());
                               System.out.println("    Food Qty             :" + foodQty1);
                               System.out.println("    Food Price           :" + price);
                               System.out.println("-------------------------------------------");
                               System.out.println("  Total Amount           :" + price);
                               System.out.println("--------------------------------------------");

                            System.out.println("Order Placed Successfully");





                            System.out.println("Thank you. Visit Once again....");
                            break;

                            case 'N':foodMenu();
                                     break;
                            default:System.out.println("enter valid choice");
                                     break;
                     }
                     break;
              case 4:customerMenuDetails();
                     break;
              default:System.out.println("enter valid choice");
                     break;

       }


     }
}

private static void customersOrders()
{
     while(true)
     {
            System.out.println("----------------------------");
            System.out.println("     Customer Orders         ");
            System.out.println("----------------------------");
            System.out.println("1. Order History");
            System.out.println("2. All orders");
            System.out.println("3. Back");
            int choice12=option.nextInt();
            switch(choice12)
            {
                   case 1:System.out.println(" Details of the order will be displayed here");
                          System.out.println("Enter your order id");
                          int orderId1 = option.nextInt();
                          System.out.println("OrderId\tFoodId\tVendorId\tQuantity\tDate\tPrice");
                          Order o4 = OrderFactory.showOById(orderId1);
                          System.out.println(o4.getOrderId() + "\t" + o4.getFoodId() + "\t" + o4.getVendorId() + "\t" + o4.getNoOfItems() + "\t" + o4.getOrderDateTime() + "\t" + o4.getAmountToBePaid());
                          break;
                   case 2:System.out.println("Customer order history..");
                          System.out.println("enter customerId...");
                          int customerId8 = option.nextInt();
                          Order[] o5 = OrderFactory.showbycusid(customerId8);
                          System.out.println("OrderId\tFoodId\tVendorId\tQuantity\tDate\tPrice");
                          for(Order ord:o5)
                          {
                          System.out.println(ord.getOrderId() + "\t" + ord.getFoodId() + "\t" + ord.getVendorId() + "\t" + ord.getNoOfItems() + "\t" + ord.getOrderDateTime() + "\t" + ord.getAmountToBePaid());
                          }
                          break;
                   case 3:customerMenuDetails();
                          break;
                   default:System.out.println("enter valid choice....");
                          break;


            }
     }
}




  public static void main(final String[] args) {
    mainMenu();
  }
}
