import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {  ActivatedRoute, Router } from '@angular/router';
import { ENDPOINTS } from 'src/app/endpoints/rest.endpoints';
// import * as L from 'leaflet';

@Component({
  selector: 'app-route',
  templateUrl: './route.component.html',
  styleUrls: ['./route.component.css']
})
export class RouteComponent implements OnInit {
  constructor(private route:ActivatedRoute, private http:HttpClient) { }
  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      const curOrder: number[] = Array.isArray(params['curOrder']) ? params['curOrder'].map(Number) : [Number(params['curOrder'])];
      const curReq: number[] = Array.isArray(params['curReq']) ? params['curReq'].map(Number) : [Number(params['curReq'])];
      const selectedVehicle: string = params['selectedVehicle'];
  
      const dataObj = {
        curOrder: curOrder,
        curReq: curReq,
        selectedVehicle: selectedVehicle
      };
      console.log(ENDPOINTS.SENDDATAOBJ,dataObj);
      this.http.post(ENDPOINTS.SENDDATAOBJ,dataObj).subscribe(data=>{

      })
      
    });
  }
//   private map!: L.Map;

//   constructor() { }

//   ngOnInit(): void {
//   this.map = L.map('map').setView([6.927079, 79.861244], 13);
//   L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
//     attribution: '&copy; OpenStreetMap contributors'
//   }).addTo(this.map);

//   // Add 5 vehicles
//   const vehicleLocations = [    [6.935420, 79.850324],
//     [6.923305, 79.853522],
//     [6.918081, 79.865055]
//   ];
//   for (let i = 0; i < 5; i++) {
//     const lat = vehicleLocations[i][0];
//     const lng = vehicleLocations[i][1];
//     const marker = L.marker([lat, lng]).addTo(this.map);
//     marker.bindPopup('Vehicle ' + (i + 1));
//   }

//   // Add 15 destinations
//   const destinationLocations = [    [6.926625, 79.861952],
//     [6.932406, 79.864102],
//     [6.936801, 79.862875],
//     [6.929616, 79.864710],
//     [6.928250, 79.877620],
//     [6.930520, 79.854712],
//     [6.925825, 79.868539]
//   ];
//   for (let i = 0; i < 15; i++) {
//     const lat = destinationLocations[i][0];
//     const lng = destinationLocations[i][1];
//     const marker = L.marker([lat, lng]).addTo(this.map);
//     marker.bindPopup('Destination ' + (i + 1));
//   }
// }

  
}