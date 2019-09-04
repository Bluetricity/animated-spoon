import { Injectable } from '@angular/core';
import { UrlService } from './shared/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Currentuser } from './shared/currentuser';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private appUrl = this.caUrl.getUrl() + '/customer/';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});


  constructor(private caUrl: UrlService, private http: HttpClient) { }

  create(username: string, password: string, name: string, contactInfo: string): Observable<Currentuser>{
    const obj = {username:username, password: password, name: name, contactinfo: contactInfo};
    const body = JSON.stringify(obj);
    return this.http.post(this.appUrl, body, {headers: this.headers, withCredentials: true}).pipe(
      map( resp => {
        const newUser: Currentuser = resp as Currentuser;
        return newUser;
      }));
  }
}
