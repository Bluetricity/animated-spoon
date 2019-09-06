import { Component, OnInit } from '@angular/core';
import { Menu } from '../shared/menu';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { MenuServiceService } from '../menu-service.service';
import { CartService } from '../cart.service';
import {SessionStorageService} from 'angular-web-storage';

@Component({
  selector: 'app-menu-items',
  templateUrl: './menu-items.component.html',
  styleUrls: ['./menu-items.component.css']
})
export class MenuItemsComponent implements OnInit {

  poptable: Observable<any[]>;
  columns: string[];
  test: string[];

  public mealname: string;
  public desc: string;
  public price: number;
  public getMenu: Menu;
  public currMenu: Menu[];
  createService: any;
  
  constructor(private cart: CartService, private menu: MenuServiceService, public session: SessionStorageService, private router: Router) { }

  ngOnInit() {
    this.menu.getMenuCust().subscribe((data: Menu[]) => {
     
      this.currMenu = data;
      this.currMenu.sort(function(a,b) {return a.mid - b.mid});
    });

    console.log(this.currMenu);
    

  }

  addtoCart($event:any){
    let mid: number = $event.target.value;
    console.log(mid);
    let ann: Menu = this.currMenu[mid-1];
    
    console.log(ann);
    
    this.cart.addtoCart(ann);

    this.cart.displayCart();
  }

  toOrder(){
    let OrderUp = this.cart.sendCart();
    console.log(OrderUp);
    const StringCart = JSON.stringify(OrderUp);
    this.session.set('Cart',StringCart);

    console.log(this.session.get('Cart'));


    this.router.navigate(['order']);
  }
}
