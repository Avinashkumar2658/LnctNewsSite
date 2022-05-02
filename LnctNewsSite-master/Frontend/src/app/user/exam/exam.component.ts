import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reply, ReplyCommentResponse, Comment } from 'src/app/datautil';
import { CollegeEventService } from 'src/app/service/data/college-event.service';
import { CommentService } from 'src/app/service/data/comment.service';
import { ReplyService } from 'src/app/service/data/reply.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';
import { LoginComponent } from 'src/app/account/login/login.component';
import { ModalService } from 'src/app/service/modal/modal.service';
import { HomeService } from 'src/app/service/data/home.service';
import { ExamService } from 'src/app/service/data/exam.service';
@Component({
  selector: 'app-exam',
  templateUrl: './exam.component.html',
  styleUrls: ['./exam.component.css']
})
export class ExamComponent implements OnInit {
  semesters = [1, 2, 3, 4, 5, 6, 7, 8]
  semester : any = this.semesters[0];
  exam_updates : any[] = [];
  user_comment:Comment;
  answers :any[];
  commentResponse: ReplyCommentResponse[] = [];
  replyResponse: ReplyCommentResponse[] = [];
  user_reply:Reply;
  retrieveResonses: any[] = [];
  loginComponent : any;
  examEventCreatoruserId : any;
  spinner_status = 3;
  responsse_status = 2;
  admin : boolean = false;
    constructor(private examService : ExamService , private homeService : HomeService  , private router : Router, private modalService : ModalService  
     , private basicAuthService: BasicAuthService, private commentService: CommentService, private replyService : ReplyService) { 
      this.loginComponent = new LoginComponent(this.router, this.modalService, this.basicAuthService);
      this.user_comment = new Comment(0, '', basicAuthService.getAuthenticatedUserId(), 0, 0);
      this.user_reply = new Reply(0, '', basicAuthService.getAuthenticatedUserId(), 0);
      this.admin = false;
      if(basicAuthService.isUserLoggedIn()) {
        this.examEventCreatoruserId = this.basicAuthService.getAuthenticatedUserId();
        if(basicAuthService.isAdmin() === 'true') {
          this.admin = true;
        }
      }
    }

    executeDeleteExamMaterial(newsId) {
      document.querySelector('#examNotes-' + newsId).classList.toggle('hidden');
      this.homeService.executeDeleteLargeNews(newsId).subscribe(
        () => {
            
        }
      )
  }

  ngOnInit(): void {
    this.executeUpdate(1)
  }
  executeUpdate(value) {
    this.responsse_status = 0;
    this.exam_updates = [];
    this.examService.executeExamUpdate(value).subscribe(
     res => {
          this.responsse_status = 3;
          this.exam_updates = res;
          for(let i = 0; i< this.exam_updates.length; i++) {   
            this.exam_updates[i].profile_photo= 'data:image/jpeg;base64,' + this.exam_updates[i].profile_photo;
            this.exam_updates[i].date = this.exam_updates[i].date.split("-").reverse().join("-")
         }
         if(this.exam_updates.length == 0)
            this.responsse_status = 1;
      }
    ) ;
  }


 
     
  saveComment(answerId, commentForm) {
    if(!(this.basicAuthService.isUserLoggedIn())) {
      this.loginComponent.openModal("custom-modal-1");
      return false;
    }
    this.spinner_status = 1;
    this.user_comment.largeNewsId = answerId;
    this.commentService.executeSaveLargeNewsComment(this.user_comment).subscribe(
      () => {
        this.spinner_status = 3;
        commentForm.reset();
        this.showComment(answerId);
        this.user_comment = new Comment(0, '', this.basicAuthService.getAuthenticatedUserId(), 0, 0);
      }
    );
  }
  showComment(answerId) {
    this.retrieveResonses = [];
    this.commentResponse = [];
    this.commentService.executeGetLargeNewsComment(answerId).subscribe(
     res => {
      this.retrieveResonses = res
      for(let res of this.retrieveResonses) {        
        res.userImage = 'data:image/jpeg;base64,' + res.userImage;
        this.commentResponse.push(new ReplyCommentResponse(res.commentId, res.userId, res.userImage, res.userName, res.present_profile, res.comment, res.commentDate.split("-").reverse().join("-")));
      }
     } 
    );  
  }

  saveReply(commentId, replyForm) {
    if(!(this.basicAuthService.isUserLoggedIn())) {
      this.loginComponent.openModal("custom-modal-1");
      return false;
    }
    this.spinner_status = 0;
    this.user_reply.commentId = commentId;
    this.replyService.executeSaveReply(this.user_reply).subscribe(
      () => {
        this.spinner_status = 3;
        replyForm.reset();
        this.showReply(commentId);
        this.user_reply = new Reply(0, '', this.basicAuthService.getAuthenticatedUserId(), 0);
      }
    );
  }
  showReply(commentId) {
    this.replyResponse = []
    this.retrieveResonses = []
    this.replyService.executeGetReply(commentId).subscribe(
     res => {
      this.retrieveResonses = res
      for(let res of this.retrieveResonses) {        
        res.userImage = 'data:image/jpeg;base64,' + res.userImage;
        this.replyResponse.push(new ReplyCommentResponse(res.commentId, res.userId, res.userImage, res.userName, res.present_profile, res.reply, res.replyDate.split("-").reverse().join("-")));
      }
     } 
    );
  }  
}
