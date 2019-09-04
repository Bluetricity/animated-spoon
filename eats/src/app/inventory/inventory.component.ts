import { Component, OnInit, Input } from '@angular/core';
import { Stock } from '../shared/stock';
import { Router } from '@angular/router';
import { GetStockService } from '../get-stock.service';
import { Observable } from 'rxjs';
import sampleData from '../data.json';


@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {

  poptable: Observable<any[]>;
  columns: string[];
  test: string[];

  public ingredient: string;
  public quantity: number;
  public getStock: Stock;
  public currStock: Stock[];

  //@Input() stock: Stock;

  Inv: any = sampleData
  stocks: Stock[];

  constructor(private createService: GetStockService,
    private router: Router) { }

  ngOnInit() {
    this.createService.make().subscribe((data: Stock[]) => {
      this.stocks = data;
    });
  }
  backToHome(){
    this.router.navigate(['home']);
  }
  addNewItem(){
    this.router.navigate(['new-stock']);
  }
  getItem(){
    // this.createService.make(this.ingredient,this.quantity).subscribe(
    //   resp =>{
    //     this.getStock = resp;
    //   }
    // )
    this.createService.make().subscribe(stock => this.currStock = stock);
    

  }
}


