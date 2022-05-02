import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { APP_URL } from 'src/app.constants';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})

export class ExamService {

  constructor(private http : HttpClient) { }

  executeExamUpdate(semester) : Observable<any> {
      return this.http.get(`${APP_URL}/examUpdate/${semester}`)
  }

}