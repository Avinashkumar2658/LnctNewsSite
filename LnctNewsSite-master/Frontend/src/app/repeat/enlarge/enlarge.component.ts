import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HomeService } from 'src/app/service/data/home.service';

@Component({
  selector: 'app-enlarge',
  templateUrl: './enlarge.component.html',
  styleUrls: ['./enlarge.component.css']
})
export class EnlargeComponent {
categoryId : number;
news_id : number;
news: any;
file_update : any;
response_status = 0;
constructor(private route: ActivatedRoute, private homeService : HomeService, private router: Router) {
  this.categoryId = this.route.snapshot.params['categoryId'];
  this.news_id = this.route.snapshot.params['newsId'];
  this.response_status = 0;
  if(this.categoryId == 1 || this.categoryId == 2 || this.categoryId == 3 || this.categoryId == 4 || this.categoryId == 5 || this.categoryId == 6) 
    this.executeNewsByNewsId();
  else if(this.categoryId == 7 || this.categoryId == 8 || this.categoryId == 9 || this.categoryId == 10)
      this.executeLargeNewsByLargeNewsId();
} 
  executeNewsByNewsId() {
    this.response_status = 0;
    this.homeService.getNewsByNewsId(this.news_id).subscribe(
      (res) => {
        this.news = res;
        this.news.createDate = this.news.createDate.split("-").reverse().join("-")
        this.news.startDate = this.news.startDate.split("-").reverse().join("-")
        this.news.endDate = this.news.endDate.split("-").reverse().join("-")
        this.news.photo = 'data:image/jpeg;base64,' + this.news.photo;
        this.response_status = 1;
      }
    )
  }
  executeLargeNewsByLargeNewsId() {
    this.response_status = 0;
    this.homeService.getFileById(this.news_id).subscribe(
      (res) => {
        this.file_update = res;
        this.file_update.date = this.file_update.date.split("-").reverse().join("-")
        this.response_status = 2;
      }
    )
  }
  executeDeleteNews() {
    this.homeService.executeDeleteNews(this.news_id).subscribe(
      () => {
        this.router.navigate(['user_post_update']);
      }
    )
  }
  executeDeleteLargeNews() {
    this.homeService.executeDeleteLargeNews(this.news_id).subscribe(
      () => {
        this.router.navigate(['user_post_update']);
      }
    )
  }
}
