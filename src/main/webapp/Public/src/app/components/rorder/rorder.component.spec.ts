import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RorderComponent } from './rorder.component';

describe('RorderComponent', () => {
  let component: RorderComponent;
  let fixture: ComponentFixture<RorderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RorderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RorderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
