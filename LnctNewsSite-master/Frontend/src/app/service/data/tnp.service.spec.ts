import { TestBed } from '@angular/core/testing';

import { TnpService } from './tnp.service';

describe('TnpService', () => {
  let service: TnpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TnpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
