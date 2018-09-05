/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.Request;
import data.Reservation;
import frames.Frame;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Server;

/**
 *
 * @author wint4
 */
public class Controller {

    private static Controller instance = null;

    private Stage primaryStage;
    private Scene scene;
    private Frame frame;

    private ArrayList<Reservation> reservations;

    private Controller() {
        scene = null;
        frame = null;
        reservations = Connector.getInstance().readAllReservations();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Scene getScene() {
        return scene;
    }

    public Frame getFrame() {
        return frame;
    }

    public static void setInstance(Controller instance) {
        Controller.instance = instance;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    private static void print(String s) {

    }

    static Request decodeRequest(Request request) {
        if (request.getFuncName().equalsIgnoreCase("LocationA")) {
            return sendLocatioA();
        } else if (request.getFuncName().equalsIgnoreCase("LocationB")) {
            return sendLocationB(request);
        } else if (request.getFuncName().equalsIgnoreCase("Date")) {
            return sendTime(request);
        } else if (request.getFuncName().equalsIgnoreCase("Company")) {
            return sendCompany(request);
        } else if (request.getFuncName().equalsIgnoreCase("Type")) {
            return sendTypes(request);
        } else if (request.getFuncName().equalsIgnoreCase("Check")) {
            return sendInfo(request);
        } else {
            return insertbooking(request);
        }

    }

    private static Request sendLocatioA() {

        Request request;
        String name = "LocationA";
        ArrayList<String> locations = new ArrayList<>();
        for (Reservation R : Controller.getInstance().getReservations()) {
            if (!locations.contains(R.getLocationA())) {
                locations.add(R.getLocationA());
            }
        }

        request = new Request(name, locations);
        return request;
    }

    private static Request sendLocationB(Request request) {
        Request r;
        String name = "LocationB";
        ArrayList<String> locations = new ArrayList<>();
        for (Reservation R : Controller.getInstance().getReservations()) {
            if (!locations.contains(R.getLocationB()) && R.getLocationA().equalsIgnoreCase(request.getParametres().get(0))) {
                locations.add(R.getLocationB());
            }
        }
        r = new Request(name, locations);
        return r;

    }

    private static Request sendTime(Request request) {
        Request r;
        String name = "Date";
        ArrayList<String> times = new ArrayList<>();
        for (Reservation R : Controller.getInstance().getReservations()) {
            if (!times.contains(R.getTime()) && R.getLocationA().equalsIgnoreCase(request.getParametres().get(0)) && R.getLocationB().equalsIgnoreCase(request.getParametres().get(1)) && R.getDate().equalsIgnoreCase(request.getParametres().get(2))) {
                times.add(R.getTime());
            }
        }
        r = new Request(name, times);
        return r;

    }

    private static Request sendCompany(Request request) {
        Request r;
        String name = "Company";
        ArrayList<String> companies = new ArrayList<>();
        for (Reservation R : Controller.getInstance().getReservations()) {
            if (!companies.contains(R.getCompany()) && R.getLocationA().equalsIgnoreCase(request.getParametres().get(0)) && R.getLocationB().equalsIgnoreCase(request.getParametres().get(1)) && R.getDate().equalsIgnoreCase(request.getParametres().get(2)) && R.getTime().equalsIgnoreCase(request.getParametres().get(3))) {
                companies.add(R.getCompany());
            }
        }
        r = new Request(name, companies);
        return r;
    }

    private static Request sendTypes(Request request) {
        Request r;
        String name = "Type";
        ArrayList<String> types = new ArrayList<>();
        for (Reservation R : Controller.getInstance().getReservations()) {
            if (!types.contains(R.getType()) && R.getLocationA().equalsIgnoreCase(request.getParametres().get(0)) && R.getLocationB().equalsIgnoreCase(request.getParametres().get(1)) && R.getDate().equalsIgnoreCase(request.getParametres().get(2)) && R.getTime().equalsIgnoreCase(request.getParametres().get(3)) && R.getCompany().equalsIgnoreCase(request.getParametres().get(4))) {
                types.add(R.getType());
            }
        }
        r = new Request(name, types);
        return r;
    }

    private static Request sendInfo(Request request) {
        Request r;
        String name = "Check";
        ArrayList<String> info = new ArrayList<>();
        Reservation res = null;
        String discount = "";
        String luggage = "";
        Controller.getInstance().getFrame().getAreaInfo().appendText(new Date() + "\n" + "Checking trip for #" + Flow.getInetAddress() + " client." + '\n' + "~~~~~~~~~~~~" + '\n');
        ArrayList<Reservation> temp = Connector.getInstance().readAllReservations();
        double tPrice = 0;
        for (Reservation R : temp) {
            if (R.getLocationA().equalsIgnoreCase(request.getParametres().get(0)) && R.getLocationB().equalsIgnoreCase(request.getParametres().get(1)) && R.getDate().equalsIgnoreCase(request.getParametres().get(2)) && R.getTime().equalsIgnoreCase(request.getParametres().get(3)) && R.getCompany().equalsIgnoreCase(request.getParametres().get(4)) && R.getType().equalsIgnoreCase(request.getParametres().get(5))) {
                res = R;
                break;
            }
        }
        if (res == null) {

            info.add("null");
            Request rq = new Request(name, info);
            return rq;

        }
        if (request.getParametres().get(6).equalsIgnoreCase("null")) {
            discount = "Without";
        } else {
            discount = request.getParametres().get(6);
        }
        if (request.getParametres().get(7).equalsIgnoreCase("null")) {
            luggage = "0";
        } else {
            luggage = request.getParametres().get(7);

        }
        if (res != null) {
            if (res.getNmTickets() > 0) {
                tPrice += res.getPrice();
                tPrice = checkDiscount(discount, tPrice);
                tPrice += Integer.parseInt(luggage) * 120;
            }
        }
        info.add("" + tPrice);
        info.add(res.getNmTickets() + "");
        r = new Request(name, info);
        return r;

    }

    private static Request insertbooking(Request request) {

        Request r;
        String fName = "";
        ArrayList<String> parameters = new ArrayList<>();
        ArrayList<Reservation> temp = Connector.getInstance().readAllReservations();
        Controller.getInstance().getFrame().getAreaInfo().appendText(new Date() + "\n" + "Inserting reservation to database for #" + Flow.getInetAddress() + " client." + '\n' + "~~~~~~~~~~~~" + '\n');

        Reservation res;
        for (Reservation R : temp) {
            if (R.getLocationA().equalsIgnoreCase(request.getParametres().get(0)) && R.getLocationB().equalsIgnoreCase(request.getParametres().get(1)) && R.getDate().equalsIgnoreCase(request.getParametres().get(2)) && R.getTime().equalsIgnoreCase(request.getParametres().get(3)) && R.getCompany().equalsIgnoreCase(request.getParametres().get(4)) && R.getType().equalsIgnoreCase(request.getParametres().get(5))) {
                if (R.getNmTickets() > 0) {
                    res = R;
                    fName = Connector.getInstance().insertBooking(res, request.getParametres());
                    break;
                } else {
                    fName = "unsuccess";
                }

            }
        }

        r = new Request(fName, parameters);
        return r;
    }

     static double checkDiscount(String discount, double tPrice) {
        double price = tPrice;
        switch (discount) {
            case "Student":
                price *= 0.8;
                break;
            case "Retiree":
                price *= 0.95;
                break;
            case "Without":
                price = tPrice;
                break;
        }
        return price;
    }
}
