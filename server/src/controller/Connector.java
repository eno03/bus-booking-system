/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import data.Reservation;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Server;

/**
 *
 * @author wint4
 */
public class Connector {

    private static Connector instance = null;
    private Connection connection;
    private String url = "jdbc:mysql://localhost/reservation";
    private String user = "root";
    private String pass = "";
    private String query = "";

    public static Connector getInstance() {
        if (instance == null) {
            instance = new Connector();
        }
        return instance;
    }

    private Connector() {

        try {
            connection = (Connection) DriverManager.getConnection(url, user, pass);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnnection() throws SQLException {
        connection.close();
    }

    public ArrayList<Reservation> readAllReservations() {
        ArrayList<Reservation> reservations = new ArrayList<>();
        query = "SELECT\n"
                + "    *\n"
                + "FROM\n"
                + "    reservation res\n"
                + "JOIN location loca ON\n"
                + "    res.id_locationA = loca.id\n"
                + "JOIN location locb ON\n"
                + "    res.id_locationB = locb.id\n"
                + "JOIN company comp ON\n"
                + "    comp.id = res.id_company\n"
                + "JOIN DATE dat ON\n"
                + "    dat.id = res.id_date\n"
                + "JOIN TIME tim ON\n"
                + "    tim.id = res.id_time\n"
                + "JOIN TYPE typ ON\n"
                + "    typ.id = res.id_type";

        try {
            Statement statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String locationA = resultSet.getString(11);
                String locationB = resultSet.getString(13);
                String date = resultSet.getString(17);
                String time = resultSet.getString(19);
                String company = resultSet.getString(15);
                String type = resultSet.getString(21);
                int cena = resultSet.getInt(8);
                int nmTickets = resultSet.getInt(9);
                Reservation reservation = new Reservation(id, locationA, locationB, date, time, company, type, cena, nmTickets);
                reservations.add(reservation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reservations;
    }

    String insertBooking(Reservation res, ArrayList<String> parameters) {
        String locationA = res.getLocationA();
        String locationB = res.getLocationB();
        String date = res.getDate();
        String time = res.getTime();
        String company = res.getCompany();
        String type = res.getType();
        String discount = parameters.get(6);
        String luggage = parameters.get(7);
        String price = parameters.get(8);
        String name = parameters.get(9);
        String lastName = parameters.get(10);

        query = "INSERT INTO `purchased` (`id`, `ime`, `prezime`, `locationA`, `locationB`, `date`, `time`, `company`, `type`, `price`, `discount`, `luggage`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setInt(1, 0);
            ps.setString(2, name);
            ps.setString(3, lastName);
            ps.setString(4, locationA);
            ps.setString(5, locationB);
            ps.setString(6, date);
            ps.setString(7, time);
            ps.setString(8, company);
            ps.setString(9, type);
            ps.setInt(10, Integer.parseInt(price));
            ps.setString(11, discount);
            ps.setInt(12, Integer.parseInt(luggage));
            ps.execute();
            edit(res);
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        Controller.getInstance().getFrame().getAreaInfo().appendText("Client #" + Server.getClientNo() + " is booked a ticket at" + new Date() + '\n');

        return "success";

    }

    private void edit(Reservation res) {
        int id = res.getId();
        int num = res.getNmTickets() - 1;
        query = "UPDATE `reservation` SET tickets = ? WHERE id = ?";
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setInt(1, num);
            ps.setInt(2, id);
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
