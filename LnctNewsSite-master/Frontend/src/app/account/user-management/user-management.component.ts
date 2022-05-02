import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/service/data/admin.service';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.css']
})
export class UserManagementComponent implements OnInit {
 block_user_list: any[] = [];
 blockUserId : number;
 unBlockUserId : number;
 response_status : number = 0;
 spinner_status : number = 0;
  constructor(private adminService : AdminService) { }

  ngOnInit(): void {

  }

  blockUserList() {
    this.response_status = 0;
    this.spinner_status = 3;
    this.adminService.executeBlockUserList().subscribe(
      (res) => {
          this.block_user_list = res;
          if(this.block_user_list.length == 0)
          this.response_status = 3;
          this.spinner_status = 0;
      }
    )
  }
  blockUser() {
    this.response_status = 0;
    this.spinner_status = 1;
    this.adminService.executeBlockUser(this.blockUserId).subscribe(
      () => {
        this.response_status = 1;
        this.spinner_status = 0;
      }
    )
  }
  unBlockUser() {
    this.response_status = 0;
    this.spinner_status = 2;
    this.adminService.executeUnBlockUser(this.unBlockUserId).subscribe(
      () => {
        this.response_status = 2;
        this.spinner_status = 0;
      }
    )
  }
}
