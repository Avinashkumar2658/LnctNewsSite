import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassNotesComponent } from './class-notes.component';

describe('ClassNotesComponent', () => {
  let component: ClassNotesComponent;
  let fixture: ComponentFixture<ClassNotesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClassNotesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClassNotesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
