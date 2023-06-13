import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { ENDPOINTS } from '../endpoints/rest.endpoints';

@Injectable({
  providedIn: 'root'
})
export class GetorederService {

  constructor(private http : HttpClient) { }

  public getOrders() {
    return this.http.get(ENDPOINTS.ORDERGET);
      // .pipe(
      //   map((response: any) => response.data)
      // );
  }
}
