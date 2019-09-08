import { Injectable } from '@angular/core';
import { UrlService } from './shared/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Stock } from './shared/stock';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Customer } from './shared/customer';
import { CurrentTransactions } from './shared/current-transactions';

@Injectable({
  providedIn: 'root'
})
export class AddTransactionService {

  // private appUrl = this.caUrl.getUrl + '/http://localhost:4200/Eattery/stock';
  private appUrl = this.caUrl.getUrl() + '/transaction/';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private caUrl: UrlService, private http: HttpClient) { }

  create(cid: Customer, PAYMENT_TYPE: string, status: number): Observable<CurrentTransactions> {
    const transer: CurrentTransactions = {cid, payment_type: PAYMENT_TYPE, status, tid: null};

//    const obj = {cid: cid, payment_type: PAYMENT_TYPE, status: status};
    const body = JSON.stringify(transer);
    return this.http.post(this.appUrl, body, {headers: this.headers, withCredentials: true}).pipe(
      map(resp => {
        const newStock: CurrentTransactions = resp as CurrentTransactions;
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
