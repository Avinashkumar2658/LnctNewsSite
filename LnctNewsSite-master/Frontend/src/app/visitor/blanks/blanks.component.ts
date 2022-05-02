import { Component, OnInit, ViewChild } from '@angular/core';
import { NgbCarousel, NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';
import { FrontService } from 'src/app/service/data/front.service';

@Component({
  selector: 'app-blanks',
  templateUrl: './blanks.component.html',
  styleUrls: ['./blanks.component.css'],
  providers: [NgbCarouselConfig] 
})
export class BlanksComponent implements OnInit {
  constructor(public frontService : FrontService) {
  }

  events : any[] = [];
  response_status =   5;

  ngOnInit(): void {
    this.getAllUpdate();
 }
 
  @ViewChild('carousel', {static : true}) carousel: NgbCarousel;

  getAllUpdate() {
    this.response_status = 0;
    this.frontService.getAllImage().subscribe(
      res => {
        this.events = res
        for(let i = 0; i< this.events.length; i++) {
          this.events[i].photo =     'data:image/jpeg;base64,' +    this.events[i].photo; 
          this.events[i].startDate = this.events[i].startDate.split("-").reverse().join("-");
          this.events[i].endDate = this.events[i].endDate.split("-").reverse().join("-");
        }
        this.response_status = 6;
        if(this.events.length == 0)
          this.response_status = 1
      }
    );;
  }
  
  
  
  startCarousel() {
    this.carousel.cycle();
  }
  
  pauseCarousel() {
    this.carousel.pause();
  }
  
  moveNext() {
    this.carousel.next();
  }
  
  getPrev() {
    this.carousel.prev();
  }
  
  goToSlide(slide) {
    this.carousel.select(slide);
  }
  
  
  
  
}
