import { Component } from '@angular/core';

@Component({
  selector: 'login',
  template :'Login',
  templateUrl: './app.login.html',
  styleUrls: ['./app.login.css']
})
export class Login {
  title = 'Inicio de sesión';
  username : string;
  password : string;
  login(){}
}
