import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/shared/user.service';
import { HomeComponent } from 'src/app/core/home/home.component';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  title = 'Galaxy Eats';

  constructor(public route: Router, private userService: UserService) { }

  ngOnInit() {
    if(this.isEmployee() == false && this.isCustomer() == false){
      this.route.navigate(['home']);
    }
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
