import { Component, OnInit } from '@angular/core';
import { Menu } from '../shared/menu';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';
import {SessionStorageService} from 'angular-web-storage';
import {Currentuser} from '../shared/currentuser';
import {LocationService} from '../location.service';
import {Location} from '../location';
import { Observable } from 'rxjs';
import { AddStockService } from '../add-stock.service';
import { AddTransactionService } from '../add-transaction.service';
import { CurrentTransactions } from '../shared/current-transactions';
import { AddTAIService } from '../add-tai.service';
import { Taiid } from '../shared/taiid';
import { Tai } from '../shared/tai';
import { reject } from 'q';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  public orderup: Map<Menu, number>;
  public storeduser: Currentuser;
  public areas: Location[];
  public bPayment: string;
  public newStock: CurrentTransactions;
  public tida: Tai;

  constructor(private cart: CartService, public session: SessionStorageService,
              private router: Router, private Locate: LocationService, private createService: AddTransactionService, 
              private createOrders: AddTAIService) {  }

  ngOnInit() {
    this.storeduser = JSON.parse(this.session.get('User'));

    this.Locate.getCustomerLocation(this.storeduser.cust.cid).subscribe(
      (resp: Location[]) => {
        this.areas = resp;
      }
    );

    console.log(this.storeduser);

    this.orderup = this.cart.itemList;

    console.log(this.orderup);
    // this.orderup = JSON.parse(this.session.get('Cart'));
  }

  makeOrder() {

    // First of all, I need to make a transaction
    // console.log( this.storeduser );
    console.log( this.storeduser.cust );
    console.log( this.bPayment );
    console.log( 0 );
    if(this.bPayment == null ){
      window.alert("reeee");
    } else {

       this.createService.create(this.storeduser.cust, this.bPayment, 0).subscribe(
        resp => {
          this.newStock = resp;

          for (const m of this.orderup.keys()) {
            const comkey: Taiid = {mid: m, tid: this.newStock};
            this.createOrders.create(comkey, this.orderup.get(m)).subscribe(
              resp2 => {
                this.tida = resp2;
              }
            );
          }

        }
      );



    }

    // Then I need to log the orders.

  }

  backToHome() {

  }
}
