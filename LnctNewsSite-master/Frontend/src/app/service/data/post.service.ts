import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';
import { LargeNews, News } from 'src/app/datautil';
let formData : FormData = new FormData();
@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http : HttpClient) { }

  executeSaveNews(news : News, selectedFiles :File) {
    this.resetform();  
    formData.append('newsId', JSON.stringify(news.getNewsId()));
    formData.append('newsHeading', JSON.stringify(news.getNewsHeading()));   
    formData.append('detail', JSON.stringify(news.getNews()));
    formData.append('startDate', JSON.stringify(news.getStartDate()));
    formData.append('endDate', JSON.stringify(news.getEndDate()));
    formData.append('categoryId', JSON.stringify(news.getCategory()));
    formData.append('userId', JSON.stringify(news.getUserId()));
    formData.append('url', JSON.stringify(news.getUrl()))
    formData.append('file', selectedFiles);
    return this.http.post(`${APP_URL}/createNews`,formData);
  
  }
  executeFindAllCategories() {
    return this.http.get<any[]>(`${APP_URL}/categories`)
  }

  executeSaveLargeNews(news : LargeNews, selectedFiles :File) { 
    this.resetform();  
    formData.append('largeNewsId', JSON.stringify(news.getLargeNewsId()));
    formData.append('largeNewsHeading', JSON.stringify(news.getLargeNewsHeading()));
    formData.append('detail', JSON.stringify(news.getDetail()));
    formData.append('year', JSON.stringify(news.getYear()));
    formData.append('semester', JSON.stringify(news.getSemester()));
    formData.append('categoryId', JSON.stringify(news.getCategoryId()));
    formData.append('userId', JSON.stringify(news.getUserId()));
    formData.append('url', JSON.stringify(news.getUrl()))
    formData.append('file', selectedFiles);
    return this.http.post(`${APP_URL}/createLargeNews`, formData)
  }

  executeSaveQuestion(question) {
    return this.http.post(`${APP_URL}/crateQuestion/`, question);
  }

  

  resetform() { 
    formData = new FormData(); 
    }  
}
