import { Component, OnInit } from '@angular/core';
import { Menu } from '../shared/menu';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';
import {SessionStorageService} from 'angular-web-storage';
import {Currentuser} from '../shared/currentuser';
import {LocationService} from '../location.service';
import {Location} from '../location';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  public orderup: Menu[];
  public storeduser: Currentuser;
  public areas: Location[];

  constructor(private cart: CartService, public session: SessionStorageService,
              private router: Router, private Locate: LocationService ) {  }

  ngOnInit() {
    this.storeduser = JSON.parse(this.session.get('User'));

    this.Locate.getCustomerLocation(this.storeduser.cust.cid).subscribe(
      (resp: Location[]) => {
        this.areas = resp;
      }
    );


    this.cart.displayCart();
    this.orderup = JSON.parse(this.session.get('Cart'));
  }

  makeOrder() {

    // First of all, I need to make a transaction


    // Then I need to log the orders.

  }

  backToHome() {

  }
}
