import { Component, OnInit } from '@angular/core';
import { Currentuser } from '../shared/currentuser';
import { UserService } from '../shared/user.service';
import { SessionStorageService } from 'angular-web-storage';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public loggedUser: Currentuser;
  public username: string;
  public password: string;

  constructor(private userService: UserService, public session: SessionStorageService) { }

  ngOnInit() {
    this.userService.login(null, null).subscribe(
      resp => {
        this.loggedUser = resp;
      }
    );
  }

  login() {
    if (this.username !== null && this.password !== null || this.username !== undefined) {
      this.userService.login(this.username, this.password).subscribe(
        resp => {
          this.loggedUser = resp;
          console.log(this.loggedUser.cust.name);
          console.log(this.loggedUser.emp.name);
        }
      );
      this.loggedUser = this.session.get('User');
    }
  }

  logout() {
    this.userService.logout();
  }
}
