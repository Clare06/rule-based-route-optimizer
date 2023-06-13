import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ENDPOINTS } from '../endpoints/rest.endpoints';
import { Capacity } from '../schemas/capacity.interface';

@Injectable({
  providedIn: 'root'
})
export class VehiclebycapacityService {
// capacity: Capacity ={maxVol:0,maxWeight:0};
  constructor(private http: HttpClient) { }
getVehicle(capacity: any){
return this.http.post(ENDPOINTS.GETVEHICLEBYID,capacity);
}
}
