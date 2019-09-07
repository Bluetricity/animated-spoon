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

  constructor(private cart: CartService, private menu: MenuServiceService, public session: SessionStorageService,
              private router: Router) { }

  ngOnInit() {
    console.log(JSON.parse(this.session.get('Choice')));
    const mtid = JSON.parse(this.session.get('Choice'));
    this.menu.getMenuCust(mtid).subscribe((data: Menu[]) => {

      this.currMenu = data;
      this.currMenu.sort( (a, b) => a.mid - b.mid);
    });

    console.log(this.currMenu);


  }

  addtoCart($event: any ) {
    const mid: number = $event.target.value;
    console.log(mid);
    const ann: Menu = this.currMenu[mid - 1];

    console.log(ann);

    this.cart.addtoCart(ann);

    this.cart.displayCart();
  }

  toOrder() {
    const OrderUp = this.cart.sendCart();
    console.log(OrderUp);
    const StringCart = JSON.stringify(OrderUp);
    this.session.set('Cart', StringCart);

    console.log(this.session.get('Cart'));


    this.router.navigate(['order']);
  }
}
