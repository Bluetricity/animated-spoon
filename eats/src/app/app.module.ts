import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { NavBarComponent } from './core/nav-bar/nav-bar.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { MenuComponent } from './menu/menu.component';
import { MenuItemsComponent } from './menu-items/menu-items.component';
import { OrderComponent } from './order/order.component';
import { DeliveryStatusComponent } from './delivery-status/delivery-status.component';
import { UrlService } from './shared/url.service';
import { UserService } from './shared/user.service';
import { HttpClientModule } from '@angular/common/http';
import { ManagerComponent } from './manager/manager.component';
import { HomeComponent } from './core/home/home.component';
import { AccountInfoComponent } from './account-info/account-info.component';
import { StockComponent } from './stock/stock.component';
import { InventoryComponent } from './inventory/inventory.component';
import { NewStockComponent } from './new-stock/new-stock.component';
import { NewMenuComponent } from './new-menu/new-menu.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavBarComponent,
    CreateAccountComponent,
    MenuComponent,
    MenuItemsComponent,
    OrderComponent,
    DeliveryStatusComponent,
    ManagerComponent,
    HomeComponent,
    AccountInfoComponent,
    StockComponent,
    InventoryComponent,
    NewStockComponent,
    NewMenuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    UrlService,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
