import { TestBed } from '@angular/core/testing';

import { StockMenuServiceService } from './stock-menu-service.service';

describe('StockMenuServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: StockMenuServiceService = TestBed.get(StockMenuServiceService);
    expect(service).toBeTruthy();
  });
});
