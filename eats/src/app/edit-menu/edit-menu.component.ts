import { Component, OnInit } from '@angular/core';
import {SessionStorageService} from 'angular-web-storage';
import { Menu } from '../shared/menu';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { MenuServiceService } from '../menu-service.service';

@Component({
  selector: 'app-edit-menu',
  templateUrl: './edit-menu.component.html',
  styleUrls: ['./edit-menu.component.css']
})
export class EditMenuComponent implements OnInit {

  poptable: Observable<any[]>;
  columns: string[];
  test: string[];

  public mealname: string;
  public desc: string;
  public price: number;
  public getMenu: Menu;
  public currMenu: Menu[];
  createService: any;

  constructor(private menu: MenuServiceService, public session: SessionStorageService,
              private router: Router) { }

  ngOnInit() {
    console.log(JSON.parse(this.session.get('menuType')));
    const mtid = JSON.parse(this.session.get('menuType'));
    console.log(mtid);
    this.menu.getMenuCust(mtid).subscribe((data: Menu[]) => {
      this.currMenu = data;
      this.currMenu.sort( (a, b) => a.mid - b.mid);
    });
    console.log(this.currMenu);
  }

  removeFromMenu(m: Menu): void {
    this.menu.removeMenu(m).subscribe( data => {
      this.currMenu.filter( i => i !== m);
    });
    window.location.reload();
  }

}
