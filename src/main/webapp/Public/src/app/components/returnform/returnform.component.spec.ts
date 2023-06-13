import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReturnformComponent } from './returnform.component';

describe('ReturnformComponent', () => {
  let component: ReturnformComponent;
  let fixture: ComponentFixture<ReturnformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReturnformComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReturnformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
