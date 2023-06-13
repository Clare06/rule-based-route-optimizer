import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vehicle } from './vehicle';

@Injectable({
  providedIn: 'root',
})
export class VehicleService {
  private baseURL = 'http://localhost:8080/vehicle';

  constructor(private httpClient: HttpClient) {}

  getVehiclesList(): Observable<Vehicle[]> {
    return this.httpClient.get<Vehicle[]>(`${this.baseURL}`);
  }

  createVehicle(vehicle: Vehicle): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, vehicle);
  }

  getVehicleById(id: string): Observable<Vehicle> {
    return this.httpClient.get<Vehicle>(`${this.baseURL}/${id}`);
  }

  updateVehicle(id: string, vehicle: Vehicle): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/${id}`, vehicle);
  }

  deleteVehicle(id: string): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
