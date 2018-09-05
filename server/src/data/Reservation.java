/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author wint4
 */
public class Reservation {

    private int id;
    private String locationA, locationB;
    private String date;
    private String time;
    private String company, type;
    private int price, nmTickets;

    public Reservation() {
    }

    public Reservation(int id, String locationA, String locationB, String date, String time, String company, String type, int price, int nmTickets) {
        this.id = id;
        this.locationA = locationA;
        this.locationB = locationB;
        this.date = date;
        this.time = time;
        this.company = company;
        this.type = type;
        this.price = price;
        this.nmTickets = nmTickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationA() {
        return locationA;
    }

    public void setLocationA(String locationA) {
        this.locationA = locationA;
    }

    public String getLocationB() {
        return locationB;
    }

    public void setLocationB(String locationB) {
        this.locationB = locationB;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNmTickets() {
        return nmTickets;
    }

    public void setNmTickets(int nmTickets) {
        this.nmTickets = nmTickets;
    }

    @Override
    public String toString() {
        return "id: " + id + " " + locationA + " " + locationB + " " + date + " " + time + " " + company + " " + type + " " + price + " " + nmTickets;
    }

}
