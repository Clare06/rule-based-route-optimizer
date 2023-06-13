import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddproductpopComponent } from './addproductpop.component';

describe('AddproductpopComponent', () => {
  let component: AddproductpopComponent;
  let fixture: ComponentFixture<AddproductpopComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddproductpopComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddproductpopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
