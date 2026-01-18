import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BienvenidaComponent } from './bienvenida/bienvenida.component';
import { CargarComponent } from './cargar/cargar.component';
import { EstructuraComponent } from './estructura/estructura.component';
import { GenerarComponent } from './generar/generar.component';
import {DropdownModule} from 'primeng/dropdown';
import {FormsModule} from '@angular/forms';
import {ButtonModule} from 'primeng/button';
import {CheckboxModule} from 'primeng/checkbox';
import {MessageModule} from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {FileUploadModule} from 'primeng/fileupload';
import {HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [
    BienvenidaComponent,
    CargarComponent,
    EstructuraComponent,
    GenerarComponent
  ],
  imports: [
    CommonModule,
    DropdownModule,
    FormsModule,
    ButtonModule,
    CheckboxModule,
    MessageModule,
    FileUploadModule,
    HttpClientModule,
    MessagesModule
  ],
  exports: [
    BienvenidaComponent,
    CargarComponent,
    EstructuraComponent,
    GenerarComponent
  ]
})
export class PagesModule { }
