import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductpopComponent } from './productpop.component';

describe('ProductpopComponent', () => {
  let component: ProductpopComponent;
  let fixture: ComponentFixture<ProductpopComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductpopComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductpopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
