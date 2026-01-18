import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BienvenidaComponent } from './pages/bienvenida/bienvenida.component';
import { GenerarComponent } from './pages/generar/generar.component';
import { CargarComponent } from './pages/cargar/cargar.component';
import { EstructuraComponent } from './pages/estructura/estructura.component';

const routes: Routes = [
  {
    path: 'home',
    component: BienvenidaComponent,
    pathMatch: 'full'
  },
  {
    path: 'estructura',
    component: EstructuraComponent
  },
  {
    path: 'generar',
    component: GenerarComponent
  },
  {
    path: 'cargar',
    component: CargarComponent
  },
  {
    path: '**',
    redirectTo: 'home'
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
