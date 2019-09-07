import { Injectable } from '@angular/core';
import { UrlService } from './shared/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MenuServiceService } from './menu-service.service';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Menu } from './shared/menu';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  // private appUrl = this.caUrl.getUrl() + '/menu/';
  // private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  public itemList = new Map();

  constructor() {

  }

  addtoCart(menin: Menu) {
    if (this.itemList.has(menin)) {
      this.itemList.set(menin, this.itemList.get(menin) + 1);
    } else {
      this.itemList.set(menin, 1);
    }
  }

  removefromCart() {

  }

  displayCart() {
    console.log(this.itemList);
  }

  sendCart(): Map<Menu, number> {
    return this.itemList;
  }
}
