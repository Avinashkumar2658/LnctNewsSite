import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnlargeComponent } from './enlarge.component';

describe('EnlargeComponent', () => {
  let component: EnlargeComponent;
  let fixture: ComponentFixture<EnlargeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnlargeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EnlargeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
