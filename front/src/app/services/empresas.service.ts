import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { deliveriesCompanies } from '../interfaces/interfaz.interfaces';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class EmpresasService {

  private apiUrl: string = environment.apiUrl;

  constructor( private http: HttpClient) { }

  obtenerEmpresas(): Observable<deliveriesCompanies[]> {

    const url = `${this.apiUrl}/companies`;
    return this.http.get<deliveriesCompanies[]>(url) // 200 500
  }

  modifyFrequency(deliveryCompany): Observable<HttpResponse<any>>{
    const url = `${this.apiUrl}/update`;
    const body = deliveryCompany;
    return this.http.put(url, deliveryCompany, { observe: 'response', responseType: 'text' })  // 201 500
  }

}
