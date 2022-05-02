import { Component, OnInit } from '@angular/core';
import { BasicAuthService } from '../service/http/basic-auth.service';

@Component({
  selector: 'app-carousel-loader',
  templateUrl: './carousel-loader.component.html',
  styleUrls: ['./carousel-loader.component.css']
})
export class CarouselLoaderComponent implements OnInit {


  constructor(public basicauth : BasicAuthService) {
    
   }

  ngOnInit(): void {
  }

}
