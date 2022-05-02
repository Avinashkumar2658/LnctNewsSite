import { Component, OnInit } from '@angular/core';
import { HtmlEditorService, ImageService, LinkService, TableService, ToolbarService } from '@syncfusion/ej2-angular-richtexteditor';
import { HomeService } from 'src/app/service/data/home.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';

@Component({
  selector: 'app-college-event',
  templateUrl: './college-event.component.html',
  styleUrls: ['./college-event.component.css']
})
export class CollegeEventComponent implements OnInit {
  eventInLNCT : any[] = [];
  i ;
  iterator = [];
  admin : boolean = false;
  categoryId = 2;
  lnctEventCreatoruserId : any;
  responsse_status = 0;
  constructor(private homeService : HomeService, private basicAuthService : BasicAuthService) { 
    this.responsse_status = 0;
    this.admin = false;
    if(basicAuthService.isUserLoggedIn()) {
      this.lnctEventCreatoruserId = this.basicAuthService.getAuthenticatedUserId();
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
        this.eventInLNCT = res
        for(let i = 0; i< this.eventInLNCT.length; i++) {         
          this.eventInLNCT[i].photo = 'data:image/jpeg;base64,' + this.eventInLNCT[i].photo;
          this.eventInLNCT[i].user_profile_photo = 'data:image/jpeg;base64,' + this.eventInLNCT[i].user_profile_photo;
          this.eventInLNCT[i].createDate = this.eventInLNCT[i].createDate.split("-").reverse().join("-");
          this.eventInLNCT[i].startDate = this.eventInLNCT[i].startDate.split("-").reverse().join("-")
          this.eventInLNCT[i].endDate = this.eventInLNCT[i].endDate.split("-").reverse().join("-")
        }
      for(this.i = 0; this.i< this.eventInLNCT.length; this.i = this.i + 3) 
        this.iterator.push(this.i);
        if(this.eventInLNCT.length == 0)
          this.responsse_status = 1;
        else if(this.eventInLNCT.length > 0)
          this.responsse_status = 2;
        else
        this.responsse_status = 3;
      }
    );;
  }
  executeDeleteNews(newsId) {
    document.querySelector('#lnctEventCard-' + newsId).classList.toggle('hidden');
    document.querySelector('#smallDeviceLnctEventCard-' + newsId).classList.toggle('hidden');
      this.homeService.executeDeleteNews(newsId).subscribe(
        () => {
            this.getAllOutsideBhopalEvents
        }
      )
  }
  lnctEventToggleImage(i){
    document.querySelector('#userProfileLnctEvent' + i).classList.toggle('hidden');
    document.querySelector('#imageLnctEvent' + i).classList.toggle('hidden');
    document.querySelector('#moreLnctEvent' + i).classList.toggle('hidden');
    document.querySelector('#lessLnctEvent' + i).classList.toggle('hidden');
  }
  lnctEventToggleImageSmallDevice(i){
    document.querySelector('#imagesmallLnctEvent' + i).classList.toggle('hiddenSmallDevice');
    document.querySelector('#userProfileSmallDeviceLnctEvent' + i).classList.toggle('hiddenSmallDevice');
    document.querySelector('#moreSmallDeviceLnctEvent' + i).classList.toggle('hiddenSmallDevice');
    document.querySelector('#lessSmallDeviceLnctEvent' + i).classList.toggle('hiddenSmallDevice');
  }

}
