import { Employee } from './../schema/employee';
import { environment } from './../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  public apiServerUrl = environment.serverBaseUrl;

  constructor(private http: HttpClient) {}

  public getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.apiServerUrl}/employees/all`);
  }

  public createEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(`${this.apiServerUrl}/employees/create`, employee);
  }

  public updateEmployee(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(`${this.apiServerUrl}/employees/update`, employee);
  }

  public deleteEmployee(employeeId: number): Observable<Employee> {
    return this.http.delete<Employee>(`${this.apiServerUrl}/employees/delete/${employeeId}`);
  }

}
