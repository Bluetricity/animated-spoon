import { Injectable } from '@angular/core';
import { UrlService } from './url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from './employee';
import { Customer } from './customer';
import { Currentuser } from './currentuser';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import {SessionStorage, SessionStorageService} from 'angular-web-storage';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private appUrl = this.url.getUrl() + '/login';
  private headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
  private employee: Employee;
  private customer: Customer;

  constructor(private url: UrlService, private http: HttpClient, public session: SessionStorageService) { }

  login(username: string, password: string): Observable<Currentuser> {
    console.log(this.appUrl);
    console.log(this.headers);
    console.log(this.http);
    if ( username && password ) {
      // we are attempting to log in
      const body = `username=${username}&password=${password}`;
      // We have to tell our app that we're sending form data, so add the headers

      return this.http.post(this.appUrl, body, {headers: this.headers, withCredentials: true}).pipe(
        map( resp => {
          const user: Currentuser = resp as Currentuser;
          if (user) {
            this.employee = user.emp;
            this.customer = user.cust;
          }
          sessionStorage.setItem('User', 'user');
          this.session.set('User', user);
          return user;
        })
      );
    } else {
      // checking to see if we're logged in
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
    // return this.http.delete(this.appUrl, {withCredentials: true}).pipe(
    //   map(success => {
    //     this.employee = null;
    //     this.customer = null;
    //     return success;
    //   })
    // );
    sessionStorage.removeItem('User');

    this.session.remove('User');
    sessionStorage.clear();
  }
  getCustomer(): Customer {
    return this.customer;
  }
  getEmployee(): Employee {
    return this.employee;
  }
  isEmployee(): boolean {
    return (this.employee !== undefined && this.employee !== null);
  }
  isCustomer(): boolean {
    return (this.customer !== undefined && this.customer !== null);
  }

}
