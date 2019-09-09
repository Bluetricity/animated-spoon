import { TestBed } from '@angular/core/testing';

import { AddSAMService } from './add-sam.service';

describe('AddSAMService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddSAMService = TestBed.get(AddSAMService);
    expect(service).toBeTruthy();
  });
});
