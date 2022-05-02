import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SomeMessageComponent } from './some-message.component';

describe('SomeMessageComponent', () => {
  let component: SomeMessageComponent;
  let fixture: ComponentFixture<SomeMessageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SomeMessageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SomeMessageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
