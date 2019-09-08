import { Injectable } from '@angular/core';
import { UrlService } from './url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from './employee';
import { Customer } from './customer';
import { Currentuser } from './currentuser';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import {SessionStorage, SessionStorageService} from 'angular-web-storage';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private appUrl = this.url.getUrl() + '/login';
  private headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
  private employee: Employee;
  private customer: Customer;

  constructor(private url: UrlService, private http: HttpClient, public session: SessionStorageService, 
    private router: Router) { }

  login(username: string, password: string): Observable<Currentuser> {
    // console.log(this.appUrl);
    // console.log(this.headers);
    // console.log(this.http);
    if ( username && password ) {
      const body = `username=${username}&password=${password}`;
      return this.http.post(this.appUrl, body, {headers: this.headers, withCredentials: true}).pipe(
        map( resp => {
          console.log(resp);
          const user: Currentuser = resp as Currentuser;
          console.log(user);
          if (user) {
            this.employee = user.emp;
            this.customer = user.cust;
          }
          this.session.set('User', JSON.stringify(user));
          console.log(JSON.parse(this.session.get('User')));
          return user;
        })
      );
    } else {
      return this.http.get(this.appUrl, {withCredentials: true}).pipe(
        map( resp => {
          const user: Currentuser = resp as Currentuser;
          if (user) {
            this.employee = user.emp;
            this.customer = user.cust;
          }
          return user;
        })
      );
    }
  }

  logout()  {
    this.session.remove('User');
    // this.router.navigate(['home']);
    window.location.reload();
  }
  getCustomer(): Customer {
    return this.customer;
  }
  getEmployee(): Employee {
    return this.employee;
  }
  isEmployee(): boolean {
    if (this.session.get('User')) {
      const cUser: Currentuser = JSON.parse(this.session.get('User'));
      return (cUser.emp !== undefined && cUser.emp !== null);
    }
    return (this.employee !== undefined && this.employee !== null);
  }
  isCustomer(): boolean {
    if (this.session.get('User')) {
      const cUser: Currentuser = JSON.parse(this.session.get('User'));
      return (cUser.cust !== undefined && cUser.cust !== null);
    }
    return (this.customer !== undefined && this.customer !== null);
  }

}
