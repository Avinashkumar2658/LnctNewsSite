import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PasswordResetComponent } from './account/password-reset/password-reset.component';
import { UserManagementComponent } from './account/user-management/user-management.component';
import { HomeComponent } from './home/home.component';
import { PostComponent } from './post/post.component';
import { AnswerComponent } from './repeat/answer/answer.component';
import { EnlargeComponent } from './repeat/enlarge/enlarge.component';
import { AdminGuardService } from './service/http/admin-guard.service';
import { RouteGuardService } from './service/http/route-guard.service';
import { UserPostDetailComponent } from './user-post-detail/user-post-detail.component';
import { ClassNotesComponent } from './user/class-notes/class-notes.component';
import { ExamComponent } from './user/exam/exam.component';
import { ProfileComponent } from './user/profile/profile.component';
import { TnpComponent } from './user/tnp/tnp.component';
import { AlumniComponent } from './visitor/alumni/alumni.component';
import { CollegeEventComponent } from './visitor/college-event/college-event.component';
import { QuestionComponent } from './visitor/question/question.component';


const accountModule = () => import('./account/account.module').then(x => x.AccountModule);


const routes: Routes = [
    {path: '', component:HomeComponent },
    {path: 'account', loadChildren: accountModule },
    {path:'tnp', component:TnpComponent},
    {path:'exam' ,component:ExamComponent},
    {path:'classnotes', component: ClassNotesComponent},
    {path:'collegeevent', component: CollegeEventComponent},
    {path:'post', component: PostComponent, canActivate: [RouteGuardService]},
    {path:'question', component : QuestionComponent},
    {path:'alumni', component:AlumniComponent},
    {path:'answer/:categoryId/:newsId', component:EnlargeComponent},
    {path:'answer/:id', component:AnswerComponent},
    {path:'admin/userManagement', component:UserManagementComponent, canActivate: [AdminGuardService]},
    {path:'user_post_update', component:UserPostDetailComponent, canActivate: [RouteGuardService]},
    { path: 'reset-password/:enrollmentNo/:token/:userId', component: PasswordResetComponent },
    {path: 'profile', component: ProfileComponent, canActivate: [RouteGuardService]},
    { path: '**', redirectTo: '' }
];
@NgModule({
    imports: [RouterModule.forRoot(routes , {useHash: true})],
    exports: [RouterModule]
})
export class AppRoutingModule { }