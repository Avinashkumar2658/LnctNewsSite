import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/service/data/home.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';

@Component({
  selector: 'app-quotes',
  templateUrl: './quotes.component.html',
  styleUrls: ['./quotes.component.css']
})
export class QuotesComponent implements OnInit {
  quotes : any[] = [];
  i ;
  iterator = [];
  admin : boolean = false;
  categoryId = 6;
  quotesCreatoruserId : any;
  responsse_status = 0;
  constructor(private homeService : HomeService, private basicAuthService : BasicAuthService) { 
    this.responsse_status = 0;
    this.admin = false;
    if(basicAuthService.isUserLoggedIn()) {
      this.quotesCreatoruserId = this.basicAuthService.getAuthenticatedUserId();
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
        this.quotes = res
        for(let i = 0; i< this.quotes.length; i++) {         
          this.quotes[i].photo = 'data:image/jpeg;base64,' + this.quotes[i].photo;
          this.quotes[i].user_profile_photo = 'data:image/jpeg;base64,' + this.quotes[i].user_profile_photo;
          this.quotes[i].createDate = this.quotes[i].createDate.split("-").reverse().join("-");
        }
      for(this.i = 0; this.i< this.quotes.length; this.i = this.i + 3) 
        this.iterator.push(this.i);
        if(this.quotes.length == 0)
          this.responsse_status = 1;
        else if(this.quotes.length > 0)
          this.responsse_status = 2;
        else
        this.responsse_status = 3;
      }
    );;
  }
  executeDeleteNews(newsId) {
    document.querySelector('#quotesEventCard-' + newsId).classList.toggle('hidden');
    document.querySelector('#smallDeviceQuotesEventCard-' + newsId).classList.toggle('hidden');
      this.homeService.executeDeleteNews(newsId).subscribe(
        () => {
            this.getAllOutsideBhopalEvents
        }
      )
  }
  quotesToggleImage(i){
    document.querySelector('#userProfileQuotes' + i).classList.toggle('hidden');
    document.querySelector('#imageQuotes' + i).classList.toggle('hidden');
    document.querySelector('#moreQuotes' + i).classList.toggle('hidden');
    document.querySelector('#lessQuotes' + i).classList.toggle('hidden');
  }
  quotesToggleImageSmallDevice(i){
    document.querySelector('#imageSmallQuotes' + i).classList.toggle('hiddenSmallDevice');
    document.querySelector('#userProfileSmallQuotes' + i).classList.toggle('hiddenSmallDevice');
    document.querySelector('#moreSmallDeviceQuotes' + i).classList.toggle('hiddenSmallDevice');
    document.querySelector('#lessSmallDeviceQuotes' + i).classList.toggle('hiddenSmallDevice');
  }
}
