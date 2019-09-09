import { Component, OnInit } from '@angular/core';
import { Currentuser } from '../shared/currentuser';
import { UserService } from '../shared/user.service';
import { SessionStorageService } from 'angular-web-storage';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public loggedUser: Currentuser;
  public username: string;
  public password: string;

  constructor(private userService: UserService, public session: SessionStorageService, private router: Router) { }

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
      // window.location.reload();
    }
  }

  logout() {
    // this.router.navigate(['home']);

    this.userService.logout();
    this.router.navigate(['home']);
    window.location.reload();
  }
}
