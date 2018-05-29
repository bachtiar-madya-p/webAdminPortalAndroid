/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 *
 * @author root
 */
public class ip {

    public static void main(String args[]) throws Exception {

    }

    public static String getIp() throws SocketException, IOException {
        String ip = null;
        int port = 8808;
        InetAddress ia = null;
        try {
            NetworkInterface ni = NetworkInterface.getByName("wlan0");
            Enumeration e = ni.getInetAddresses();
            if (!e.hasMoreElements()) {
                ia = (InetAddress) e.nextElement();
            }
            ServerSocket ss = new ServerSocket(port, 20, ia);
            Socket s = ss.accept();
            ip = s.toString();
        } catch (UnknownHostException e) {

        }
        return ip;
    }
}
