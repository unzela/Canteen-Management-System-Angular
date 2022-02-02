import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CplacedordersComponent } from './cplacedorders.component';

describe('CplacedordersComponent', () => {
  let component: CplacedordersComponent;
  let fixture: ComponentFixture<CplacedordersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CplacedordersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CplacedordersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
