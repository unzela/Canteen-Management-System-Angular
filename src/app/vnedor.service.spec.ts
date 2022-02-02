import { TestBed } from '@angular/core/testing';

import { VnedorService } from './vnedor.service';

describe('VnedorService', () => {
  let service: VnedorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VnedorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
