import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { availableFields } from '../interfaces/interfaz.interfaces';
import { catchError } from 'rxjs/operators';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CamposDisponiblesService {

  private apiUrl: string = environment.apiUrl + '/availablefields';

  constructor( private http: HttpClient) { }

  obtenerCampos(): Observable<availableFields[]> {

    return this.http.get<availableFields[]>(this.apiUrl) //200 500
  }
}
