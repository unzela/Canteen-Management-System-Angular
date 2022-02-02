import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VenNavComponent } from './ven-nav.component';

describe('VenNavComponent', () => {
  let component: VenNavComponent;
  let fixture: ComponentFixture<VenNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VenNavComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VenNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
