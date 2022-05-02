import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/service/data/home.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {
  news : any[] = [];
  i ;
  iterator = [];
  admin : boolean = false;
  categoryId = 1;
  newsCreatoruserId : any;
  responsse_status = 0;
  constructor(private homeService : HomeService, private basicAuthService : BasicAuthService) { 
    this.responsse_status = 0;
    this.admin = false;
    if(basicAuthService.isUserLoggedIn()) {
      this.newsCreatoruserId = this.basicAuthService.getAuthenticatedUserId();
      if(basicAuthService.isAdmin() === 'true') {
        this.admin = true;
      }
    }
  }

  ngOnInit(): void {
    this.getAllOutsideBhopalEvents();
  }
  getAllOutsideBhopalEvents() {
    this.homeService.getUpdate(this.categoryId).subscribe(
      res => { 
        this.news = res
        for(let i = 0; i< this.news.length; i++) {         
          this.news[i].photo = 'data:image/jpeg;base64,' + this.news[i].photo;
          this.news[i].user_profile_photo = 'data:image/jpeg;base64,' + this.news[i].user_profile_photo;
          this.news[i].createDate = this.news[i].createDate.split("-").reverse().join("-");
        }
      for(this.i = 0; this.i< this.news.length; this.i = this.i + 3) 
        this.iterator.push(this.i);
        if(this.news.length == 0)
          this.responsse_status = 1;
        else if(this.news.length > 0)
          this.responsse_status = 2;
        else
        this.responsse_status = 3;
      }
    );;
  }
  executeDeleteNews(newsId) {
    document.querySelector('#newsEventCard-' + newsId).classList.toggle('hidden');
    document.querySelector('#smallDeviceNewsEventCard-' + newsId).classList.toggle('hidden');
      this.homeService.executeDeleteNews(newsId).subscribe(
        () => {
            this.getAllOutsideBhopalEvents
        }
      )
  }
  newsToggleImage(i){
    document.querySelector('#userProfileNews' + i).classList.toggle('hidden');
    document.querySelector('#imageNews' + i).classList.toggle('hidden');
    document.querySelector('#moreNews' + i).classList.toggle('hidden');
    document.querySelector('#lessNews' + i).classList.toggle('hidden');
  }
  newsToggleImageSmallDevice(i){
    document.querySelector('#imageSmallNews' + i).classList.toggle('hiddenSmallDevice');
    document.querySelector('#userProfileSmallNews' + i).classList.toggle('hiddenSmallDevice');
    document.querySelector('#moreSmallDeviceNews' + i).classList.toggle('hiddenSmallDevice');
    document.querySelector('#lessSmallDeviceNews' + i).classList.toggle('hiddenSmallDevice');
  }

}
