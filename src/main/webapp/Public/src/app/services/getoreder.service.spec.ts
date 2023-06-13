import { TestBed } from '@angular/core/testing';

import { GetorederService } from './getoreder.service';

describe('GetorederService', () => {
  let service: GetorederService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetorederService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
