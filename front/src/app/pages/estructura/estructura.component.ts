import { NgModule } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { EmpresasService } from '../../services/empresas.service';
import { availableFields, deliveriesCompanies } from 'src/app/interfaces/interfaz.interfaces';
import { menuprimeLocations, fileStructure } from '../../interfaces/interfaz.interfaces';
import { SedesService } from '../../services/sedes.service';
import { EstructuraService } from 'src/app/services/estructura.service';
import { CamposDisponiblesService } from '../../services/campos-disponibles.service';

@Component({
  selector: 'app-estructura',
  templateUrl: './estructura.component.html',
  styleUrls: ['./estructura.component.css']
})
export class EstructuraComponent implements OnInit {  

  companies: deliveriesCompanies[] = [];
  sedes: menuprimeLocations[] = [];
  camposDisponibles: availableFields[] = [];
  camposElegidos: availableFields[] = [];
  estructuraPrevia: fileStructure[] = [];
  frequencies: string[] = ["Mensual", "Quincena 1", "Quincena 2", "Semana 1", "Semana 2", "Semana 3", "Semana 4"];

  selectedCompany: deliveriesCompanies;
  selectedSede: menuprimeLocations;
  selectedFrequency: string;

  mensajeError: boolean = false;
  mensajeExito: boolean = false;
  mensajeConexion: boolean = false;

  yaExiste: boolean;
  porEliminar: boolean;

  constructor( private empresasService: EmpresasService, 
               private sedesService: SedesService,
               private camposDisponiblesService: CamposDisponiblesService,
               private estructuraService: EstructuraService) {}

  ngOnInit(): void {
    this.listarEmpresas();
    this.listarSedes();
    this.listarCamposDisponibles();
  }

  actualizarCamposPrevios() {
    
    this.mensajeError = false;
    this.mensajeExito = false;
    this.mensajeConexion = false;

    if (this.selectedCompany && this.selectedSede){
      
      this.listarEstructuraPrevia(this.selectedSede.menuprime_location_id,this.selectedCompany.delivery_company_id);
    }
    
  }
  
  guardarEstructura(){
    try {
      this.mensajeExito = false;
      this.mensajeConexion = false;
      if (!this.selectedCompany || !this.selectedSede) {
        this.mensajeError = true;
        return;
      }

      this.mensajeError = false;
  
      let fileStructure: fileStructure;

      // Logica para guardar frecuencia

      if (this.selectedFrequency) {
        let deliveryCompany: deliveriesCompanies = {
          delivery_company_id: this.selectedCompany.delivery_company_id,
          business_name: this.selectedCompany.business_name,
          tax_number: this.selectedCompany.tax_number,
          frequency_rate: this.selectedFrequency
        };

        this.empresasService.modifyFrequency(deliveryCompany).subscribe((resp) => {})
      }

      // Logica para agregar los nuevos campos extras 
      for (let campo of this.camposElegidos) {
        this.yaExiste = false;

        for (let previo of this.estructuraPrevia) {
          if (campo.available_field_id===previo.fk_available_field_id){
            this.yaExiste = true;
            break;
          }        
        }
        
        if(!this.yaExiste){
          
          fileStructure = {
            fk_available_field_id: campo.available_field_id,
            fk_delivery_company_id: this.selectedCompany.delivery_company_id,
            fk_location_id: this.selectedSede.menuprime_location_id
          }

          this.estructuraService.nuevaEstructura(fileStructure).subscribe((resp) => {} );
        } 
      }
      
      // Logica para eliminar los campos extras que ya no se requieren
      for (let previo of this.estructuraPrevia) {
        this.porEliminar = true;

        for (let campo of this.camposElegidos) {
          if (campo.available_field_id===previo.fk_available_field_id){
            this.porEliminar = false;
            break;
          }         
        }
        if(this.porEliminar){
          this.estructuraService.eliminarEstructura(previo.file_structure_id).subscribe();
        }

      }

    }
    catch {
      this.mensajeConexion = true;
      return;
    }
    
    this.selectedCompany = null;
    this.selectedFrequency = null;
    this.selectedSede = null;

    this.mensajeExito = true;
  }

  listarEmpresas(){
    this.empresasService.obtenerEmpresas().subscribe((resp) => {
      this.companies = resp;
    })
  }

  listarSedes(){
    this.sedesService.obtenerSedes().subscribe((resp) => {
      this.sedes = resp;
    })
  }

  listarCamposDisponibles() {
    this.camposDisponiblesService.obtenerCampos().subscribe((resp) => {this.camposDisponibles = resp;})
  }

  listarEstructuraPrevia(id_location, id_delivery_company) {
    this.estructuraService.estructuraPrevia(id_location, id_delivery_company).subscribe((resp) => {
      this.estructuraPrevia = resp;
    })
  }

}
