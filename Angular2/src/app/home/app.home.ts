import { Component } from '@angular/core';
import { Proyecto } from '../clases';
import {UserService} from '../app.user.service';


@Component({
  selector: 'home',
  template :'Home',
  templateUrl: './app.home.html',
  styleUrls: ['./app.home.css'],
})
export class Home {
  title = 'Proyectos';
  username = 'USERNAME AUX'
  proyectos : Proyecto[];
  
  constructor(private userService: UserService){}
  
  ngOnInit(){
      this.getProyectos();
  }
  
 // Aca en vez de 0 se debe enviar el id del usuario loggeado
  getProyectos():void{ this.proyectos = this.userService.getProyectos(0);}
  
}
