import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { AcceptorderComponent } from './acceptorder/acceptorder.component';
import { AppComponent } from './app.component';
import { BillComponent } from './bill/bill.component';
import { CloginComponent } from './clogin/clogin.component';
import { ContactComponent } from './contact/contact.component';
import { CplacedordersComponent } from './cplacedorders/cplacedorders.component';
import { CreateMenuComponent } from './create-menu/create-menu.component';
import { CustomerComponent } from './customer/customer.component';
import { CustomerdetailsComponent } from './customerdetails/customerdetails.component';
import { CustomerordersComponent } from './customerorders/customerorders.component';
import { FavComponent } from './fav/fav.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

import { MenuDetailsComponent } from './menu-details/menu-details.component';
import { MenuListComponent } from './menu-list/menu-list.component';
import { OrderComponent } from './order/order.component';
import { OrdersummaryComponent } from './ordersummary/ordersummary.component';
import { RatingComponent } from './rating/rating.component';
import { ServicesComponent } from './services/services.component';
import { UpdateMenuComponent } from './update-menu/update-menu.component';
import { VendorComponent } from './vendor/vendor.component';
import { VendormenuComponent } from './vendormenu/vendormenu.component';
import { VendororderComponent } from './vendororder/vendororder.component';
import { VloginComponent } from './vlogin/vlogin.component';

const routes: Routes = [

  {path:'create',component:CreateMenuComponent},
  {path:'',component:HomeComponent},
  {path:'update/:id',component:UpdateMenuComponent},
  {path:'details/:id',component:MenuDetailsComponent},
  {path:'order/:id',component:OrderComponent},
  {path:'login', component:LoginComponent},
  {path:'vlogin',component:VloginComponent},
  {path:'services',component:ServicesComponent},
  {path:'about', component:AboutComponent},
  {path:'vendor',component:VendorComponent},
  {path:'contact', component:ContactComponent},
  {path:'menu', component:MenuListComponent},
  {path:'clogin',component:CloginComponent},
  {path:'customer', component:CustomerComponent},
  {path:'accept',component:AcceptorderComponent},
  {path:'vendorlogin',component:VendormenuComponent},
  {path:'billing',component:BillComponent},
  {path:'customerorders',component:CustomerordersComponent},
  {path:'profile',component:CustomerdetailsComponent},
  {path:'cplacedorders',component:CplacedordersComponent},
  {path:'summary',component:OrdersummaryComponent},
  {path:'rating',component:RatingComponent},
  {path:'fav',component:FavComponent},

  {path:'vendorordering',component:VendororderComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
