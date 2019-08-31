import { Component, OnInit } from '@angular/core';
import { AddStockService } from '../add-stock.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-stock',
  templateUrl: './new-stock.component.html',
  styleUrls: ['./new-stock.component.css']
})
export class NewStockComponent implements OnInit {
  public ingredient: string;
  public quantity: number;

  constructor(private createService: AddStockService,
    private router: Router) { }

  ngOnInit() {
  }
  addStock(){
    this.createService.create(this.ingredient,this.quantity);
    this.router.navigate(['stock']);
  }
  goBack(){
    this.router.navigate(['stock']);
  }
}
