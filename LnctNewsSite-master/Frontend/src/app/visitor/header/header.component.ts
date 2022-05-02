import { Component, OnInit } from '@angular/core';
import { AccountModule } from 'src/app/account/account.module';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';
import { ModalService } from 'src/app/service/modal/modal.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  admin : boolean = false;
  isLoggedIn: boolean;
  constructor(private modalService: ModalService, private account: AccountModule,
    private basicAuthService: BasicAuthService) {
      if(basicAuthService.isUserLoggedIn()) {
        if(basicAuthService.isAdmin() === 'true') {
          this.admin = true;
        }
      }


  }
  logout() {

    this.basicAuthService.logout();
  }

  ngOnInit(): void {
    this.checkAuthenticatedUser();
  }

  checkAuthenticatedUser(): boolean {
    return this.isLoggedIn = this.basicAuthService.isUserLoggedIn();
  }
  openModal(id: string) {
    this.modalService.open(id);


  }

  closeModal(id: string) {
    this.modalService.close(id);
  }
}
