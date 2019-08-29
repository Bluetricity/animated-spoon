import { Component, OnInit, Input } from '@angular/core';
import { Stock } from '../stock';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {

  @Input() stock: Stock;

  constructor() { }

  ngOnInit() {
    this.stock.stock_id=1;
    this.stock.ingredient='chicken';
    this.stock.quantity=50;
  }

}
