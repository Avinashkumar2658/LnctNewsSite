import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { BasicAuthService } from './basic-auth.service';

@Injectable({
  providedIn: 'root'
})
export class AdminGuardService implements CanActivate{
  constructor(private basicAuthService: BasicAuthService, private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.basicAuthService.isUserLoggedIn() && this.basicAuthService.isAdmin() === 'true')
      return true;
      alert( "            You are not login as admin");
      this.router.navigate([' ']);
  }
  
}
