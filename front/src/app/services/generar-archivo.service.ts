import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GenerarArchivoService {

  private apiUrl: string = environment.apiUrl + '/generate';

  constructor( private http: HttpClient ) { }

  generarArchivo(selectedCompanyName, selectedCompanyId, selectedMonth, selectedYear, selectedFrequency): Observable<any>{
    
    const params = new HttpParams()
      .set('selectedCompanyName', selectedCompanyName)
      .set('selectedCompanyId', selectedCompanyId)
      .set('selectedMonth', selectedMonth)
      .set('selectedYear', selectedYear)
      .set('selectedFrequency', selectedFrequency);

    return this.http.get<any>(this.apiUrl, {params});
  }
}
