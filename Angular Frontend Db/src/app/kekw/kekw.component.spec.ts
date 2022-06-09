import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KekwComponent } from './kekw.component';

describe('KekwComponent', () => {
  let component: KekwComponent;
  let fixture: ComponentFixture<KekwComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KekwComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KekwComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
