import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { AccountRoutingModule } from './account-routing.module';
import { LayoutComponent } from './layout.component';

import { RegisterComponent } from './register/register.component';
import { ModalModule } from 'src/app/modal/modal.module';

import { LoginComponent } from './login/login.component';
import { ForgetPasswordComponent } from './forget-password/forget-password.component';
import { PasswordResetComponent } from './password-reset/password-reset.component';
import { UserManagementComponent } from './user-management/user-management.component';


@NgModule({
    imports: [
        CommonModule,
        ReactiveFormsModule,
        AccountRoutingModule,
        ModalModule,
        FormsModule

    ],
    declarations: [
        LayoutComponent,
        LoginComponent,
        RegisterComponent,
        ForgetPasswordComponent,
        PasswordResetComponent,
        UserManagementComponent,

    ],
    exports:[LoginComponent,
            RegisterComponent,
            ForgetPasswordComponent,
            PasswordResetComponent,
            UserManagementComponent
    ]
})
export class AccountModule {
 }