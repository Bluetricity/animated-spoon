import { Component, OnInit } from '@angular/core';
import { MenuTypes } from '../shared/menu-types';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { MenuTypesServiceService } from '../menu-types-service.service';

@Component({
  selector: 'app-menu-types',
  templateUrl: './menu-types.component.html',
  styleUrls: ['./menu-types.component.css']
})
export class MenuTypesComponent implements OnInit {

  poptable: Observable<any[]>;
  columns: string[];
  test: string[];

  public MTID: number;
  public Menu_Type: string;
  public MenuTypes: MenuTypes[];
  public newMenuItem: MenuTypes;

  constructor(private createService: MenuTypesServiceService,
    private router: Router) { }

  ngOnInit() {
    this.createService.getMenuTypes().subscribe((data: MenuTypes[]) => {
      this.MenuTypes = data;
    });
  }
  backToHome(){
    this.router.navigate(['home']);
  }
  addMenuType(){
    // this.createService.addMenuType(this.MTID, this.Menu_Type).subscribe(
    //   resp =>{
    //     this.newMenuItem = resp;
    //   }
    // );
    this.router.navigate(['new-menu-type']);
  }
}
