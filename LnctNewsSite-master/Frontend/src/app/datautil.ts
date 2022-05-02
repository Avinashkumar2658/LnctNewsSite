import { THIS_EXPR } from "@angular/compiler/src/output/output_ast";

export class User {
    constructor(
      public userId: number,
      public userName: String,
      public enrollmentNo : String,
      public password: String,
      public emailId: String,
      public userMode : number,
      public enabled: boolean,
      public isAdmin: boolean,
      public someThingAboutYourSelf : string,
      public presentProfile : string,
      public inspirationWord : string,
      public profilePhoto : File
    ) { }
    public getUserId(): number {
      return this.userId;
    }
    public getUserName(): String {
      return this.userName;
    }
    public getEnrollmentId() : String {
      return this.enrollmentNo;
    }
    public getPassword(): String {
      return this.password;
    }
    public getEmailId(): String {
      return this.emailId;
    }
    public getUserMode():number {
        return this.userMode;
    }
    public getIsAdmin(): boolean {
      return this.isAdmin;
    }
    public getSomeThingAboutYourSelf() : string {
        return this.someThingAboutYourSelf
    }
    public getProfilePhoto() : File {
        return this.profilePhoto;
    }
    public getPresentProfile() : string {
        return this.presentProfile;
    }
    public getInspirationWord() : string {
        return this.inspirationWord;
    }
    public isEnabled() : boolean {
        return this.enabled;
    }
   
  }

export class News {
    constructor(
    public newsId : number,
	public  newsHeading : String,
	public  detail :String,
	public  startDate :Date,
	public endDate : Date,
	public  categoryId : number,	
    public  userId : number,
    public url: String,
    public photo: File
    
    ) {}

    public getNewsId() : number {
        return this.newsId;
    }

    public getNewsHeading() : String {
        return this.newsHeading;
    }
    public getNews() : String {
        return this.detail;
    }
    public getStartDate() : Date {
        return this.startDate;
    }
    public getEndDate() : Date {
        return this.endDate;
    }
    
    public getCategory() : number {
        return this.categoryId;
    }
    public getUserId() : number {
        return this.userId;
    }

    public getPhoto() : File {
        return this.photo;
    }
    public getUrl():String {
        return this.url;
    }
    
}

export class LargeNews {
    constructor(
    public largeNewsId : number,
	public  largeNewsHeading : string,
	public  detail :String,
	public  year :number,
	public semester : number,
	public  categoryId : number,	
    public  userId : number,
    public url : string,
    public file: File
    ) {}

    public getLargeNewsId() : number {
        return this.largeNewsId;
    }

    public getLargeNewsHeading() : string {
        return this.largeNewsHeading;
    }
    public getDetail() : String {
        return this.detail;
    }
    public getYear() : number {
        return this.year;
    }
    public getSemester() : number {
        return this.semester;
    }
    
    public getCategoryId() : number {
        return this.categoryId;
    }
    public getUserId() : number {
        return this.userId;
    }

    public getFile() : File {
        return this.file;
    }
    public getUrl() :string {
        return this.url;
    }
    
}

export class Question {
    constructor(
        public questionId :number,
        public userId : number,
        public question : string
    ){}
    public getQuestionId() : number {
        return this.questionId;
    }
    public getQuestion() : string {
        return this.question;
    }
    public getUserId() {
        return this.userId;
    }
}

export class Answer {
    constructor(
        public answerId : number,
        public answer : String,
        public createDate : Date,
        public userId : number,
        public questionId : number
    ){}
    public getAnswerId() : number {
        return this.answerId;
    }
    public getAnswer() : String {
        return this.answer;
    }
    public getCreateDate() : Date {
        return this.createDate;
    }
    public getUserId() : number {
        return this.userId;
    }
    public getQuestionId() : number {
        return this.questionId;
    }


}
export class Comment {
    constructor(
    public commentId:  number,
	public comment:string,
	public  userId : number,
	public answerId : number,
    public largeNewsId : number

    ){}
    public getCommentId() : number {
        return this.commentId;
    }
    public getComment() : string {
        return this.comment;
    }
    public getUserId() : number {
        return this.userId;
    }
    public getAnswerId(): number {
        return this.answerId;
    }
    public getLargeNewsId(): number {
        return this.largeNewsId;
    }

}

export class Reply {
    constructor(
    public replyId : number,
	public reply : string,
	public userId : number,
	public commentId : number
    ){}

    public getReplyId():number {
        return this.replyId;
    }
    public getReply(): string {
        return this.reply;
    }
    public getUserId(): number {
        return this.userId;
    }
    public getCommentId():number {
        return this.commentId;
    }
}
export class ReplyCommentResponse {
    constructor(
    public commentId : number,
    public userId : number,
	public user_profile : string,
	public userName : string,
    public present_profile : string,
	public commentReply : string,
    public date : Date
    ){}
    public getCommentId() : number {
        return this.commentId;
    }
    
    public getUserId():number {
        return this.userId;
    }
    public getPresent_profile():string{
        return this.present_profile;
    }
    public userProfile(): string {
        return this.user_profile;
    }
    public getUserName(): string {
        return this.userName;
    }
    public getCommentReply(): string {
        return this.commentReply;
    }
    public getDate() : Date {
        return this.date;
    }
}
export class ResetPassword {
    constructor(
        public emailId : String,
        public password : String
    ) {}
    public getEmailId() : String {
        return this.emailId;
    }
    public getPassword() : String {
        return this.password;
    }
}