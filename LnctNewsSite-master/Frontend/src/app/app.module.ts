import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AccountModule } from './account/account.module';
import { AlumniComponent } from './visitor/alumni/alumni.component';
import { ClassNotesComponent } from './user/class-notes/class-notes.component';
import { ExamComponent } from './user/exam/exam.component';
import { TnpComponent } from './user/tnp/tnp.component';
import { BlanksComponent } from './visitor/blanks/blanks.component';
import { CollegeEventComponent } from './visitor/college-event/college-event.component';
import { FooterComponent } from './visitor/footer/footer.component';
import { HeaderComponent } from './visitor/header/header.component';
import { LeftCarouselComponent } from './visitor/left-carousel/left-carousel.component';
import { RightCarouselComponent } from './visitor/right-carousel/right-carousel.component';
import { BhopalComponent } from './visitor/bhopal/bhopal.component';
import { OutsideBhopalComponent } from './visitor/outside-bhopal/outside-bhopal.component';
import { QuotesComponent } from './visitor/quotes/quotes.component';
import { SomeMessageComponent } from './visitor/some-message/some-message.component';
import { PostComponent } from './post/post.component';
import { RichTextEditorAllModule } from '@syncfusion/ej2-angular-richtexteditor';
import { EditorComponent } from './repeat/editor/editor.component';
import { QuestionComponent } from './visitor/question/question.component';
import { AnswerComponent } from './repeat/answer/answer.component';
import { CarouselLoaderComponent } from './carousel-loader/carousel-loader.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './user/profile/profile.component';
import { EnlargeComponent } from './repeat/enlarge/enlarge.component';
import { UserPostDetailComponent } from './user-post-detail/user-post-detail.component';
import { SocialLoginModule } from 'angularx-social-login';
import { NewsComponent } from './visitor/news/news.component';



@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    BlanksComponent,
    AlumniComponent,
    ExamComponent,
    TnpComponent,
    ClassNotesComponent,
    CollegeEventComponent,
    RightCarouselComponent,
    LeftCarouselComponent,
    HeaderComponent,
    CarouselLoaderComponent,
    BhopalComponent,
    OutsideBhopalComponent,
    QuotesComponent,
    SomeMessageComponent,
    PostComponent,
    EditorComponent,
    QuestionComponent,
    AnswerComponent,
    HomeComponent,
    ProfileComponent,
    EnlargeComponent,
    UserPostDetailComponent,
    NewsComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    BrowserAnimationsModule,
    AccountModule,
    SocialLoginModule,
    RichTextEditorAllModule
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
