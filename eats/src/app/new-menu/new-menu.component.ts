import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Menu } from '../shared/menu';
import { MenuServiceService } from '../menu-service.service';
import { MenuTypesServiceService } from '../menu-types-service.service';
import { MenuTypes } from '../shared/menu-types';

@Component({
  selector: 'app-new-menu',
  templateUrl: './new-menu.component.html',
  styleUrls: ['./new-menu.component.css']
})
export class NewMenuComponent implements OnInit {

  public mealname: string;
  public price: number;
  public desc: string;
  public mtid: number;
  public tempString: string;
  public tempInt: number;
  public t: Menu;
  public test: MenuTypes;
  public newMenuItem: Menu;
  public MenuTypes: MenuTypes[];

  constructor(private createService: MenuServiceService,
    private createService2: MenuTypesServiceService,
    private router: Router) { }

    ngOnInit() {
      this.createService2.getMenuTypes().subscribe((data: MenuTypes[]) => {
        this.MenuTypes = data;
      });
    }
  addMenuItem(){
    // console.log(this.mtid);
    // console.log(JSON.stringify(this.mtid));
    // console.log(MenuTypes.find(({mtid}) => mtid === 'winter'));
    console.log(JSON.stringify("temp string is: "+this.tempString));
    console.log(JSON.stringify("temp int is: "+this.tempInt));
    console.log(this.MenuTypes.find(({menuName}) => menuName === JSON.stringify(this.tempString)));
    console.log(this.MenuTypes.find(({mtid}) => mtid === Number(this.tempInt)));
    this.test=this.MenuTypes.find(({mtid}) => mtid === Number(this.tempInt));
    console.log(this.test);
    // console.log(this.mtid);
    // console.log("test: "+(document.getElementById("test")).value);
    console.log(this.mealname);
    console.log(this.desc);
    console.log(this.price);
    if(this.mealname == null || this.price == null || this.desc == null){
      window.alert("reeee");
    }
    else{
      this.createService.addMenu(this.test,this.mealname,this.price,this.desc).subscribe(
        resp =>{
          this.newMenuItem = resp;
        }
      );
    this.goBack();
    }
  }
  goBack(){
    this.router.navigate(['employee-menu-items']);
  }
  getMenu(event: any){
    // console.log(this.mtid);
    this.mtid=event.target.value;
    this.tempString=event.target.value;
    this.tempInt=event.target.value;
    this.t=event.target.value;
    console.log(this.t);
  }
}