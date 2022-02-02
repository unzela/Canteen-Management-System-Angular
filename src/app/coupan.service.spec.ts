import { TestBed } from '@angular/core/testing';

import { CoupanService } from './coupan.service';

describe('CoupanService', () => {
  let service: CoupanService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CoupanService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
