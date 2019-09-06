import { TestBed } from '@angular/core/testing';

import { MenuTypesServiceService } from './menu-types-service.service';

describe('MenuTypesServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MenuTypesServiceService = TestBed.get(MenuTypesServiceService);
    expect(service).toBeTruthy();
  });
});
