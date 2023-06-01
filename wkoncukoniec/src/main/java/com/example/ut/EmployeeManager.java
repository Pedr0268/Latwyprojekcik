package com.example.ut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class EmployeeManager {
    private final HashMap<Integer, Employee> employees;

    public HashMap<Integer, Employee> getEmployees() {
        return this.employees;
    }

    public EmployeeManager(HashMap<Integer, Employee> employees) {
        this.employees = employees;
    }

    public void dodajPracownika(String imie, String nazwisko, String pozycja, int pensja) {
        Employee employee = new Employee(imie, nazwisko, pozycja, pensja);
        Integer keyEmployee = employee.getIdpracownika();
        this.employees.put(keyEmployee, employee);
    }

    public void usunpracownika(Employee employee) {
        if (this.employees.containsKey(employee.getIdpracownika())) {
            this.employees.remove(employee.getIdpracownika());
        } else {
            System.out.println("Nie ma pracownika z takim id");
        }

    }

    public void aktualizujpracownika(int idpracownika, String nowapozycja, int nowapensja) {
        if (znajdzpracownika(idpracownika) != null){
            Employee e = znajdzpracownika(idpracownika);
            e.setPozycja(nowapozycja);
            e.setPensja(nowapensja);
        } else {
            System.out.println("Nie ma pracownika o takim id");
        }

    }

    public Employee znajdzpracownika(int idpracownika) {
        if (this.employees.containsKey(idpracownika)) {
            return (Employee)this.employees.get(idpracownika);
        } else {
            System.out.println("Nie znaleziono pracownika");
            return null;
        }
    }

    public void listapracownikow() {
        ArrayList<Employee> employeeList = new ArrayList(this.employees.values());
        Iterator var2 = employeeList.iterator();

        while(var2.hasNext()) {
            Employee employee = (Employee)var2.next();
            System.out.println(employee);
        }

    }

    public HashSet<Employee> szukajponazwisku(String nazwisko) {
        HashSet<Employee> employeeList = new HashSet(this.employees.values());
        Iterator<Employee> employeeIterator = employeeList.iterator();

        while(employeeIterator.hasNext()) {
            Employee employee = (Employee)employeeIterator.next();
            if (!employee.getNazwisko().equals(nazwisko)) {
                employeeIterator.remove();
            }
        }

        return employeeList;
    }
}