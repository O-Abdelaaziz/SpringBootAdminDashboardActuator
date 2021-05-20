import { Employee } from './../schema/employee';
import { environment } from './../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


interface EmployeeResponse {
  content: Employee[],
  pageable: {
    pageNumber:number,
  },
  totalPages:number,
  totalElements: number,
  number:number,
  offset:number

}


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  public apiServerUrl = environment.serverBaseUrl;

  constructor(private http: HttpClient) {}

  public getEmployees(pageNumber:number,pageSize:number): Observable<EmployeeResponse> {
    return this.http.get<EmployeeResponse>(`${this.apiServerUrl}/employees/all?page=${pageNumber}&size=${pageSize}`);
  }

  public createEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(`${this.apiServerUrl}/employees/create`, employee);
  }

  public generateEmployees(size: number): Observable<any> {
    return this.http.get<any>(`${this.apiServerUrl}/employees/generate?size=${size}`);
  }

  public updateEmployee(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(`${this.apiServerUrl}/employees/update`, employee);
  }

  public deleteEmployee(employeeId: number): Observable<Employee> {
    return this.http.delete<Employee>(`${this.apiServerUrl}/employees/delete/${employeeId}`);
  }

  public deleteAllEmployees(): Observable<any> {
    return this.http.delete<any>(`${this.apiServerUrl}/employees/delete/all`);
  }

}
