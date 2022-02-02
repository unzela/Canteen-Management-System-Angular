import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuDetailsComponent } from './menu-details.component';

describe('MenuDetailsComponent', () => {
  let component: MenuDetailsComponent;
  let fixture: ComponentFixture<MenuDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
