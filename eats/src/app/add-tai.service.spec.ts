import { TestBed } from '@angular/core/testing';

import { AddTAIService } from './add-tai.service';

describe('AddTAIService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddTAIService = TestBed.get(AddTAIService);
    expect(service).toBeTruthy();
  });
});
