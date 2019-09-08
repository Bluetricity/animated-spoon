import { Injectable } from '@angular/core';
import { UrlService } from './shared/url.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MenuTypes } from './shared/menu-types';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MenuTypesServiceService {
  private appUrl = this.caUrl.getUrl() + '/Menu_Type/';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private caUrl: UrlService, private http: HttpClient) { }

  getMenuTypes(): Observable<MenuTypes[]>{
    return this.http.get(this.appUrl, {withCredentials: true}).pipe(
      map(resp => resp as MenuTypes[])
    );
  }

  getMenu(mtid: number): Observable<MenuTypes> {
    const url: string = this.appUrl + '/' + mtid;
    return this.http.get(url, {withCredentials: true}).pipe(
      map(resp => resp as MenuTypes));
  }

  addMenuType(MTID: number, menuName: string): Observable<MenuTypes>{
    const obj={MTID:MTID, menuName:menuName};
    const body = JSON.stringify(obj);
    return this.http.post(this.appUrl, body, {headers: this.headers, withCredentials: true}).pipe(
      map(resp => {
        const newMenuType: MenuTypes = resp as MenuTypes;
        return newMenuType;
      })
    );
  }
}
