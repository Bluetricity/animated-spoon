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
  private appUrl = this.caUrl.getUrl() + '/menu';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private caUrl: UrlService, private http: HttpClient) { }

  getMenuCust(): Observable<Menu[]> {
    return this.http.get(this.appUrl, {withCredentials: true}).pipe(
      map( resp => resp as Menu[])
    );
  }

  getMenuItem(mid: number): Observable<Menu> {
    const url: string = this.appUrl + '/' + mid;
    return this.http.get(url, {withCredentials: true}).pipe(
      map(resp => resp as Menu));
  }

  getMenuEmp(): Observable<Menu[]> {
    return this.http.get(this.appUrl + '/all', {withCredentials: true}).pipe(
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

  removeMenu(menu: Menu): Observable<void> {
    const url = 'http://localhost:8080/Eattery/menu/' + menu.mid;
    const body = JSON.stringify(menu);
    return this.http.delete(url, {headers: this.headers, withCredentials: true} ).pipe(
      map(resp => null)
    );
  }

}
