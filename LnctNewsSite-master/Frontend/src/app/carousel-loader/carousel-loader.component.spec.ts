import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarouselLoaderComponent } from './carousel-loader.component';

describe('TestComponent', () => {
  let component: CarouselLoaderComponent;
  let fixture: ComponentFixture<CarouselLoaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarouselLoaderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CarouselLoaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
