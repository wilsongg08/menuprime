import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpResponse } from '@angular/common/http';

import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CargarArchivoService {

  private apiUrl: string = environment.apiUrl + '/load';

  constructor( private http: HttpClient ) { }

  cargarArchivo (archivo: any): Observable<HttpResponse<any>> {

    const archivoCSV: FormData = new FormData();
    archivoCSV.append ('file', archivo);

    return this.http.post(this.apiUrl, archivoCSV, { observe: 'response', responseType: 'text' })
              
  }
}
