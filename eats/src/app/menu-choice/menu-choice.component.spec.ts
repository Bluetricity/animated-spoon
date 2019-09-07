import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuChoiceComponent } from './menu-choice.component';

describe('MenuChoiceComponent', () => {
  let component: MenuChoiceComponent;
  let fixture: ComponentFixture<MenuChoiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuChoiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuChoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
