import { Injectable } from '@angular/core';
import { UrlService } from './shared/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CreateAccountService {
  private appUrl = this.caUrl.getUrl + '/customer';
  private headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});

  constructor(private caUrl: UrlService, private http: HttpClient) { }

  create(username: string, password: string, name: string, contactInfo: string){
    const body = `username=${username}&password=${password}&name=${name}&contactinfo=${contactInfo}`;
    return this.http.post(this.appUrl, body, {headers: this.headers, withCredentials: true})
  }
}
