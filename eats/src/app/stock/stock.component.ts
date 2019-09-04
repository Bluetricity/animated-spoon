import { Component, OnInit, Input } from '@angular/core';
import { Stock } from '../shared/stock';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {

  @Input() stock: Stock;

  constructor() { }

  ngOnInit() {
    this.stock = new Stock();
    this.stock.stock_id = 1;
    this.stock.ingredient = 'chicken';
    this.stock.quantity = 50;
  }

}
