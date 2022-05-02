import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { SocialUser, SocialAuthService, FacebookLoginProvider, GoogleLoginProvider } from 'angularx-social-login';
import { UserService } from 'src/app/service/data/user.service';
import { ModalService } from 'src/app/service/modal/modal.service';
import { BasicAuthService } from '../../service/http/basic-auth.service';



@Component({
    selector: 'app-forget-password',
    templateUrl: 'forget-password.component.html',
    styleUrls: ['./forget-password.component.css']
})
export class ForgetPasswordComponent implements OnInit {
    
    emailId: string = '';
    message:String;
    err:String;
    foo:number;
    i = 1;
    constructor(
        private userService :UserService,
        private modalService: ModalService      
    ) {
        
     }

    ngOnInit() {
       
    }

    forgotPassword(forgetPassword) {
        this.i = 0;
      this.userService.executeForgotPassword(this.emailId).subscribe(
        ()=> {
            this.foo = 1;
            this.i = 1;
            forgetPassword.reset();
            this.message="Request to reset password received. Check your inbox for the reset link."
        },
        () => {
            this.foo = 2
            this.i = 1;
            this.err = "email  not found!"
            forgetPassword.reset();
        }
      )
    }
    
    openModal(id: string) {
        this.modalService.open(id);
    }

    closeModal(id: string) {
        this.modalService.close(id);
    }

   
}