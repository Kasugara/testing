import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from 'src/app/model/employee';
import { environment } from 'src/environments/environment';

@Injectable({providedIn: 'root'})
export class EmployeeService {

  private url= environment.apiBaseUrl + '/emp';


  constructor(private http: HttpClient){}

  getEmployeesList(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.url}/all`);
  }

  addEmployee(employees:Employee):Observable<any>{
    return this.http.post<any>(`${this.url}/add`,employees);
  }

  updateEmployee(employeeId: number, employee: any): Observable<any> {
    return this.http.put(`${this.url}/update/`+ employeeId, employee);
  }

  getEmployeesById(employeeId: number):Observable<any>{
    return this.http.get<any>(`${this.url}/find/${employeeId}`);
  }

  deleteEmployee(employeeId: number): Observable<any> {
    return this.http.delete<void>(`${this.url}/delete/${employeeId}`);
  }

  paginationEmployee(page :any ,size : any,sort: any,order :any):Observable<Employee[]>{
    let params = this.setHttpParameter(page,size,sort,order)
    return this.http.get<Employee[]>(`${this.url}/pageemployee`,{params:params})
  }

  setHttpParameter(page:any, size:any, sort: any, order:any){
    let params = new HttpParams();
    params = params.append('page',page);
    params = params.append('sort',sort);
    params = params.append('sort',order);
    params = params.append('size',size);
    return params;
    
    


  }

}