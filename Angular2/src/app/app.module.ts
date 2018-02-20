import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';


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
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
