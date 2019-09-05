import { Injectable } from '@angular/core';
import { UrlService } from './shared/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import {Location} from './location';
import {Customer} from './shared/customer';

@Injectable({
  providedIn: 'root'
})
export class LocationService {
  private appUrl = this.lUrl.getUrl() + '/location/';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private lUrl: UrlService, private http: HttpClient) { }

  getCustomerLocation(cId: number): Observable<Location[]>{
    const newUrl = this.appUrl + cId;
    console.log(newUrl);
    return this.http.get(newUrl, {withCredentials: true}).pipe(
      map( resp => resp as Location[]));
  }

  addNewLocation(cust: Customer, address: string): Observable<Location>{
    const obj = {cid: cust, address: address};
    console.log(obj);
    const body = JSON.stringify(obj);
    console.log(body);
    return this.http.post(this.appUrl, body, {headers: this.headers, withCredentials: true}).pipe(
      map( resp => resp as Location));
  }
}
