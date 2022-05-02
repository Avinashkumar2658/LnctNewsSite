import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OutsideBhopalComponent } from './outside-bhopal.component';

describe('OutsideBhopalComponent', () => {
  let component: OutsideBhopalComponent;
  let fixture: ComponentFixture<OutsideBhopalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OutsideBhopalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OutsideBhopalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
