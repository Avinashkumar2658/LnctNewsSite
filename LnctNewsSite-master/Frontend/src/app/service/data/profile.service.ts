import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';
import { User } from 'src/app/datautil';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http : HttpClient) { }

  executeUpdateUser(user : User, profilePhoto : File) { 
    const formData = new FormData();
    formData.append('userId', JSON.stringify(user.userId));
    formData.append('userName', JSON.stringify(user.userName));   
    formData.append('enrollmentNo', JSON.stringify(user.enrollmentNo));
    formData.append('emailId', JSON.stringify(user.emailId));
    formData.append('someThingAboutYourSelf', user.someThingAboutYourSelf);
    formData.append('presentProfile', user.presentProfile);
    formData.append('inspirationWord', user.inspirationWord);
    formData.append('profilePhoto', profilePhoto);
    return this.http.put(`${APP_URL}/user/`,formData);
  
  }
  
  executeFindByUserId(userId) {
    return this.http.get<User>(`${APP_URL}/user/${userId}`)
  }

  
}
