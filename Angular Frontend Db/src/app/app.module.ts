import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { authInterceptorProviders } from './_helpers/auth.interceptor';
import {APP_BASE_HREF} from '@angular/common';
import { EmployeeService } from './_services/employee.service';
import { AddemployeeComponent } from './addemployee/addemployee.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSliderModule } from '@angular/material/slider';
import { MatTableModule } from '@angular/material/table';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { MessageService } from './_services/message.service';
import { NgxPaginationModule } from 'ngx-pagination';
import {MatNativeDateModule} from '@angular/material/core';
import { MaterialExampleModule } from './MODULE/material.module';
import { KekwComponent } from './kekw/kekw.component';




   
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent,
    AddemployeeComponent,
    EmployeeListComponent,
    KekwComponent,
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    CommonModule,
    BrowserAnimationsModule,
    MatPaginatorModule,
    MatSliderModule,
    MatTableModule,
    NgbModule,
    NgxPaginationModule,
    MatNativeDateModule,
    MaterialExampleModule
  ],

  providers: [authInterceptorProviders,  EmployeeService, MessageService ],
  // {provide: APP_BASE_HREF, useValue : '/' }
  
  bootstrap: [AppComponent]
})
export class AppModule { }






