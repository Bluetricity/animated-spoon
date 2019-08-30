import { Component, OnInit } from '@angular/core';
import { CreateAccountService } from '../create-account.service';
import { NgFormSelectorWarning } from '@angular/forms';

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
  public location: string;

  constructor(private createService: CreateAccountService) { }

  ngOnInit() {
  }
  submit(){
    this.createService.create(this.username, this.password, this.name, this.contactInfo, this.location);
    this.returnTo();
  }
  returnTo(){
    //returns to home page
  }
}
