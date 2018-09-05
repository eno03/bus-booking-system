/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.Request;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author wint4
 */
public class Flow implements Runnable {

    private Socket client;
    private static InetAddress inetAddress;
    private ObjectOutputStream toClient;
    private ObjectInputStream fromClient;

    public Flow(Socket clientSocket) {
        this.client = clientSocket;
    }

    @Override
    public void run() {

        try {

            fromClient = new ObjectInputStream(client.getInputStream());
            toClient = new ObjectOutputStream(client.getOutputStream());
            inetAddress = client.getInetAddress();
            while (true) {
                Request request = (Request) fromClient.readObject();
                toClient.writeObject(Controller.decodeRequest(request));
            }

        } catch (IOException ex) {
            Controller.getInstance().getFrame().getAreaInfo().appendText(new Date() + "\n" + "Client with host name #" + Flow.getInetAddress() + " is disconnected." + '\n' + "~~~~~~~~~~~~" + '\n');

        } catch (ClassNotFoundException ex) {
            Controller.getInstance().getFrame().getAreaInfo().appendText(new Date() + "\n" + "Client with host name #" + Flow.getInetAddress() + " is disconnected." + '\n' + "~~~~~~~~~~~~" + '\n');
        }

    }

    public Socket getClient() {
        return client;
    }

    public void setClient(Socket client) {
        this.client = client;
    }

    public ObjectOutputStream getToClient() {
        return toClient;
    }

    public void setToClient(ObjectOutputStream toClient) {
        this.toClient = toClient;
    }

    public ObjectInputStream getFromClient() {
        return fromClient;
    }

    public void setFromClient(ObjectInputStream fromClient) {
        this.fromClient = fromClient;
    }

    public static InetAddress getInetAddress() {
        return inetAddress;
    }

}
