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
  public itemList: Menu[] = [];

  constructor() {  
    
  }

  addtoCart(menin: Menu){
    this.itemList.push(menin);
  }

  removefromCart(){

  }

  displayCart(){
    console.log(this.itemList);
  }
    // getCustMenu(): Observable<Menu[]>{
    //   return this.http.get(this.appUrl, {withCredentials: true}).pipe(
    //     map( resp => resp as Menu[])
    //   );
    // } 
 
}
