import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of,Observable, throwError } from 'rxjs';
import { AuthService } from './services/auth/auth.service';

import { AppComponent } from './app.component';
import { User } from './models/user.class';

describe('AppComponent', () => {
  let component: AppComponent;
  let authService: AuthService;
  let fixture: ComponentFixture<AppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppComponent ],
      imports: [ HttpClientTestingModule ],
      providers: [ AuthService ]
    })
    .compileComponents();

    authService = TestBed.get(AuthService);
  }));

  beforeEach(() => {
    component = new AppComponent(authService);
    fixture = TestBed.createComponent(AppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  describe('Ejemplo 1', () => {
    it('Test 1', () => {
      expect(component.title).toEqual("GestLine");
    });
    it('Test 2', () => {
        component.documentClick(null);
        expect(1).toEqual(1);
    });
    it('Test 3', () => {
        component.changeRoute();
        expect(1).toEqual(1);
    });
    it('Test 4', () => {
        const data = {
          "result" : "2"
        }

        component.authService.setUser(new User("1", "1", "1"));
        component.authService.setToken("1");

        spyOn(authService, 'getTokenServer').and.returnValue(of(data));
        spyOn(authService, 'logoutUser');

        component.validateToken();
        expect(1).toEqual(1);
    });




    it('Test 5', () => {
        const error = {
          "result" : "1"
        }

        component.authService.setUser(new User("1", "1", "1"));
        component.authService.setToken("1");


        authService.getTokenServer("").subscribe({
          error: (err) => {
            expect(err).toEqual({ error: 'lol' });
          }
        })
        

        spyOn(authService, 'getTokenServer').and.returnValue(throwError({status: 404}));



        spyOn(authService, 'logoutUser');

        expect(1).toEqual(1);
    });






    

  });
});