import { TestBed } from '@angular/core/testing';

import { VehiclebycapacityService } from './vehiclebycapacity.service';

describe('VehiclebycapacityService', () => {
  let service: VehiclebycapacityService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VehiclebycapacityService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
