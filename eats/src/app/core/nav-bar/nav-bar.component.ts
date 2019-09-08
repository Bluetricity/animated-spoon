import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/shared/user.service';
import {Currentuser} from 'src/app/shared/currentuser';
import {SessionStorageService} from 'angular-web-storage';
import { HomeComponent } from 'src/app/core/home/home.component';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  title = 'Galaxy Eats';
  public loggedUser: Currentuser;

  constructor(public route: Router, private userService: UserService,
              private session: SessionStorageService) { }

  ngOnInit() {
  }

  isloggedUser() {
    this.loggedUser = JSON.parse(this.session.get('User'));
    console.log(this.loggedUser);
    return this.loggedUser;
  }

  isEmployee(): boolean {
    return this.userService.isEmployee();
  }

  isCustomer(): boolean {
    return this.userService.isCustomer();
  }

  logout() {
    return this.userService.logout();
  }

  createAccount() {
    this.route.navigate(['create-account']);
  }

}
