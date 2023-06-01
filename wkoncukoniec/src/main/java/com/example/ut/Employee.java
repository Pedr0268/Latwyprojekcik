package com.example.ut;

public class Employee {


    public Employee(String imie, String nazwisko, String pozycja, int pensja) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pozycja = pozycja;
        this.idpracownika = nextId++;
        this.pensja = pensja;
    }


    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPozycja() {
        return pozycja;
    }

    public int getIdpracownika() {
        return idpracownika;
    }

    public int getPensja() {
        return pensja;
    }


    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setPozycja(String pozycja) {
        this.pozycja = pozycja;
    }

    public void setIdpracownika(int idpracownika) {
        this.idpracownika = idpracownika;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    public static int nextId = 0;

    public Employee() {
    }

    public String imie;
    public String nazwisko;
    public String pozycja;
    public int idpracownika;
    public int pensja;

        @Override
    public String toString() {
        return "Pracownik{" +
                "Imie='" + imie + '\'' +
                ", Nazwisko='" + nazwisko + '\'' +
                ", Pozycja='" + pozycja + '\'' +
                ", id=" + idpracownika +
                ", pensja=" + pensja +
                '}';
    }


}



