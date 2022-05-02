import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { APP_URL } from 'src/app.constants';

@Injectable({
  providedIn: 'root'
})
export class CollegeEventService {

  constructor(private http : HttpClient) { }

  executeClassNotes(semester) : Observable<any> {
      return this.http.get(`${APP_URL}/class_notes/${semester}`)
  }

}
