import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpResponse } from '@angular/common/http';
import { fileStructure } from '../interfaces/interfaz.interfaces';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class EstructuraService {

  private apiUrl: string = environment.apiUrl + '/structure';

  constructor( private http: HttpClient) { }

  nuevaEstructura(fileStructure: fileStructure): Observable<HttpResponse<any>> {
    const body = fileStructure;
    return this.http.post(this.apiUrl, body, { observe: 'response', responseType: 'text' })  // 200  500
  }

  estructuraPrevia(id_location, id_delivery_company): Observable<any> {
    const params = new HttpParams()
      .set('id_location',id_location)
      .set('id_delivery_company',id_delivery_company);

    return this.http.get<fileStructure[]>(this.apiUrl, {params})  // 201 500
  }

  eliminarEstructura(id_file_estructure): Observable<any> {

    const url = `${this.apiUrl}/${id_file_estructure}`;

    return this.http.delete(url, { responseType: 'text' }); // 201 500
  }
}
