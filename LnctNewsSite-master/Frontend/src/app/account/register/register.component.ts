import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup } from '@angular/forms';
import { ModalService } from '../../service/modal/modal.service';
import { UserService } from '../../service/data/user.service';
import { LoginComponent } from '../login/login.component';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';

export class User {
  constructor(
    public userId: number,
    public userName: String,
    public enrollmentNo : String,
    public password: String,
    public emailId: String,
    public userMode : number,
    public enabled: boolean,
    public isAdmin: boolean,
   
  ) { }
  public getUserId(): number {
    return this.userId;
  }
  public getUserName(): String {
    return this.userName;
  }
  public getEnrollmentId() : String {
    return this.enrollmentNo;
  }
  public getPassword(): String {
    return this.password;
  }
  public getEmailId(): String {
    return this.emailId;
  }
  public getUserMode():number {
      return this.userMode;
  }
  public getIsAdmin(): boolean {
    return this.isAdmin;
  }
  public isEnabled() : boolean {
    return this.enabled;
  }
 
}


@Component({
    selector: 'app-register',
    templateUrl: 'register.component.html',
    styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
    form: FormGroup;
    loading = false;
    submitted = false;
    user: User;
    userId : number;
    message: String;
    user_status;
    response_status = 0
    loginComponent
    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private userService: UserService,
        private modalService: ModalService,
        private basicAuthService: BasicAuthService
    ) { 
        this.user = new User(0, '', '', '', '', 5, true, false);
        this.userId = this.route.snapshot.params['userId'];
        this.loginComponent = new LoginComponent(this.router, this.modalService, this.basicAuthService);
        
    }
    ngOnInit() {

      
    }
    onItem1Change(value){
      if(value == 'false'){
        this.user_status = 0;
        this.user.userMode = 2;
      }
      else {
          this.user_status = 1;
          this.user.userMode = 1;
      }
   }
   onItemChange(value){
 }
    openModal(id: string) {
        this.modalService.open(id);
    }

    closeModal(id: string) {
        this.modalService.close(id);
    }
    saveUser() {
        this.response_status = 0;
        this.userService.executeSaveUser(this.user).subscribe(
          () => {
            alert( "            You are registered with LNCTnewsSITE");
            this.loginComponent.user_password = this.user.getPassword();
            this.loginComponent.enrollmentNo = this.user.getEnrollmentId();
            this.loginComponent.signIn();
          },
          _error => {
           if(_error.status == 404)
           {
             this.message = "You are not registered as admin";
             this.response_status = 1;
           }
           else if(_error.status == 409)
           {
              this.message = "id is already registered";
              this.response_status = 2;
           }
           else
           {   
              this.message = "something went wrong";
              this.response_status = 3; 
           }  
          });
        
      }

      
}