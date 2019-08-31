import { Component, OnInit, Input } from '@angular/core';
import { Stock } from '../shared/stock';
import { Router } from '@angular/router';

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

  //@Input() stock: Stock;

  Inv: any = sampleData

  constructor(private router: Router) { }

  ngOnInit() {
  }
  backToHome(){
    this.router.navigate(['home']);
  }
  addNewItem(){
    this.router.navigate(['new-stock']);
  }
}
