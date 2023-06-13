import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Vehicle } from "../../services/vehicle";
import { VehicleService } from "../../services/vehicle.service";

@Component({
  selector: "app-vehicle-list",
  templateUrl: "./vehicle-list.component.html",
  styleUrls: ["./vehicle-list.component.css"],
})
export class VehicleListComponent implements OnInit {
  vehicles: Vehicle[] = [];

  constructor(private vehicleService: VehicleService, private router: Router,private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.getVehicles();
  }

  private getVehicles() {
    this.vehicleService.getVehiclesList().subscribe((data) => {
      this.vehicles = data;
    });
  }

  vehicleDetails(id: string) {
    this.router.navigate(["../vehiclelist", id],{ relativeTo: this.route });
  }

  updateVehicle(id: string) {
    this.router.navigate(["../updatevehicle", id], { relativeTo: this.route });
  }

  deleteVehicle(id: string) {
    if(confirm('Are you sure want to delete the record?'))
    this.vehicleService.deleteVehicle(id).subscribe((data) => {
      console.log(data);
      alert("Record deleted sucessfully !!!")
      this.getVehicles();
    });
  }
}
