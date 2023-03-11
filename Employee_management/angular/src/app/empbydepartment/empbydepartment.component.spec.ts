import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpbydepartmentComponent } from './empbydepartment.component';

describe('EmpbydepartmentComponent', () => {
  let component: EmpbydepartmentComponent;
  let fixture: ComponentFixture<EmpbydepartmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmpbydepartmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmpbydepartmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
