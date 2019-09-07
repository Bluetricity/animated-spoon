import { Component, OnInit } from '@angular/core';
import { MenuTypes } from '../shared/menu-types';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { MenuTypesServiceService } from '../menu-types-service.service';
import { SessionStorageService } from 'angular-web-storage';

@Component({
  selector: 'app-menu-choice',
  templateUrl: './menu-choice.component.html',
  styleUrls: ['./menu-choice.component.css']
})
export class MenuChoiceComponent implements OnInit {
  
  poptable: Observable<any[]>;
  columns: string[];
  test: string[];

  public MTID: number;
  public Menu_Type: string;
  public MenuTypes: MenuTypes[];

  constructor(private createService: MenuTypesServiceService,
    private router: Router, public session: SessionStorageService) { }

  ngOnInit() {
    this.createService.getMenuTypes().subscribe((data: MenuTypes[]) => {
      this.MenuTypes = data;
    });
  }

  setMenuChoice($event: any) {
    const mtid: number = $event.target.value;
    console.log(mtid);
    this.session.set('Choice', JSON.stringify(mtid));
    this.router.navigate(['menu-items']);
  }

  backToHome() {
    this.router.navigate(['home']);
  }


}
