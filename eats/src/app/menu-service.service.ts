import { Injectable } from '@angular/core';
import { UrlService } from './shared/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Menu } from './shared/menu';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MenuServiceService {
  private appUrl = this.caUrl.getUrl() + '/menu/';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private caUrl: UrlService, private http: HttpClient) { }

  getMenu(): Observable<Menu[]> {
    return this.http.get(this.appUrl, {withCredentials: true}).pipe(
      map( resp => resp as Menu[])
    );
  }

  addMenu(mealname: string, price: number, desc: string): Observable<Menu> {
    const obj = {mealname, price, desc};
    const body = JSON.stringify(obj);
    return this.http.post(this.appUrl, body, {headers: this.headers, withCredentials: true}).pipe(
      map(resp => {
        const newMenuItem: Menu = resp as Menu;
        return newMenuItem;
      })
    );
  }

  // removeMenu(): void {
  //   const obj = Menu[].menuId.splice()
  // }

}
