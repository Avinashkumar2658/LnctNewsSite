import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient) { }

  executeSaveComment(comment) {
    return this.http.post(`${APP_URL}/createComment`, comment)
  }

  executeSaveLargeNewsComment(comment) {
    return this.http.post(`${APP_URL}/createLargeNewsComment`, comment)
  }

  executeGetComment(answerId) {
    return this.http.get<any[]>(`${APP_URL}/getAnswerComment/${answerId}`)
  }

  executeGetLargeNewsComment(largeNewsId) {
    return this.http.get<any[]>(`${APP_URL}/getComment/${largeNewsId}`)
  }
}
