import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule } from '@angular/common/http';

import {UserService} from './app.user.service';
import { AppComponent } from './app.component';
import { Login } from './login/app.login';
import { Registro } from './registration/app.registro';
import { Home } from './home/app.home';


@NgModule({
  declarations: [
    AppComponent,
    Login,
    Registro,
    Home
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
