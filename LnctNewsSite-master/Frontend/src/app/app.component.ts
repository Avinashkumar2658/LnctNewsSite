import { Component, ViewEncapsulation } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BasicAuthService } from './service/http/basic-auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class AppComponent {
  title = 'Newssite';
   
   constructor(public basicAuth : BasicAuthService) { 
    basicAuth.setPageId('home')
  }

  ngOnInit(): void {
  }
}
