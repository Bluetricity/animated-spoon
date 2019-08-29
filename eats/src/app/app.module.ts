import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { NavBarComponent } from './core/nav-bar/nav-bar.component';
import { StockComponent } from './stock/stock.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavBarComponent,
    StockComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
