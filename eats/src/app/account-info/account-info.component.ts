import { Component, OnInit } from '@angular/core';
import {SessionStorageService} from 'angular-web-storage';
import { Router } from '@angular/router';
import {Currentuser} from '../shared/currentuser';
import {LocationService} from '../location.service'
import {Location} from '../location';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-account-info',
  templateUrl: './account-info.component.html',
  styleUrls: ['./account-info.component.css']
})
export class AccountInfoComponent implements OnInit {
  poptable: Observable<any[]>;
  columns: string[];
  test: string[];

  public newLocation: string;
  public loggedUser: Currentuser;
  public Locations: Location[];
  public addedLocation: Location;

  constructor(private locationService: LocationService,
    public session: SessionStorageService,
    private router: Router) { }

  ngOnInit() {
    console.log("Starting");
    this.loggedUser = JSON.parse(this.session.get('User'));
    console.log(this.loggedUser);
    console.log(this.loggedUser.cust.cid);
    this.locationService.getCustomerLocation(this.loggedUser.cust.cid).subscribe(
      (resp : Location[]) => {
        console.log(resp);
        this.Locations = resp;
      }
    );
    
  }

  submit(){
    console.log("Clicked");
    this.locationService.addNewLocation(this.loggedUser.cust, this.newLocation).subscribe((resp: Location) => {
      this.addedLocation = resp;
    });
    console.log("added" + this.loggedUser.cust + this.newLocation);
    //this.returnTo();
  }

  returnTo(){
    this.router.navigate(['home']);
  }
}
