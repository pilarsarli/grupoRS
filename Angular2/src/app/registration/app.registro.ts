import { Component } from '@angular/core';
import {HttpClientModule, HttpHeaders } from '@angular/common/http';

import {UserService} from '../app.user.service';
import {Usuario} from '../clases';

@Component({
  selector: 'registro',
  template :'Registro',
  templateUrl: './app.registro.html',
  styleUrls: ['./app.registro.css'],
  providers:[UserService]
})
export class Registro {
  title = 'Registrarse';
  constructor(private http: HttpClientModule){}
  
  registrar(){}
}
