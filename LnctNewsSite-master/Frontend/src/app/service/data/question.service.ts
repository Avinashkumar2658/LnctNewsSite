import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';
import { Question } from 'src/app/datautil';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(
    private http : HttpClient
  ) { }

  executeFindAllQuestion() {
    return this.http.get<Question[]>(`${APP_URL}/getAllQuestion`)
  }
}
