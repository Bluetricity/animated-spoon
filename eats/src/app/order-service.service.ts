import { Injectable } from '@angular/core';
import { UrlService } from './shared/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CurrentTransactions } from './shared/current-transactions';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class OrderServiceService {
  private appUrl = this.caUrl.getUrl() + '/transaction/';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private caUrl: UrlService, private http: HttpClient) { }

  getTransactions(): Observable<CurrentTransactions[]>{
    return this.http.get(this.appUrl, {withCredentials: true}).pipe(
      map( resp => resp as CurrentTransactions[])
    );
  }
  updateTransactions(transaction: CurrentTransactions): Observable<CurrentTransactions>{
    const url = 'http://localhost:8080/Eattery/transaction/'+transaction.tid;
    const body = JSON.stringify(transaction);
    return this.http.put(url, body, {headers: this.headers, withCredentials: true}).pipe(
      map( resp => resp as CurrentTransactions)
    );
  }  
  // updateTransactions(transaction: CurrentTransactions): Observable<CurrentTransactions>{
  //   const url = 'http://localhost:8080/Eattery/transaction/'+transaction.tid;
  //   const body = JSON.stringify(transaction);
  //   return this.http.patch(url, body, {headers: this.headers, withCredentials: true}).pipe(
  //     map( resp => resp as CurrentTransactions)
  //   );
  // }
}
