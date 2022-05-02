import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';

@Injectable({
  providedIn: 'root'
})
export class AnswerService {

  constructor(private http : HttpClient) { }

  executeSaveAnswer(answer) {
    return this.http.post(`${APP_URL}/createAnswer`, answer);
  }

  executeFindAnswer(questionId) {
    return this.http.get<[]>(`${APP_URL}/getAllAnswer/${questionId}`)
  }
}
