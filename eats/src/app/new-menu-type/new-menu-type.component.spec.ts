import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewMenuTypeComponent } from './new-menu-type.component';

describe('NewMenuTypeComponent', () => {
  let component: NewMenuTypeComponent;
  let fixture: ComponentFixture<NewMenuTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewMenuTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewMenuTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
