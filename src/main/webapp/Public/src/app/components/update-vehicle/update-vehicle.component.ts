import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Vehicle } from "../../services/vehicle";
import { VehicleService } from "../../services/vehicle.service";

@Component({
  selector: "app-update-vehicle",
  templateUrl: "./update-vehicle.component.html",
  styleUrls: ["./update-vehicle.component.css"],
})
export class UpdateVehicleComponent implements OnInit {
  id!: string;
  vehicle!: Vehicle;

  constructor(
    private vehicleService: VehicleService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.vehicle = new Vehicle();
    this.id = this.route.snapshot.params["id"];

    this.vehicleService.getVehicleById(this.id).subscribe(
      (data: any) => {
        console.log(data);
        this.vehicle = data;
      },
      (error: any) => console.log(error)
    );
  }

  updateVehicle(): void {
    this.vehicleService.updateVehicle(this.id, this.vehicle).subscribe(
      (data: any) => {
        console.log(data);
        this.vehicle = new Vehicle();
        this.gotoList();
      },
      (error: any) => console.log(error)
    );
  }

  gotoList() {
    throw new Error("Method not implemented.");
  }

  onSubmit() {
    this.vehicleService.updateVehicle(this.id, this.vehicle).subscribe(
      (data: any) => {
        this.goToVehicleList();
      },
      (error: any) => console.log(error)
    );
  }

  goToVehicleList() {
    this.router.navigate(["../../vehicle"], { relativeTo: this.route });
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
