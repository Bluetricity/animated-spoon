import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { NgFormSelectorWarning } from '@angular/forms';
import { Router } from '@angular/router';
import { Currentuser } from '../shared/currentuser';
import { UserService } from '../shared/user.service';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {
  public username: string;
  public password: string;
  public name: string;
  public contactInfo: string;
  public loggedUser: Currentuser;

  constructor(private createService: CustomerService,
              private router: Router,
              private userService: UserService) { }

  ngOnInit() {
  }
  submit() {
    if (this.username !== null && this.password !== null && this.name !== null && this.contactInfo !== null) {
      this.createService.create(this.username.trim(), this.password.trim(), this.name.trim(), this.contactInfo.trim()).subscribe(
        (resp: Currentuser) => {
          console.log(resp);
          this.loggedUser = resp;
          console.log(this.loggedUser)
          this.userService.login(this.username.trim(), this.password.trim()).subscribe(resp =>
            {
              this.router.navigate(['account-info']);
            }
          );
          
        });
    }
  }
  returnTo() {
    this.router.navigate(['home']);
  }
}
