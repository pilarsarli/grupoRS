import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { Login } from './login/app.login';
import { Registro } from './registration/app.registro';
import {AppComponent} from './app.component';
import { Home } from './home/app.home';
// Array con las rutas de este módulo. Ninguna funcional.
const routes: Routes = [
  {path: '', component: AppComponent},
  {path:'login', component: Login},
  {path:'registro', component: Registro},
  {path:'home', component:Home},
  { path: '**', redirectTo: '', pathMatch: 'full' }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  declarations:[],
  exports: [
    RouterModule // se importará desde el módulo padre
  ]
})
export class AppRoutingModule { }