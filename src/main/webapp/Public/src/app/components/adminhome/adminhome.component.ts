import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ApiResponse } from '../warebody/schema/apiResponse';
import { ENDPOINTS } from 'src/app/endpoints/rest.endpoints';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit{
  o_count: number = 0;
  v_count: number = 0;
  b_count: number = 0;
  saleData: { name: string; value: number; }[] = [];
  color: {name: string; value: string}[]=[]
  constructor(private http:HttpClient){

  }

    ngOnInit(): void {
      const o_count_url = 'http://localhost:8080/order/count';
      this.http.get(o_count_url).subscribe((data: any) => {
      this.o_count=data;
    });

      const b_count_url = 'http://localhost:8080/branch_count';
      this.http.get(b_count_url).subscribe((data: any) => {
      this.b_count=data;
    });

      const v_count_url = 'http://localhost:8080/vehicle/count';
      this.http.get(v_count_url).subscribe((data: any) => {
      this.v_count=data;
    });
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
