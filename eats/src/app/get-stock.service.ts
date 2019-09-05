import { Injectable } from '@angular/core';
import { UrlService } from './shared/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Stock } from './shared/stock';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class GetStockService {

  private appUrl = this.caUrl.getUrl() + '/stock/';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private caUrl: UrlService, private http: HttpClient) { }

  make(): Observable<Stock[]> {
    return this.http.get(this.appUrl, {withCredentials: true}).pipe(
      map( resp => resp as Stock[])
    );
  }
  // make(ingredient: string, quantity: number){
  //   const obj = {ingredient:ingredient, quantity:quantity};
  //   const body = JSON.stringify(obj);

  //   return this.http.get(this.appUrl, {headers: this.headers, withCredentials: true}).pipe(
  //     map(resp =>{
  //       const currStock: Stock = resp as Stock;
  //       return currStock;
  //     })
  //   );
  // }
}
