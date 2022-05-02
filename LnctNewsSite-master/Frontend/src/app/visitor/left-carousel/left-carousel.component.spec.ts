import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeftCarouselComponent } from './left-carousel.component';

describe('LeftCarouselComponent', () => {
  let component: LeftCarouselComponent;
  let fixture: ComponentFixture<LeftCarouselComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeftCarouselComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LeftCarouselComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
