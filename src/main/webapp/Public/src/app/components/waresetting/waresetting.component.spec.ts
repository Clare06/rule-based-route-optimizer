import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WaresettingComponent } from './waresetting.component';

describe('WaresettingComponent', () => {
  let component: WaresettingComponent;
  let fixture: ComponentFixture<WaresettingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WaresettingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WaresettingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
