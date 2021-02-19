import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImformationPetComponent } from './imformation-pet.component';

describe('ImformationPetComponent', () => {
  let component: ImformationPetComponent;
  let fixture: ComponentFixture<ImformationPetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImformationPetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImformationPetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
