import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TnpComponent } from './tnp.component';

describe('TnpComponent', () => {
  let component: TnpComponent;
  let fixture: ComponentFixture<TnpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TnpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TnpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
