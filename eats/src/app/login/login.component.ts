import { Component, OnInit } from '@angular/core';
import { Currentuser } from '../shared/currentuser';
import { UserService } from '../shared/user.service';
// import { Session } from 'inspector';
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
    this.userService.login(this.username, this.password).subscribe(
      resp => {
        this.loggedUser = resp;
        console.log(this.loggedUser.cust.name);
      }
    );
    this.loggedUser = this.session.get('User');
    console.log('!!!');
    
  }

  logout() {
    this.userService.logout();
      // resp => {
      //   this.loggedUser = null;
      // }
    // );
  }
}
