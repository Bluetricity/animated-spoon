import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { EmployeeMenuComponent } from './employee-menu-items/employee-menu-items.component';
import { MenuItemsComponent } from './menu-items/menu-items.component';
import { OrderComponent } from './order/order.component';
import { DeliveryStatusComponent } from './delivery-status/delivery-status.component';
import { HomeComponent } from './core/home/home.component';
import { ManagerComponent } from './manager/manager.component';
import { StockComponent } from './stock/stock.component';
import {AccountInfoComponent } from './account-info/account-info.component';
import { NewStockComponent } from './new-stock/new-stock.component';
import { NewMenuComponent } from './new-menu/new-menu.component';
import { EditMenuComponent } from './edit-menu/edit-menu.component';
import { PendingTransactionsComponent } from './pending-transactions/pending-transactions.component';
import { MenuTypesComponent } from './menu-types/menu-types.component';
import { NewMenuTypeComponent } from './new-menu-type/new-menu-type.component';
import { MenuChoiceComponent} from './menu-choice/menu-choice.component';

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
    path: 'employee-menu-items',
    component: EmployeeMenuComponent
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
    path: 'edit-menu',
    component: EditMenuComponent
  },
  {
    path: 'new-stock',
    component: NewStockComponent
  },
  {
    path: 'new-menu',
    component: NewMenuComponent
  },
  {
    path: 'pending-orders',
    component: PendingTransactionsComponent
  },
  {
    path: 'menu-types',
    component: MenuTypesComponent
  },
  {
    path: 'new-menu-type',
    component: NewMenuTypeComponent
  },
  {
    path: 'menu-choice',
    component: MenuChoiceComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
