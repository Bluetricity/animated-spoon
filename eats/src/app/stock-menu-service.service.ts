import { Injectable } from '@angular/core';
import { UrlService } from './shared/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Stock } from './shared/stock';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Composid} from './composid';
import { StockMenu} from './stock-menu';
import { Menu } from './shared/menu';

@Injectable({
  providedIn: 'root'
})
export class StockMenuServiceService {

  private appUrl = this.caUrl.getUrl() + '/SaM/';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  public compositeId: Composid;
  public newSandM: StockMenu;

  constructor(private caUrl: UrlService, private http: HttpClient) { }

  addNewSandM(amount: number, ingredient: Stock, menuItem: Menu): Observable<StockMenu>{
    this.compositeId.mid = menuItem;
    this.compositeId.sid = ingredient;
    this.newSandM.composid = this.compositeId;
    this.newSandM.amount = amount;
    const body = JSON.stringify(this.newSandM);
    return this.http.post(this.appUrl, body, {headers: this.headers, withCredentials: true}).pipe(
      map(resp => {
        const newStockMenu: StockMenu = resp as StockMenu;
        return newStockMenu;
      }));
  }
}
