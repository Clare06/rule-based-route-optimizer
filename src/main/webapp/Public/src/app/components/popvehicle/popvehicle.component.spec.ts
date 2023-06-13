import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PopvehicleComponent } from './popvehicle.component';

describe('PopvehicleComponent', () => {
  let component: PopvehicleComponent;
  let fixture: ComponentFixture<PopvehicleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PopvehicleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PopvehicleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
