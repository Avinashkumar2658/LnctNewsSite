import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})

  
export class TnpService {

  constructor(private http : HttpClient) { }

  executeTnpUpdate(semester) : Observable<any> {
      return this.http.get(`${APP_URL}/tnp_update/${semester}`)
  }}
