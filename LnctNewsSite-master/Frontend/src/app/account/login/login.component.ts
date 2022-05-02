import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ModalService } from 'src/app/service/modal/modal.service';
import { BasicAuthService } from '../../service/http/basic-auth.service';

@Component({
    selector: 'app-login',
    templateUrl: 'login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    invalidCreditials: boolean;
    enrollmentNo: string = '';
    user_password: string = '';
    message=""
    response_status = 0
    
    constructor(
        private router: Router,
        private modalService: ModalService,
        private basicAuthService: BasicAuthService
      
    ) {
        this.invalidCreditials = false;
        
     }
    

    ngOnInit() {
       
    }


    signIn() {
      this.response_status = 0;
      this.invalidCreditials = false;
        if (this.enrollmentNo.trim().length === 0 || this.user_password.trim().length === 0) {
          this.response_status = 1;
          this.invalidCreditials = false;
          return;
        }
    
        this.basicAuthService.executeAuthencationService(this.enrollmentNo, this.user_password).subscribe(
          data => {
            this.response_status = 1;
            this.closeModal("custom-modal-1")
            window.location.reload();
          },
          error => {
            this.response_status = 1
            this.invalidCreditials = true;
          }
        )
      }
    
      register() {
       
        this.router.navigate(['register']);
      }
    openModal(id: string) {
        this.modalService.open(id);
    }

    closeModal(id: string) {
        this.modalService.close(id);
    }

   
}