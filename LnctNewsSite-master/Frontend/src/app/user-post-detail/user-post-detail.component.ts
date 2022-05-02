import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/data/user.service';
import { BasicAuthService } from '../service/http/basic-auth.service';

@Component({
  selector: 'app-user-post-detail',
  templateUrl: './user-post-detail.component.html',
  styleUrls: ['./user-post-detail.component.css']
})
export class UserPostDetailComponent implements OnInit {
  postActivity_list:any[] = [];
  start_date : Date;
  end_date : Date;
  duplicate_date : any[] = []
  response_status = 3;
  constructor(private userService : UserService, private basicAuthService : BasicAuthService) {
   }

  ngOnInit(): void {
    
  }
  executePostDetailList() {
    this.response_status = 0;
    this.postActivity_list = [];
    this.userService.executeFindAllUpdatePost(this.basicAuthService.getAuthenticatedUserId(), this.start_date, this.end_date).subscribe(
      (res) => {
        this.postActivity_list = res;
        this.response_status = 2;
        for(let i = 0; i< this.postActivity_list.length; i++) {
          this.postActivity_list[i][4] = this.postActivity_list[i][4].split("-").reverse().join("-");
        }
        if(this.postActivity_list.length == 0) {
          this.response_status = 1;
          this.duplicate_date[0] = this.start_date;
          this.duplicate_date[1] = this.end_date;
          this.duplicate_date[0] = this.duplicate_date[0].split("-").reverse().join("-");
          this.duplicate_date[1] = this.duplicate_date[1].split("-").reverse().join("-")
        }
      }
    )
  }
}
