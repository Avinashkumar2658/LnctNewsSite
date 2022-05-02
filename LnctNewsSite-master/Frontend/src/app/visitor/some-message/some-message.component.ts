import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/service/data/home.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';

@Component({
  selector: 'app-some-message',
  templateUrl: './some-message.component.html',
  styleUrls: ['./some-message.component.css']
})
export class SomeMessageComponent implements OnInit {
  someMessageFromTopCeo : any[] = [];
  i ;
  iterator = [];
  admin : boolean = false;
  categoryId = 5;
  messageCreatoruserId: any
  responsse_status = 0;
  constructor(private homeService : HomeService, private basicAuthService : BasicAuthService) { 
    this.responsse_status = 0;
    this.admin = false;
    if(basicAuthService.isUserLoggedIn()) {
      this.messageCreatoruserId = this.basicAuthService.getAuthenticatedUserId();
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
        this.someMessageFromTopCeo = res
        for(let i = 0; i< this.someMessageFromTopCeo.length; i++) {         
          this.someMessageFromTopCeo[i].photo = 'data:image/jpeg;base64,' + this.someMessageFromTopCeo[i].photo;
          this.someMessageFromTopCeo[i].user_profile_photo = 'data:image/jpeg;base64,' + this.someMessageFromTopCeo[i].user_profile_photo;
          this.someMessageFromTopCeo[i].createDate = this.someMessageFromTopCeo[i].createDate.split("-").reverse().join("-");
        }
      for(this.i = 0; this.i< this.someMessageFromTopCeo.length; this.i = this.i + 3) 
        this.iterator.push(this.i);
        if(this.someMessageFromTopCeo.length == 0)
          this.responsse_status = 1;
        else if(this.someMessageFromTopCeo.length > 0)
          this.responsse_status = 2;
        else
        this.responsse_status = 3;
      }
    );;
  }
  executeDeleteNews(newsId) {
    document.querySelector('#messageEventCard-' + newsId).classList.toggle('hidden');
    document.querySelector('#smallDeviceMessageEventCard-' + newsId).classList.toggle('hidden');
      this.homeService.executeDeleteNews(newsId).subscribe(
        () => {
            this.getAllOutsideBhopalEvents
        }
      )
  }
  MesageToggleImage(i){
    document.querySelector('#userProfileMessage' + i).classList.toggle('hidden');
    document.querySelector('#imageMessage' + i).classList.toggle('hidden');
    document.querySelector('#moreMessage' + i).classList.toggle('hidden');
    document.querySelector('#lessMessage' + i).classList.toggle('hidden');
  }
  MessageToggleImageSmallDevice(i){
    document.querySelector('#imageSmallMessage' + i).classList.toggle('hiddenSmallDevice');
    document.querySelector('#userProfileSmallMessage' + i).classList.toggle('hiddenSmallDevice');
    document.querySelector('#moreSmallDeviceMessage' + i).classList.toggle('hiddenSmallDevice');
    document.querySelector('#lessSmallDeviceMessage' + i).classList.toggle('hiddenSmallDevice');
  }

}
