import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReturnreqComponent } from './returnreq.component';

describe('ReturnreqComponent', () => {
  let component: ReturnreqComponent;
  let fixture: ComponentFixture<ReturnreqComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReturnreqComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReturnreqComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
