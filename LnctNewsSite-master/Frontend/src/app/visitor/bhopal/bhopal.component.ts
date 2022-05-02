import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/service/data/home.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';

@Component({
  selector: 'app-bhopal',
  templateUrl: './bhopal.component.html',
  styleUrls: ['./bhopal.component.css']
})
export class BhopalComponent implements OnInit {
  eventInBhopal : any[] = [];
  i ;
  iterator = [];
  admin : boolean = false;
  categoryId = 3;
  bhopalEventCreatoruserId : any;
  responsse_status = 0;
  constructor(private homeService : HomeService, private basicAuthService : BasicAuthService) { 
    this.responsse_status = 0;
    this.admin = false;
    if(basicAuthService.isUserLoggedIn()) {
      this.bhopalEventCreatoruserId = this.basicAuthService.getAuthenticatedUserId();
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
        this.eventInBhopal = res
        for(let i = 0; i< this.eventInBhopal.length; i++) {         
          this.eventInBhopal[i].photo = 'data:image/jpeg;base64,' + this.eventInBhopal[i].photo;
          this.eventInBhopal[i].user_profile_photo = 'data:image/jpeg;base64,' + this.eventInBhopal[i].user_profile_photo;
          this.eventInBhopal[i].createDate = this.eventInBhopal[i].createDate.split("-").reverse().join("-");
          this.eventInBhopal[i].startDate = this.eventInBhopal[i].startDate.split("-").reverse().join("-")
          this.eventInBhopal[i].endDate = this.eventInBhopal[i].endDate.split("-").reverse().join("-")
        }
      for(this.i = 0; this.i< this.eventInBhopal.length; this.i = this.i + 3) 
        this.iterator.push(this.i);
        if(this.eventInBhopal.length == 0)
          this.responsse_status = 1;
        else if(this.eventInBhopal.length > 0)
          this.responsse_status = 2;
        else
        this.responsse_status = 3;
      }
    );;
  }
  executeDeleteNews(newsId) {
    document.querySelector('#bhopalEventCard-' + newsId).classList.toggle('hidden');
    document.querySelector('#smallDeviceBhopalEventCard-' + newsId).classList.toggle('hidden');
      this.homeService.executeDeleteNews(newsId).subscribe(
        () => {
            this.getAllOutsideBhopalEvents
        }
      )
  }
  EventInBhopalToggleImage(i){
    document.querySelector('#userProfileEventInBhopal' + i).classList.toggle('hidden');
    document.querySelector('#imageEventInBhopal' + i).classList.toggle('hidden');
    document.querySelector('#moreEventInBhopal' + i).classList.toggle('hidden');
    document.querySelector('#lessEventInBhopal' + i).classList.toggle('hidden');
  }
  EventInBhopalToggleImageSmallDevice(i){
    document.querySelector('#imagesmallEventInBhopal' + i).classList.toggle('hiddenSmallDevice');
    document.querySelector('#userProfileSmallEventInBhopal' + i).classList.toggle('hiddenSmallDevice');
    document.querySelector('#moreSmallDeviceEventInBhopal' + i).classList.toggle('hiddenSmallDevice');
    document.querySelector('#lessSmallDeviceEventInBhopal' + i).classList.toggle('hiddenSmallDevice');
  }

}
