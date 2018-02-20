import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
//import {of} from 'rxjs/observable/of';
import {HttpClient, HttpHeaders } from '@angular/common/http';

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
    private url = '';
    private newUserUrl ="";
    constructor(private http: HttpClient){}
    
    getUsuarios(): Usuario[]{ return  USUARIOS } 
    
    getProyectos(id : number): Proyecto[]{return PROYECTOS}
    
    //getProyectos(id:number): Observable<Proyecto[]>{}
    
    crearUsuario(user : Usuario):Observable<any>{
        let json = JSON.stringify(user);
        let params = "json="+json;
        let headers = new HttpHeaders().set('Context-Type', this.newUserUrl);
        return this.http.post(this.url+'usuarios', params, {headers:headers});
    }
}