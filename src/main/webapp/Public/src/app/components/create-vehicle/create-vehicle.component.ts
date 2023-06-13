import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Vehicle } from "../../services/vehicle";
import { VehicleService } from "../../services/vehicle.service";


@Component({
  selector: "app-create-vehicle",
  templateUrl: "./create-vehicle.component.html",
  styleUrls: ["./create-vehicle.component.css"],
})
export class CreateVehicleComponent implements OnInit {
  vehicle: Vehicle = new Vehicle();
  constructor(private vehicleService: VehicleService, private router: Router, private route:ActivatedRoute) {}

  ngOnInit(): void {}

  saveVehicle() {
    this.vehicleService.createVehicle(this.vehicle).subscribe(
      (data: any) => {
        console.log(data);
        this.goToVehicleList();
      },
      (error: any) => console.log(error)
    );
  }

  goToVehicleList() {
    this.router.navigate(["../vehicle"], { relativeTo: this.route });
  }

  onSubmit() {
    console.log(this.vehicle);
    this.saveVehicle();
  }

  OnlyNumbersAllowed(event: { which: any; keyCode: any; }):boolean{
    const charCode= (event.which)? event.which: event.keyCode;
    if(charCode>31 && (charCode<48 || charCode>57)){
      console.log('charCode restricted is '+charCode);
      return false;
    }
    return true;
  }
}
