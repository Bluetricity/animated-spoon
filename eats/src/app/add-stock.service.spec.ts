import { TestBed } from '@angular/core/testing';

import { AddStockService } from './add-stock.service';

describe('AddStockService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddStockService = TestBed.get(AddStockService);
    expect(service).toBeTruthy();
  });
});
