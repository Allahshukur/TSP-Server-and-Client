/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author sarkhanrasullu
 */
public class TCPClient {

    public static void main(String[] args) throws Exception {

        while (true) {
            Socket socket = new Socket("37.26.34.24", 80);
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            byte[] bytes = new Scanner(System.in).nextLine().getBytes();
            dataOutputStream.writeInt(bytes.length);
            dataOutputStream.write(bytes);
            if (new String(bytes).equals("exit"))
                break;
            socket.close();
        }

    }
}
