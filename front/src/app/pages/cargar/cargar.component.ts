import { Component } from '@angular/core';
import { CargarArchivoService } from '../../services/cargar-archivo.service';


@Component({
  selector: 'app-cargar',
  templateUrl: './cargar.component.html',
  styleUrls: ['./cargar.component.css']
})
export class CargarComponent {

  mensajeError: boolean = false;
  mensajeExito: boolean = false;
  mensajeConexion: boolean = false;

  constructor(private cargarArchivoService: CargarArchivoService) {}

  myUploader($event:any) {

    this.mensajeError = false;
    this.mensajeExito = false;
    this.mensajeConexion = false;
    
    const archivoCapturado= $event.files[0];

    this.cargarArchivoService.cargarArchivo(archivoCapturado).subscribe(
      (resp) => {this.mensajeExito = true;},
      (error) => { 
        if (error.status == 500) {
          this.mensajeError = true;
        } else {
          this.mensajeConexion = true;
        }})            
  }

  actualizarMensajes() {
    this.mensajeError = false;
    this.mensajeExito = false;
    this.mensajeConexion = false;
  }
}
