import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
//import {of} from 'rxjs/observable/of';
import {HttpClientModule, HttpHeaders } from '@angular/common/http';

import {Usuario} from './clases';
import {Proyecto} from './clases';
import { PROYECTOS } from './clases';
//PARA PRUEBA
const USUARIOS : Usuario[] = [
                              {id: 10,
                                  username: 'usuario1',
                                  nombre : 'nombre1',
                                  apellido : 'apellido1',
                                  mail : 'mail1@hotmail.com'
                                  }
                                ];   

@Injectable()
export class UserService{

    constructor(private http: HttpClientModule){}
    
    getUsuarios(): Usuario[]{ return  USUARIOS } 
    
    getProyectos(id : number): Proyecto[]{return PROYECTOS}
    
    //getProyectos(id:number): Observable<Proyecto[]>{}
}