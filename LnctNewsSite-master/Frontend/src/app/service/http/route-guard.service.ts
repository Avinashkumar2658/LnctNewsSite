import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from
  '@angular/router';
import { LoginComponent } from 'src/app/account/login/login.component';
import { ModalService } from '../modal/modal.service';
import { BasicAuthService } from './basic-auth.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate {
  loginComponent
  constructor(private basicAuthService: BasicAuthService, private router: Router, private modalService : ModalService) { 
    this.loginComponent = new LoginComponent(this.router, this.modalService, this.basicAuthService);
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.basicAuthService.isUserLoggedIn())
      return true;
    this.loginComponent.openModal("custom-modal-1");
  }
  
}
