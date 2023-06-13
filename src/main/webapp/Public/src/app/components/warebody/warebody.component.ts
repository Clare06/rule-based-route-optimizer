import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { ENDPOINTS } from "src/app/endpoints/rest.endpoints";
import { ApiResponse } from "./schema/apiResponse";
import { RgoodResponse } from "./schema/rgoodResponse";



@Component({
  selector: 'app-warebody',
  templateUrl: './warebody.component.html',
  styleUrls: ['./warebody.component.css']
})
export class WarebodyComponent implements OnInit {
  inventory:ApiResponse[]=[];
  saleData: { name: string; value: number; }[] = [];
  color: {name: string; value: string}[]=[]
  vehicle: any ;
  rgood: {name: string; value: number}[]=[];
  constructor(private http:HttpClient){}
  ngOnInit(): void {
     this.http.get<ApiResponse[]>(ENDPOINTS.GETPRODUCT).subscribe((response)=>{
      this.saleData = response.map(item => {
        return {
          name: item.productName,
          value: item.availableQuantity
        }
        
     })
     this.color = response.map((item1,index) => {
      return {
        name : item1.productName,
        value : this.getColors(index)
      }
     })
    });
   this.http.get(ENDPOINTS.GETVEHICLE).subscribe(response1 =>{
    this.vehicle=response1;
   })  
   this.http.get<RgoodResponse[]>(ENDPOINTS.GETRGOOD).subscribe(response2 =>{
    this.rgood=response2.map(item3 => {
      return {
        name: item3.product.productName,
        value: item3.totalQuantity
      }
    })
   })  
  }
  
   isActive(index:number): boolean{
    if(this.vehicle[index].status=="trip"){
      return true;
    }else{
      return false;
    }

   }

   getColors(index : number): string {
    if((index+1)%4==1){
    return "#002161";
    }
    else if ((index+1)%4==2){
      return "#F9C144"
    }
    else if ((index+1)%4==3){
      
      return "#C02C26"

    }else {
      return "#50B153"
    }
  }
}
