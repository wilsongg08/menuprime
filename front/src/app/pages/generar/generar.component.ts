import { Component, OnInit } from '@angular/core';
import { deliveriesCompanies } from 'src/app/interfaces/interfaz.interfaces';
import { EmpresasService } from 'src/app/services/empresas.service';
import { months } from '../../interfaces/interfaz.interfaces';
import { GenerarArchivoService } from '../../services/generar-archivo.service';
import { Buffer } from 'buffer';


@Component({
  selector: 'app-generar',
  templateUrl: './generar.component.html',
  styleUrls: ['./generar.component.css']
})
export class GenerarComponent implements OnInit {

  companies: deliveriesCompanies[] = [];
  anios: string[] = ["2020", "2021", "2022"];
  meses: months[] = [{name:"Enero", number: "01"},{name:"Febrero", number: "02"},{name:"Marzo", number: "03"},
                      {name:"Abril", number: "04"},{name:"Mayo", number: "05"},{name:"Junio", number: "06"},
                      {name:"Julio", number: "07"},{name:"Agosto", number: "08"},{name:"Septiembre", number: "09"},
                      {name:"Octubre", number: "10"},{name:"Noviembre", number: "11"},{name:"Diciembre", number: "12"}];
  frecuencias: string[] = ["Mensual", "Quincena 1", "Quincena 2", "Semana 1", "Semana 2", "Semana 3", "Semana 4"];

  selectedCompany: deliveriesCompanies;
  selectedAnio: string;
  selectedMes: months;
  selectedFrecuencia: string;

  mensajeError: boolean = false;
  mensajeExito: boolean = false;

  fromDate: String = "dd/mm/aa";
  toDate: String = "";


  constructor( private empresasService: EmpresasService,
                private generarArchivoService: GenerarArchivoService ) {} 

  ngOnInit(): void {
    this.listarEmpresas();
  }

  listarEmpresas(){
    this.empresasService.obtenerEmpresas().subscribe((resp) => {
      this.companies = resp;
    })
  }

  actualizarMensajes() {
    this.mensajeError = false;
    this.mensajeExito = false;
  }

  generarArchivo(){

    this.mensajeExito = false;
    if (!this.selectedCompany || !this.selectedAnio || !this.selectedMes || !this.selectedFrecuencia) {
      this.mensajeError = true;
      return;
    }

    this.mensajeError = false;

    // Se almacena estos valores en constantes para poder reiniciar los campos y que no genere error
    const business_name = this.selectedCompany.business_name;
    const anio = this.selectedAnio;
    const mesName = this.selectedMes.name;
    const frequency = this.selectedFrecuencia;

    this.generarArchivoService.generarArchivo(this.selectedCompany.business_name, this.selectedCompany.delivery_company_id, this.selectedMes.number, this.selectedAnio, this.selectedFrecuencia).subscribe((resp) => {   
      const blob = this.base64ToBlob(resp.file, 'text/csv');
      const url = window.URL.createObjectURL(blob);
      const a = document.createElement('a');
      a.href = url;
      a.download = business_name + '-' + anio + '-' + mesName + '-' + frequency + '.csv';
      a.click();
      window.URL.revokeObjectURL(url);
      this.mensajeExito = true;
    })

    this.selectedAnio = null;
    this.selectedCompany = null;
    this.selectedFrecuencia = null;
    this.selectedMes = null;     
  }

  base64ToBlob(base64: string, mime: string): Blob {

    const buffer = Buffer.from(base64, 'base64');

    return new Blob([buffer], { type: mime });

  }
}

