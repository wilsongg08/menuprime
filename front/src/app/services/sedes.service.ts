import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { menuprimeLocations } from '../interfaces/interfaz.interfaces';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SedesService {

  private apiUrl: string = environment.apiUrl + '/locations';

  constructor( private http: HttpClient) { }

  obtenerSedes(): Observable<any> {

    return this.http.get<menuprimeLocations>(this.apiUrl)
}
}
