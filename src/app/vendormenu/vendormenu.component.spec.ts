import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VendormenuComponent } from './vendormenu.component';

describe('VendormenuComponent', () => {
  let component: VendormenuComponent;
  let fixture: ComponentFixture<VendormenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VendormenuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VendormenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
