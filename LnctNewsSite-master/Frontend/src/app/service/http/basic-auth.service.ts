import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { APP_URL } from 'src/app.constants';
import { map } from 'rxjs/operators';

export const AUTHENTICATED_USER = 'authenticatedUser';
export const TOKEN = 'token';
export const PAGE_ID = 'pageId';
export const USER_ID = 'userId';
export const IS_ADMIN = 'admin';
export const IS_Enabled = 'enabled';

export class AuthenticationBean {
  enabled: any;
  constructor(public userId: number,
              public admin : boolean,
              public isEnabled : boolean) { }
              // public is_Enabled() : boolean {
              //   return this.isEnabled;
              // }
}

@Injectable({
  providedIn: 'root'
})

export class BasicAuthService {

  constructor(private http: HttpClient) { }

  executeAuthencationService(enrollmentNo, password) {
    let basicAuthHeaderString = 'Basic ' + window.btoa(enrollmentNo + ":" + password);
    let headers = new HttpHeaders(
      {
        Authorization: basicAuthHeaderString
      }
    );
    return this.http.get<AuthenticationBean>(`${APP_URL}/user/basicauth`, { headers }).pipe(
      map(
        data => {
          if(!(data.enabled)) {
            alert("Account is temporary suspended")
            return;
          }
          localStorage.setItem(USER_ID, "" + data.userId);
          localStorage.setItem(IS_ADMIN, "" + data.admin);
          localStorage.setItem(AUTHENTICATED_USER, enrollmentNo);
          localStorage.setItem(TOKEN, basicAuthHeaderString);
          return data;
        }
      )
    );
  }

  getAuthenticatedUserId(): number {
    return parseInt(localStorage.getItem(USER_ID));
  }

  getAuthenticatedUser() {
    return localStorage.getItem(AUTHENTICATED_USER);
  }
  isAdmin() {
    return localStorage.getItem(IS_ADMIN);
  }

  getAuthenticatedToken() {
    if (this.getAuthenticatedUser())
      return localStorage.getItem(TOKEN);
  }

  isUserLoggedIn() {
    let user = localStorage.getItem(AUTHENTICATED_USER);
    return !(user == null);
  }

  logout() {
    localStorage.removeItem(AUTHENTICATED_USER);
    localStorage.removeItem(TOKEN);
    localStorage.removeItem(PAGE_ID);
    localStorage.removeItem(USER_ID);
  }
  
  pageId(): string {
    var pageId = localStorage.getItem(PAGE_ID);
    if (pageId === null) {
      localStorage.setItem(PAGE_ID, 'home');
    }
    return pageId;
  }

  setPageId(pageId: string) {
    localStorage.setItem(PAGE_ID, pageId);
  }
  
  

}
