import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {  LargeNews, News, Question } from '../datautil';
import { PostService } from '../service/data/post.service';
import { BasicAuthService } from '../service/http/basic-auth.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  url: string = "";
  news : News;
  question : Question;
  largeNews : LargeNews;
  selectedFiles: FileList;
  progressInfos = [];
  details : any[] = [];
  id : number
  link : any;
  i = 1;
  message: string;
  formData:  FormData = new FormData();
  semesters = [1, 2, 3, 4, 5, 6, 7, 8]
  years = [1, 2, 3, 4]
  selectFiles(event): void {
    this.progressInfos = [];
    this.selectedFiles = null;
  }
  
  constructor(
    private postService : PostService, private basicAuthService : BasicAuthService, private router : Router,
  ) { 
     this.news = new News(0, '', '', null, null,  0, basicAuthService.getAuthenticatedUserId(),'', null);
     this.question = new Question(0, 0, '');
     this.largeNews = new LargeNews(0, '', '', 0, 0, 0, basicAuthService.getAuthenticatedUserId(), '', null);
     this.news.categoryId = 9;
     let list = new DataTransfer();
     let file = new File(["abc"], "filename.jpg");
     list.items.add(file);    
     let myFileList = list.files;
     this.selectedFiles= myFileList;
     this.largeNews.year = 1;
     this.largeNews.semester = 1;
     this.id = 9
  }

  refreshAllCategories() {
    this.postService.executeFindAllCategories().subscribe(
      response => {
        this.details = response; 
      });
  }

  ngOnInit(): void {
    this.refreshAllCategories();
  }
  top() {
    window.scrollTo(0, 0)
  }

  changeValue(e){
    this.id = e.target.value  
  }

  savePost(id, postNews) {
    this.i = 0;
    if(id == 1 || id == 2 || id == 3 || id == 4 || id == 5 || id == 6) {
      this.news.url = this.url;
      this.postService.executeSaveNews(this.news,   this.selectedFiles[0]).subscribe(
    
        () => {
        this.i = 2;
        postNews.reset()
        this.message = "post successfully";
        },
        error => {
          this.top();
          this.i = 3
          this.message = "not post successfully";
        }
      );
    } 
    else if(id == 7 || id == 8 || id == 9) {
      if((id == 8 || id == 9) && (this.basicAuthService.isAdmin() === 'false')) {
        alert("       you are not login as admin")
        this.i = 20;
        return;  
      }
      this.largeNews.categoryId = id;
      this.largeNews.url = this.url;
      this.postService.executeSaveLargeNews(this.largeNews , this.selectedFiles[0] ).subscribe(
    
        () => {
          this.i = 2;
          postNews.reset()
          this.top();
          this.message = "post successfully";
        },
        error => {
          this.top();
          this.i = 3
          this.message = "not post successfully";
        }
      );
    }
    else if(id == 10) { 
      this.postService.executeSaveQuestion(this.question).subscribe(
        () => {
          this.i = 2;
          postNews.reset()
          this.top();
          this.message = "post successfully";
        },
        error => {
          this.top();
          this.i = 3
          this.message = "not post successfully";
        }
      );
    } 
  }

  onChange(event) {
    this.news.photo = event.srcElement.files; 
    this.largeNews.file = event.srcElement.files;
    this.selectedFiles = event.srcElement.files
  }

  onItemChange(value){
    console.log(" Value1 is : ", this.link );
  }
 

}



