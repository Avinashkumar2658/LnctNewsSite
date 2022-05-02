import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  constructor(public httpClient : HttpClient) { }

  getUpdate(categoryId){
    return this.httpClient.get<any[]>(`${APP_URL}/home/${categoryId}`)
  }
  getNewsByNewsId(newsId) {
    return this.httpClient.get<any>(`${APP_URL}/news/${newsId}`)
  }
  getFileById(largeNewsId) {
    return this.httpClient.get<any>(`${APP_URL}/largeNewsFile/${largeNewsId}`)
  }
  executeDeleteLargeNews(newsId) {
    return this.httpClient.delete<String>(`${APP_URL}/deleteLargeNews/${newsId}`);
  }
  executeDeleteNews(newsId) {
    return this.httpClient.delete<String>(`${APP_URL}/deleteNews/${newsId}`);
  }
}
