import { Component } from '@angular/core';
import {MenuItem} from 'primeng/api';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  public items: MenuItem[]= [
    {label: 'Home', routerLink:'home', routerLinkActiveOptions:{exact: true}},
    {label: 'Estructura', routerLink:'estructura'},
    {label: 'Generar', routerLink:'generar'},
    {label: 'Cargar', routerLink:'cargar'}
];


}
