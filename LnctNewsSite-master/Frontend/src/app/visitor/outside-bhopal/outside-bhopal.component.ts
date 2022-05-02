import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/service/data/home.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';

@Component({
  selector: 'app-outside-bhopal',
  templateUrl: './outside-bhopal.component.html',
  styleUrls: ['./outside-bhopal.component.css']
})
export class OutsideBhopalComponent implements OnInit {
  eventsOutsideBhopal : any[] = [];
  i ;
  iterator = [];
  admin : boolean = false;
  categoryId = 4;
  responsse_status = 0;
  eventCreatoruserId : any;
  constructor(private homeService : HomeService, private basicAuthService : BasicAuthService) { 
    this.responsse_status = 0;
    this.admin = false;
    if(basicAuthService.isUserLoggedIn()) {
      this.eventCreatoruserId = this.basicAuthService.getAuthenticatedUserId();
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
        this.eventsOutsideBhopal = res
        for(let i = 0; i< this.eventsOutsideBhopal.length; i++) {         
          this.eventsOutsideBhopal[i].photo = 'data:image/jpeg;base64,' + this.eventsOutsideBhopal[i].photo;
          this.eventsOutsideBhopal[i].user_profile_photo = 'data:image/jpeg;base64,' + this.eventsOutsideBhopal[i].user_profile_photo;
          this.eventsOutsideBhopal[i].createDate = this.eventsOutsideBhopal[i].createDate.split("-").reverse().join("-");
          this.eventsOutsideBhopal[i].startDate = this.eventsOutsideBhopal[i].startDate.split("-").reverse().join("-")
          this.eventsOutsideBhopal[i].endDate = this.eventsOutsideBhopal[i].endDate.split("-").reverse().join("-")
        }
      for(this.i = 0; this.i< this.eventsOutsideBhopal.length; this.i = this.i + 3) 
        this.iterator.push(this.i);
        if(this.eventsOutsideBhopal.length == 0)
          this.responsse_status = 1;
        else if(this.eventsOutsideBhopal.length > 0)
          this.responsse_status = 2;
        else
        this.responsse_status = 3;
      }
    );;
  }
  executeDeleteNews(newsId) {
    document.querySelector('#outsideBhopalEventCard-' + newsId).classList.toggle('hidden');
    document.querySelector('#smallDeviceEventOutsideBhopal-' + newsId).classList.toggle('hidden');
      this.homeService.executeDeleteNews(newsId).subscribe(
        () => {
            this.getAllOutsideBhopalEvents
        }
      )
  }
  toggleImage(i){
    document.querySelector('#userProfile' + i).classList.toggle('hidden');
    document.querySelector('#image' + i).classList.toggle('hidden');
    document.querySelector('#more' + i).classList.toggle('hidden');
    document.querySelector('#less' + i).classList.toggle('hidden');
  }
  toggleImageSmallDevice(i){
    document.querySelector('#imagesmall' + i).classList.toggle('hiddenSmallDevice');
    document.querySelector('#userProfileSmall' + i).classList.toggle('hiddenSmallDevice');
    document.querySelector('#moreSmallDevice' + i).classList.toggle('hiddenSmallDevice');
    document.querySelector('#lessSmallDevice' + i).classList.toggle('hiddenSmallDevice');
  }
}
