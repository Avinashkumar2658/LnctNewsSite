import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';

@Injectable({
  providedIn: 'root'
})
export class ReplyService {
  

  constructor(private http : HttpClient) { }

  executeSaveReply(reply) {
    return this.http.post(`${APP_URL}/reply/`, reply);
  }

  executeGetReply(commentId) {
    return this.http.get<any[]>(`${APP_URL}/reply/${commentId}`);
  }
}
