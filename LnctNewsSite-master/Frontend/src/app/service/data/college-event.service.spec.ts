import { TestBed } from '@angular/core/testing';

import { CollegeEventService } from './college-event.service';

describe('CollegeEventService', () => {
  let service: CollegeEventService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CollegeEventService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
