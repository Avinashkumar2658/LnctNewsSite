import { Component, OnInit, ViewChild } from '@angular/core';
import { NgbCarousel } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-left-carousel',
  templateUrl: './left-carousel.component.html',
  styleUrls: ['./left-carousel.component.css']
})
export class LeftCarouselComponent implements OnInit {

  images = [1, 2, 3].map(() => `https://picsum.photos/900/630?random&t=${Math.random()}`);
showNavigationArrows = true;
showNavigationIndicators = true;
pauseOnHover = true;

@ViewChild('mycarousel', {static : true}) carousel: NgbCarousel;

constructor() { }
ngOnInit() {}

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
