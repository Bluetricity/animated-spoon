import { Component, OnInit } from '@angular/core';
import { Menu } from '../shared/menu';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { MenuServiceService } from '../menu-service.service';
import { CartService } from '../cart.service';
import {SessionStorageService} from 'angular-web-storage';
import { AddSAMService } from '../add-sam.service';
import { SAM } from '../shared/sam';

@Component({
  selector: 'app-menu-items',
  templateUrl: './menu-items.component.html',
  styleUrls: ['./menu-items.component.css']
})
export class MenuItemsComponent implements OnInit {

  poptable: Observable<any[]>;
  columns: string[];
  test: string[];
  count: number=0;

  public mealname: string;
  public desc: string;
  public price: number;
  public getMenu: Menu;
  public currMenu: Menu[];
  public ings: SAM[];
  public ingCounter: Map<SAM, number> = new Map();
  createService: any;

  constructor(private cart: CartService, private menu: MenuServiceService, public session: SessionStorageService,
              private router: Router, private stock: AddSAMService) { }

  ngOnInit() {
    console.log(JSON.parse(this.session.get('Choice')));
    const mtid = JSON.parse(this.session.get('Choice'));
    this.menu.getMenuCust(mtid).subscribe((data: Menu[]) => {

      this.currMenu = data;
      this.currMenu.sort( (a, b) => a.mid - b.mid);

      this.stock.getCurrentInv().subscribe((data2: SAM[]) => {
        this.ings = data2;
        this.ings.sort( (a, b) => a.samid.mid.mid - b.samid.mid.mid);
      });
    });

    console.log(this.currMenu);

    
  }

  addtoCart($event: any ) {
    const mid: number = $event.target.value;
    console.log(mid);
    const ann: Menu = this.currMenu[mid - 1];

    console.log(ann);

    console.log(this.ings);
    console.log(mid);

    // tslint:disable-next-line: triple-equals
    const currentings = this.ings.filter(ing => ing.samid.mid.mid == mid);

    console.log(currentings);
    // this.ings.

    for (const a of currentings) {
      if (this.ingCounter.has(a)) {
        this.ingCounter.set(a, this.ingCounter.get(a) + a.amount);
      } else {
        this.ingCounter.set(a, a.amount);
        console.log(a);
      }
      // tslint:disable-next-line: triple-equals
      for (const x of this.ings.filter(ing => ing.samid.sid.ingredient == a.samid.sid.ingredient)) {
        if (x.samid.sid.quantity < x.amount + this.ingCounter.get(a)) {
          (document.getElementById('B' + x.samid.mid.mid) as HTMLInputElement).disabled = true;
          // console.log();
        }
      }
    }

    console.log(this.ingCounter);


    this.cart.addtoCart(ann);

    this.cart.displayCart();




  }

  addNum(selectedItem: any){
    const mid: number = selectedItem.mid;
    // var count: number;
    
    this.count=this.count+1;
    console.log(document.getElementById(String(mid)).innerHTML);
    document.getElementById(String(mid)).innerHTML = this.cart.peek(selectedItem);
  }

  toOrder() {
    const OrderUp = this.cart.sendCart();
    console.log(OrderUp);
    const StringCart = JSON.stringify(OrderUp);
    this.session.set('Cart', StringCart);

    console.log(this.session.get('Cart'));


    this.router.navigate(['order']);
  }

  backToHome(){
    this.cart.clearCart();
    this.router.navigate(['menu-choice']);
  }
}
