import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Vehicle } from "../../services/vehicle";
import { VehicleService } from "../../services/vehicle.service";

@Component({
  selector: "app-vehicle-details",
  templateUrl: "./vehicle-details.component.html",
  styleUrls: ["./vehicle-details.component.css"],
})
export class VehicleDetailsComponent implements OnInit {
  id!: string;
  vehicle!: Vehicle;
  constructor(
    private route: ActivatedRoute,
    private vehicleService: VehicleService
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params["id"];
    this.vehicle = new Vehicle();
    this.vehicleService.getVehicleById(this.id).subscribe((data) => {
      this.vehicle = data;
    });
  }
}
