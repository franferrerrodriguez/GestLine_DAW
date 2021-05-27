import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LimitSliderComponent } from './limit-slider.component';

describe('LimitSliderComponent', () => {
  let component: LimitSliderComponent;
  let fixture: ComponentFixture<LimitSliderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LimitSliderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LimitSliderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
