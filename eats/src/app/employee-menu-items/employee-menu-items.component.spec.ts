import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeMenuComponent } from './employee-menu-items.component';

describe('MenuComponent', () => {
  let component: EmployeeMenuComponent;
  let fixture: ComponentFixture<EmployeeMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeMenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
