import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from './shared/url.service';
import { Taiid } from './shared/taiid';
import { Tai } from './shared/tai';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AddTAIService {
  private appUrl = this.caUrl.getUrl() + '/TaI/';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private caUrl: UrlService, private http: HttpClient) { }

  create(taiid: Taiid, quanity: number): Observable<Tai> {
    const transer: Tai = {taiid, quanity};

//    const obj = {cid: cid, payment_type: PAYMENT_TYPE, status: status};
    const body = JSON.stringify(transer);
    return this.http.post(this.appUrl, body, {headers: this.headers, withCredentials: true}).pipe(
      map(resp => {
        const newStock: Tai = resp as Tai;
        return newStock;
      })
    );
  }
}
