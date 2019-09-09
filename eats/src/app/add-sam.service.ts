import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from './shared/url.service';
import { Samid } from './shared/samid';
import { Observable } from 'rxjs';
import { SAM } from './shared/sam';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AddSAMService {
  private appUrl = this.caUrl.getUrl() + '/SaM/';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private caUrl: UrlService, private http: HttpClient) { }

  create(samid: Samid, amount: number): Observable<SAM> {
    const transer: SAM = {samid, amount};

    const body = JSON.stringify(transer);
    return this.http.post(this.appUrl, body, {headers: this.headers, withCredentials: true}).pipe(
      map(resp => {
        const newStock: SAM = resp as SAM;
        return newStock;
      })
    );
  }

  getCurrentInv(): Observable<SAM[]> {
    const newUrl = this.appUrl;
    console.log(newUrl);
    return this.http.get(newUrl, {withCredentials: true}).pipe(
      map( resp => resp as SAM[]));
  }
}
