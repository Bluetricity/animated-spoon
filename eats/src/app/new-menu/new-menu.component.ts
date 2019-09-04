import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Menu } from '../shared/menu';
import { MenuServiceService } from '../menu-service.service';

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

  constructor(private createService: MenuServiceService,
    private router: Router) { }

  ngOnInit() {
  }
  addMenuItem(){
    console.log(this.mealname);
    console.log(this.desc);
    console.log(this.price);
    if(this.mealname == null || this.price == null || this.desc == null){
      window.alert("reeee");
    }
    else{
      this.createService.addMenu(this.mealname,this.price,this.desc).subscribe(
        resp =>{
          this.newMenuItem = resp;
        }
      );
    // this.router.navigate(['stock']);
    }
  }
  goBack(){
    this.router.navigate(['employee-menu-items']);
  }
}