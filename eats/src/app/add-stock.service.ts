import { Injectable } from '@angular/core';
import { UrlService } from './shared/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AddStockService {

  private appUrl = this.caUrl.getUrl + '/customer';
  private headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});

  constructor(private caUrl: UrlService, private http: HttpClient) { }

  create(ingredient: string, quantity: number){
    const body = `ingredient=${ingredient}&quantity=${quantity}`;
    return this.http.post(this.appUrl, body, {headers: this.headers, withCredentials: true})
  }
}
