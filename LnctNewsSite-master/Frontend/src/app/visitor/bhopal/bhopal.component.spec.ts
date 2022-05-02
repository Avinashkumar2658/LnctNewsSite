import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BhopalComponent } from './bhopal.component';

describe('BhopalComponent', () => {
  let component: BhopalComponent;
  let fixture: ComponentFixture<BhopalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BhopalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BhopalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
