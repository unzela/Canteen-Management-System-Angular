import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CloginComponent } from './clogin.component';

describe('CloginComponent', () => {
  let component: CloginComponent;
  let fixture: ComponentFixture<CloginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CloginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
