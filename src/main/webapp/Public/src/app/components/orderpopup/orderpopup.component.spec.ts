import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderpopupComponent } from './orderpopup.component';

describe('OrderpopupComponent', () => {
  let component: OrderpopupComponent;
  let fixture: ComponentFixture<OrderpopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderpopupComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrderpopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
