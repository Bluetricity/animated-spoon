import { Component, OnInit } from '@angular/core';
import { Menu } from '../shared/menu';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { MenuServiceService } from '../menu-service.service';
import { MenuTypes } from '../shared/menu-types';



@Component({
  selector: 'app-employee-menu-items',
  templateUrl: './employee-menu-items.component.html',
  styleUrls: ['./employee-menu-items.component.css']
})
export class EmployeeMenuComponent implements OnInit {

  poptable: Observable<any[]>;
  columns: string[];
  test: string[];

  public mealname: string;
  public mtid: MenuTypes;
  public desc: string;
  public price: number;
  public getMenu: Menu;
  public currMenu: Menu[];

  constructor(private createService: MenuServiceService,
              private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.createService.getMenuEmp().subscribe((data: Menu[]) => {
      this.currMenu = data;
      console.log(this.currMenu);
    });
  }

  backToHome() {
    this.router.navigate(['home']);
  }

  addNewMenuItem() {
    this.router.navigate(['new-menu']);
  }

  removeMenu(m: Menu): void {
    this.createService.removeMenu(m).subscribe( data => {
      this.currMenu.filter( i => i !== m );
    });
    window.location.reload();
  }
}
