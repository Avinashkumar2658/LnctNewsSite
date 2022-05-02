import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';


@Injectable({
  providedIn: 'root'
})
export class FrontService {
 

  constructor(public httpClient : HttpClient) { }

  getAllImage(){
    return this.httpClient.get<any[]>(`${APP_URL}/getall/`);
  }

}
