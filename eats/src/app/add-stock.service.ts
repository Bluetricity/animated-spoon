import { Injectable } from '@angular/core';
import { UrlService } from './shared/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Stock } from './shared/stock';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AddStockService {

  // private appUrl = this.caUrl.getUrl + '/http://localhost:4200/Eattery/stock';
  private appUrl = this.caUrl.getUrl() + '/new-stock/';
  private headers = new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' });

  constructor(private caUrl: UrlService, private http: HttpClient) { }

  

  create(ingredient: string, quantity: number): Observable<Stock> {
    const obj = {ingredient:ingredient, quantity:quantity};
    const body = JSON.stringify(obj);
    return this.http.post(this.appUrl, body, {headers: this.headers, withCredentials: true}).pipe(
      map(resp => {
        const newStock: Stock = resp as Stock;
        return newStock;
      })
    );
    // return this.http.post<Stock>(this.appUrl, body, { headers: new HttpHeaders({
    //   'Content-Type': 'application/json'
    //   }) 
    // }).pipe(
    //   map(resp => {
    //     const newStock: Stock = resp as Stock;
    //     return newStock;
    //   })
    // );
  }
}
