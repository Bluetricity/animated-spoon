import { Component, OnInit } from '@angular/core';
import {SessionStorageService} from 'angular-web-storage';
import { Router } from '@angular/router';
import {Currentuser} from '../shared/currentuser';
import {LocationService} from '../location.service'
import {Location} from '../location';


@Component({
  selector: 'app-account-info',
  templateUrl: './account-info.component.html',
  styleUrls: ['./account-info.component.css']
})
export class AccountInfoComponent implements OnInit {
  public username: string;
  public password: string;
  public name: string;
  public contactInfo: string;
  public newLocation: string;
  private cId: number
  constructor(private locationService: LocationService,
    public session: SessionStorageService,
    private router: Router) { }

  ngOnInit() {
    const user : Currentuser = JSON.parse(this.session.get('User'));
    this.name = user.cust.name;
    this.username = user.cust.username;
    this.password = user.cust.password;
    this.contactInfo = user.cust.contactinfo;
    this.cId = user.cust.cid;
    this.locationService.getCustomerLocation(user.cust.cid).subscribe(
      (resp : Location[]) => {
        let locationList : Location[] = resp;
          locationList.forEach(location => {
            var table = document.getElementById("location");
            var tr = document.createElement("tr");
            this.addTableDef(tr, location.Address);
            table.appendChild(tr);
        });
      }
    );
    
  }

  addTableDef(tr, value){
    let td = document.createElement("td");
    td.innerHTML = value;
    tr.appendChild(td);
  }

  submit(){
    this.locationService.addNewLocation(this.cId, this.newLocation).subscribe(resp => resp as Location);
    this.returnTo();
  }

  returnTo(){
    this.router.navigate(['home']);
  }
}
