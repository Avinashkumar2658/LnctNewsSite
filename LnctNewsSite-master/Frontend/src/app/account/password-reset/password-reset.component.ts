import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/service/data/user.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';
declare var $:any;


@Component({
  selector: 'app-password-reset',
  templateUrl: './password-reset.component.html',
  styleUrls: ['./password-reset.component.css']
})
export class PasswordResetComponent implements OnInit {
  val: string;
  enrollmentNo: string;
  document: Document
  password1: String;
  message:String;
  foo: number = 13;
  userId : any;
  user_password: String;
  new_password: String
  spinner_status: number = 1;
  pattern_url : String;
  constructor(private activatedRoute: ActivatedRoute, public basicauth : BasicAuthService,
    private userService : UserService, private router : Router) { 
      this.val = this.activatedRoute.snapshot.url[0].path;
      this.enrollmentNo = this.activatedRoute.snapshot.url[1].path;
      this.pattern_url = this.activatedRoute.snapshot.url[2].path;
      this.userId = this.activatedRoute.snapshot.url[3].path;
      this.linkverify();
    if(this.val == 'reset-password') {
      basicauth.setPageId('reset-password')
    }
    else {
      basicauth.setPageId('home')
    }
  }

  ngOnInit(): void { 
  }
executeResetPassword(passwordReset) {
  this.spinner_status = 0;
  if(!(this.user_password == this.new_password))
  {
    this.spinner_status = 1;
    alert("          password not match");
    passwordReset.reset();
    return;
  }
  this.userService.executeUpdatePassword(this.enrollmentNo, this.user_password).subscribe(
  ()  => {
    this.foo = 2;
    this.spinner_status = 1;
    passwordReset.reset();
    this.message= "Password successfully reset. You can now log in with the new credentials."
    },
    _error => {
      this.foo = 3;
      this.spinner_status = 1;
      this.message= "The link is invalid or broken!"
    }
  )
}
linkverify() {
  this.userService.executeFindUsercredential(this.userId, this.pattern_url).subscribe(
   (res) => {
    this.foo = res;
   }
   )
}
login() {
 this.basicauth.setPageId('home')
  this.router.navigate(['']);
 
}
}
