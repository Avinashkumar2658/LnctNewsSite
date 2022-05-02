import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private http: HttpClient
  ) { }

  executeSaveUser(user) {
    return this.http.post(`${APP_URL}/createUser/`,user);
  }

  executeUpdatePassword(enrollmentNo, resetPassword) {
    return this.http.put(`${APP_URL}/reset-password/${enrollmentNo}`,resetPassword);
  }

  executeForgotPassword(emailId) {
    return this.http.post(`${APP_URL}/forgot-password/`,emailId);
  }
  
  executeFindAllAlumni() {
    return this.http.get<any[]>(`${APP_URL}/alumni_profile`)
  }

  executeFindUsercredential(userId, pattern_url) {
    return this.http.get<number>(`${APP_URL}/user_credential/${userId}/${pattern_url}`)
  }

  executeFindAllUpdatePost(userId, from, to) {
    return this.http.get<any[]>(`${APP_URL}/user_post_update/${userId}/${from}/to/${to}`)
  }
}
