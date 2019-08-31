import { Component, OnInit } from '@angular/core';
import { CreateAccountService } from '../create-account.service';
import { NgFormSelectorWarning } from '@angular/forms';
import { Router } from '@angular/router';
import { Currentuser } from '../shared/currentuser';

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

  constructor(private createService: CreateAccountService,
    private router: Router) { }

  ngOnInit() {
  }
  submit(){
    this.createService.create(this.username, this.password, this.name, this.contactInfo).subscribe(
      resp =>{
        this.loggedUser = resp;
      });
    this.router.navigate(['account-info']);
  }
  returnTo(){
    this.router.navigate(['home']);
  }
}
