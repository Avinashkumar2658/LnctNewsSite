import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http : HttpClient) { }

  executeBlockUserList() {
    return this.http.get<any[]>(`${APP_URL}/admin/block_user_list`)
  }

  executeBlockUser(userId) {
    return this.http.put(`${APP_URL}/admin/block_user`, userId)
  }

  executeUnBlockUser(userId) {
    return this.http.put(`${APP_URL}/admin/unblock_user`,userId)
  }
  
}
