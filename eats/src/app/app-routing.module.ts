import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { MenuComponent } from './menu/menu.component';
import { MenuItemsComponent } from './menu-items/menu-items.component';
import { OrderComponent } from './order/order.component';
import { DeliveryStatusComponent } from './delivery-status/delivery-status.component';
import { HomeComponent } from './core/home/home.component';
import { ManagerComponent } from './manager/manager.component';
import { StockComponent } from './stock/stock.component';
import {AccountInfoComponent } from './account-info/account-info.component'
import { NewStockComponent } from './new-stock/new-stock.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'manager',
    component: ManagerComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '',
    redirectTo: '/stock',
    pathMatch: 'full'
  },
  {
    path: 'stock',
    component: StockComponent
  },
  {
    path: 'create-account',
    component: CreateAccountComponent
  },
  {
    path: 'menu',
    component: MenuComponent
    /* add later */
  },
  {
    path: 'menu-items',
    component: MenuItemsComponent
  },
  {
    path: 'order',
    component: OrderComponent
  },
  {
    path: 'delivery-status',
    component: DeliveryStatusComponent
  },
  {
    path: 'account-info',
    component: AccountInfoComponent
  },
  {
    path: 'new-stock',
    component: NewStockComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
