import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OutlethomeComponent } from './outlethome.component';

describe('OutlethomeComponent', () => {
  let component: OutlethomeComponent;
  let fixture: ComponentFixture<OutlethomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OutlethomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OutlethomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
