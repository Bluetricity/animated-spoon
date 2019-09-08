import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Menu } from '../shared/menu';
import { MenuServiceService } from '../menu-service.service';
import { Stock } from '../shared/stock';
import { GetStockService } from '../get-stock.service';
import { StockMenu } from '../stock-menu';
import { StockMenuServiceService } from '../stock-menu-service.service';

@Component({
  selector: 'app-new-menu',
  templateUrl: './new-menu.component.html',
  styleUrls: ['./new-menu.component.css']
})
export class NewMenuComponent implements OnInit {

  public mealname: string;
  public price: number;
  public desc: string;
  public newMenuItem: Menu;
  public amount1: number;
  public amount2: number;
  public amount3: number;
  public ingredients: Stock[];
  public ingredient1: Stock;
  public ingredient2: Stock;
  public ingredient3: Stock;
  public newSaM1: StockMenu;
  public newSaM2: StockMenu;
  public newSaM3: StockMenu;

  constructor(private createService: MenuServiceService, private stockService: GetStockService,
    private stockAndMeunService: StockMenuServiceService,private router: Router) { }

  ngOnInit() {
    this.stockService.make().subscribe((resp: Stock[]) => {
      console.log(resp);
      this.ingredients = resp;
    });
  }
  addMenuItem(){
    console.log(this.mealname);
    console.log(this.desc);
    console.log(this.price);
    console.log(this.ingredient1);
    console.log(this.ingredient2);
    console.log(this.ingredient3);
    if(this.mealname == null || this.price == null || this.desc == null || ((this.ingredient1 == null || this.amount1 == null) && (this.ingredient2 == null || this.amount2 == null) && (this.ingredient3 == null || this.amount3 == null))){
      window.alert("reeee");
    }
    else{
      this.createService.addMenu(this.mealname,this.price,this.desc).subscribe(
        resp =>{
          this.newMenuItem = resp;
          if(this.ingredient1 != null && this.amount1 != null){
            this.stockAndMeunService.addNewSandM(this.amount1, this.ingredient1, this.newMenuItem).subscribe(
              (resp: StockMenu) => {
                this.newSaM1 = resp;
              }
            );
          }
          if(this.ingredient2 != null && this.amount2 != null){
            this.stockAndMeunService.addNewSandM(this.amount2, this.ingredient2, this.newMenuItem).subscribe(
              (resp: StockMenu) => {
                this.newSaM2 = resp;
              }
            );
          }
          if(this.ingredient3 != null && this.amount3 != null){
            this.stockAndMeunService.addNewSandM(this.amount3, this.ingredient3, this.newMenuItem).subscribe(
              (resp: StockMenu) => {
                this.newSaM3 = resp;
              }
            );
          }
        }
      );
    this.goBack();
    }
  }
  goBack(){
    this.router.navigate(['employee-menu-items']);
  }
}