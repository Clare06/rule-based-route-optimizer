import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WarebodyComponent } from './warebody.component';

describe('WarebodyComponent', () => {
  let component: WarebodyComponent;
  let fixture: ComponentFixture<WarebodyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WarebodyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WarebodyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
