import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { Answer, Comment, Reply, ReplyCommentResponse } from 'src/app/datautil';
import { AnswerService } from 'src/app/service/data/answer.service';
import { CommentService } from 'src/app/service/data/comment.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';
import { ReplyService } from 'src/app/service/data/reply.service'
import { LoginComponent } from 'src/app/account/login/login.component';
import { ModalService } from 'src/app/service/modal/modal.service';
@Component({
  selector: 'app-answer',
  templateUrl: './answer.component.html',
  styleUrls: ['./answer.component.css']
})
export class AnswerComponent implements OnInit {

  questionId : number ;
  answer: Answer;
  user_comment:Comment;
  answers :any[];
  commentResponse: ReplyCommentResponse[] = [];
  replyResponse: ReplyCommentResponse[] = [];
  user_reply:Reply;
  retrieveResonses: any[] = [];
  loginComponent : any;
  spinner_status = 3;
  responsse_status
  constructor(private location : Location, private route: ActivatedRoute, private ansewrService : AnswerService, 
    private basicAuthService: BasicAuthService, private commentService: CommentService, private replyService : ReplyService
    , private router: Router, private modalService : ModalService) { 
    this.questionId = this.route.snapshot.params['id'];
    this.answer = new Answer(0, '' , new Date(), 0, this.questionId);
    this.user_comment = new Comment(0, '', basicAuthService.getAuthenticatedUserId(), 0, 0);
    this.user_reply = new Reply(0, '', basicAuthService.getAuthenticatedUserId(), 0);
    this.loginComponent = new LoginComponent(this.router, this.modalService, this.basicAuthService);
    this.showAnswer();
  }

   

  ngOnInit(): void {
  }
  showAnswer() {
    this.ansewrService.executeFindAnswer(this.questionId).subscribe(
     responses => {
        this.answers = responses;
        if(responses.length == 0)
          this.responsse_status = 1
        for(let i = 0; i< this.answers.length; i++) {
          this.answers[i].user.profilePhoto = 'data:image/jpeg;base64,' + this.answers[i].user.profilePhoto;
          this.answers[i].createDate = this.answers[i].createDate.split("-").reverse().join("-")
       }
    }
    );
  }

  saveComment(answerId, commentForm) {
    if(!(this.basicAuthService.isUserLoggedIn())) {
      this.loginComponent.openModal("custom-modal-1");
      return false;
    }
    this.spinner_status = 1;
    this.user_comment.answerId = answerId;
    this.commentService.executeSaveComment(this.user_comment).subscribe(
      () => {
        this.spinner_status = 3;
        commentForm.reset();
        this.showComment(answerId);

      }
    );
  }
  showComment(answerId) {
    this.retrieveResonses = [];
    this.commentResponse = [];
    this.commentService.executeGetComment(answerId).subscribe(
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
  goback() : void {
    this.location.back();
  }

}
