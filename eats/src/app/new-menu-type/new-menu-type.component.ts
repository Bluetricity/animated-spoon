import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Menu } from '../shared/menu';
import { MenuTypesServiceService } from '../menu-types-service.service';
import { MenuTypes } from '../shared/menu-types';

@Component({
  selector: 'app-new-menu-type',
  templateUrl: './new-menu-type.component.html',
  styleUrls: ['./new-menu-type.component.css']
})
export class NewMenuTypeComponent implements OnInit {

  public MTID: number;
  public menuName: string;
  public newMenuType: MenuTypes;

  constructor(private createService: MenuTypesServiceService,
    private router: Router) { }

  ngOnInit() {
  }
  addNewMenuType(){
    console.log(this.menuName);
    this.createService.addMenuType(this.MTID, this.menuName).subscribe(
      resp => {
        this.newMenuType = resp;
      }
    );
  }
  backToHome(){
    this.router.navigate(['home']);
  }
}
