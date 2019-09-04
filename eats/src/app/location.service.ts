import { Injectable } from '@angular/core';
import { UrlService } from './shared/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import {Location} from './location';

@Injectable({
  providedIn: 'root'
})
export class LocationService {
  private appUrl = this.lUrl.getUrl() + '/location/';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private lUrl: UrlService, private http: HttpClient) { }

  getCustomerLocation(cId: number): Observable<Location[]>{
    const newUrl = this.appUrl + cId;
    return this.http.get(newUrl, {headers: this.headers, withCredentials: true}).pipe(
      map( resp => resp as Location[]));
  }

  addNewLocation(cId: number, address: string): Observable<Location>{
    const obj = {CID: cId, Address: address};
    const body = JSON.stringify(obj);
    return this.http.post(this.appUrl, body, {headers: this.headers, withCredentials: true}).pipe(
      map( resp => resp as Location));
  }
}
