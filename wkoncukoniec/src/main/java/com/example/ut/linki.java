package com.example.ut;

import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class linki {
    static HashMap<Integer, Employee> employeeHashMap = new HashMap();
    static EmployeeManager employeeManager = new EmployeeManager(employeeHashMap);

    public static void addtomanager() {
        employeeManager.dodajPracownika("Jakub", "Berbeż", "Pracownik", 1200);
        employeeManager.dodajPracownika("Daro", "Wuc", "Menager", 420);
        employeeManager.dodajPracownika("Anna", "Latoć", "Pomocnik", 2314);
        employeeManager.dodajPracownika("Jan", "Kowalski", "Szef", 6969);
    }

    @GetMapping({"/input"})
    public String form(Model model) {
        model.addAttribute("Employee", new Employee());
        return "formulaz";
    }

    @GetMapping({"/"})
    public String displayEmployees(Model model) {
        model.addAttribute("employeeManager", employeeManager);
        return "glowny";
    }

    @GetMapping({"/edit/{id}"})
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Employee employee = employeeManager.znajdzpracownika(id);
        model.addAttribute("employee", employee);
        return "edycja";
    }

    @PostMapping({"/usun/{id}"})
    public String deleteEmployee(@PathVariable("id") int id) {
        System.out.println(id);
        employeeManager.usunpracownika(employeeManager.znajdzpracownika(id));
        return "redirect:/";
    }

    @PostMapping({"/aktualizuj/{id}"})
    public String updateEmployee(@PathVariable("id") String id, @ModelAttribute("employee") Employee aktualizujpracownika) {
        employeeManager.aktualizujpracownika(Integer.parseInt(id), aktualizujpracownika.getPozycja(), aktualizujpracownika.getPensja());
        return "redirect:/";
    }

    @PostMapping({"/szukajnazwiska/szukaj"})
    public String znajdznazwisko(@RequestParam("nazwisko") String nazwisko, Model model) {
        model.addAttribute("nazwisko", nazwisko);
        model.addAttribute("employeeManager", employeeManager);
        return "znajdznazwisko";
    }

    @PostMapping({"/employee/zapisz"})
    public String addEmployeeToHashList(@RequestParam("imie") String imie,@RequestParam("nazwisko") String nazwisko,@RequestParam("pozycja") String pozycja,@RequestParam("pensja") int pensja) {
        System.out.println(imie+ " "+imie+ " "+nazwisko+ " "+pozycja+ " "+ pensja);
        employeeManager.dodajPracownika(imie, nazwisko, pozycja, pensja);
        return "redirect:/input";
    }
}