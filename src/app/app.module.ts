import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { NgxPaginationModule } from 'ngx-pagination';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateMenuComponent } from './create-menu/create-menu.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UpdateMenuComponent } from './update-menu/update-menu.component';
import { MenuDetailsComponent } from './menu-details/menu-details.component';
import { OrderComponent } from './order/order.component';
import { MenuListComponent } from './menu-list/menu-list.component';
import { NavComponent } from './nav/nav.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { VloginComponent } from './vlogin/vlogin.component';
import { VendorComponent } from './vendor/vendor.component';
import { CustomerComponent } from './customer/customer.component';
import { CloginComponent } from './clogin/clogin.component';
import { VendororderComponent } from './vendororder/vendororder.component';
import { AcceptorderComponent } from './acceptorder/acceptorder.component';
import { VendormenuComponent } from './vendormenu/vendormenu.component';
import { BillComponent } from './bill/bill.component';
import { ServicesComponent } from './services/services.component';
import { CustomerordersComponent } from './customerorders/customerorders.component';
import { VenNavComponent } from './ven-nav/ven-nav.component';
import { CustomerdetailsComponent } from './customerdetails/customerdetails.component';
import { CouponsComponent } from './coupons/coupons.component';
import { NavProfileComponent } from './nav-profile/nav-profile.component';
import { CplacedordersComponent } from './cplacedorders/cplacedorders.component';
import { OrdersummaryComponent } from './ordersummary/ordersummary.component';
import { Ng2SearchPipeModule} from 'ng2-search-filter';
import { DropdownComponent } from './dropdown/dropdown.component';
import { MenuNavComponent } from './menu-nav/menu-nav.component';
import { RatingComponent } from './rating/rating.component';
import { FavComponent } from './fav/fav.component';


@NgModule({
  declarations: [
    AppComponent,
    CreateMenuComponent,
    UpdateMenuComponent,
    MenuDetailsComponent,
    OrderComponent,
    MenuListComponent,
    NavComponent,
    AboutComponent,
    ContactComponent,
    LoginComponent,
    HomeComponent,
    VloginComponent,
    VendorComponent,
    CustomerComponent,
    CloginComponent,
    VendororderComponent,
    AcceptorderComponent,
    VendormenuComponent,
    BillComponent,
    ServicesComponent,
    CustomerordersComponent,
    VenNavComponent,
    CustomerdetailsComponent,
    CouponsComponent,
    NavProfileComponent,
    CplacedordersComponent,
    OrdersummaryComponent,
    DropdownComponent,
    MenuNavComponent,
    RatingComponent,
    FavComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    Ng2SearchPipeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
