import { HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BasicAuthService } from '../http/basic-auth.service';

@Injectable({
  providedIn: 'root'
})

export class HttpIntercepterBasicAuthService implements HttpInterceptor {

  constructor(private basicAuthService: BasicAuthService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler) {

    let basicAuthHeaderString = this.basicAuthService.getAuthenticatedToken();
    let enrollmentNo = this.basicAuthService.getAuthenticatedUser();
    if (basicAuthHeaderString && enrollmentNo) {
      request = request.clone({
        setHeaders: {
          Authorization: basicAuthHeaderString
        }
      })
    }
    return next.handle(request);
  }
}
