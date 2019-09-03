import { Component, OnInit } from '@angular/core';
import { AddStockService } from '../add-stock.service';
import { Router } from '@angular/router';
import { Stock } from '../shared/stock';

@Component({
  selector: 'app-new-stock',
  templateUrl: './new-stock.component.html',
  styleUrls: ['./new-stock.component.css']
})
export class NewStockComponent implements OnInit {
  public ingredient: string;
  public quantity: number;
  public newStock: Stock;

  constructor(private createService: AddStockService,
    private router: Router) { }

  ngOnInit() {
  }
  addStock(){
    this.createService.create(this.ingredient,this.quantity).subscribe(
      resp =>{
        this.newStock = resp;
      }
    );
   // this.router.navigate(['stock']);
  }
  goBack(){
    this.router.navigate(['stock']);
  }
}
