import { HttpClient } from '@angular/common/http';
import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ENDPOINTS } from 'src/app/endpoints/rest.endpoints';
import { VehiclebycapacityService } from 'src/app/services/vehiclebycapacity.service';
import { Capacity } from 'src/app/schemas/capacity.interface';
import { Router } from '@angular/router';

@Component({
  selector: 'app-popvehicle',
  templateUrl: './popvehicle.component.html',
  styleUrls: ['./popvehicle.component.css']
})
export class PopvehicleComponent {
  curOrder: number[]=[];
  curReq: number[]=[];
  orderDetail: any;
  returnDetail: any;
  vehicleDetail: any;
  totalWeight: number  =0;
  totalVolume:number = 0;
  totalOWeight: number  =0;
  totalOVolume:number = 0;
  selectedVehicle: string | null = null;
  
  capacity:Capacity ={maxVol:0,maxWeight:0};
  constructor(public dialogRef: MatDialogRef<PopvehicleComponent>,
    @Inject(MAT_DIALOG_DATA) public data1: any,private http : HttpClient,private vehservice : VehiclebycapacityService, private router: Router){
      // console.log("pop"+this.data.someData);
    }
    ngOnInit(): void {
      this.curOrder=this.data1.someData;
      this.curReq=this.data1.someReq;
      console.log(this.curOrder);
      this.http.get(ENDPOINTS.GETORDERBYID+this.curOrder).subscribe(data=>{
        this.orderDetail=data;
        this.orderDetail.map((currentOrder: any) =>{
          this.totalOWeight=this.totalOWeight+parseInt(currentOrder.weight);
          this.totalOVolume=this.totalOVolume+parseInt(currentOrder.volume);
           }
           )
        
      })
      this.http.get(ENDPOINTS.GETRETURNBYID+this.curReq).subscribe((data: Object)=>{
        this.returnDetail=data;
        

       this.returnDetail.map((currentReturn: any) =>{
       this.totalWeight=this.totalWeight+parseInt(currentReturn.backhauling.tWeight);
       this.totalVolume=this.totalVolume+parseInt(currentReturn.backhauling.tVolume);
        }
        )
      
      this.capacity.maxVol=this.totalOVolume+this.totalVolume;
      this.capacity.maxWeight=this.totalOWeight+this.totalWeight;
      
        console.log(this.capacity);

      // for(var index in this.curOrder){
      // this.totalWeight=this.totalWeight+parseInt(this.returnDetail[0].backhauling.tWeight);
      // }
      //  console.log(this.returnDetail[0].backhauling.reason);
      this.vehservice.getVehicle(this.capacity).subscribe((data: Object)=>{
        this.vehicleDetail=data;
      })
      })
      // console.log((ENDPOINTS.GETRETURNBYID+c));
      console.log(this.selectedVehicle);
      
    }
    assign(vehicleID: string){
        this.selectedVehicle=vehicleID;
        console.log(this.selectedVehicle)
    }
    Submit(){
      const routeData = {
        curOrder: this.curOrder,
        curReq: this.curReq,
        selectedVehicle: this.selectedVehicle
      };
    
      this.router.navigate(['/route'], { queryParams: routeData });
    }
    clear(){
      this.selectedVehicle=null;
    }
}
