package com.example.karec.a8_americain.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.karec.a8_americain.R;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.Enumeration;

import io.socket.client.Socket;

/**
 * Created by Karec on 18/04/2017.
 */

public class SalonPartie extends AppCompatActivity {
    private TextView viewIP;
    private TextView viewPORT;
    private TextView viewJOUEUR;
    ServerSocket serverSocket;
    String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salon_partie);
        viewIP = (TextView) findViewById(R.id.textViewIP);
        viewPORT = (TextView) findViewById(R.id.textViewPORT);
        viewJOUEUR = (TextView) findViewById(R.id.textViewJoueur);

        viewIP.setText(getIpAddress());
        Thread socketServerThread = new Thread(new SocketServerThread());
        socketServerThread.start();
    }




    private class SocketServerThread extends Thread {

        static final int SocketServerPORT = 8080;
        int count = 0;

        @Override
        public void run() {
            try{
                serverSocket = new ServerSocket(SocketServerPORT);
                SalonPartie.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        viewPORT.setText(serverSocket.getLocalPort()+"");
                    }
                });
                while (true) {
                    java.net.Socket socket = serverSocket.accept();
                    count++;
                    message += "connexion reussie de " + socket.getInetAddress()
                            + ":" + socket.getPort() + "\n";

                    SalonPartie.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            viewJOUEUR.setText(message);
                        }
                    });

                    SocketServerReplyThread socketServerReplyThread = new SocketServerReplyThread(
                            socket, count);
                    socketServerReplyThread.run();

                }
            } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            }
        }
    }



    //utiliser pour "renvoyer un message"
    private class SocketServerReplyThread extends Thread {

        private java.net.Socket hostThreadSocket;
        int cnt;

        SocketServerReplyThread(java.net.Socket socket, int c) {
            hostThreadSocket = socket;
            cnt = c;
        }
        @Override
        public void run() {
            OutputStream outputStream;
            String msgReply = "\nHello";

            try {
                outputStream = hostThreadSocket.getOutputStream();
                PrintStream printStream = new PrintStream(outputStream);
                printStream.print(msgReply);
                printStream.close();

                message += "replayed: " + msgReply + "\n";

                SalonPartie.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        viewJOUEUR.setText(message);
                    }
                });

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                message += "Something wrong! " + e.toString() + "\n";
            }

            SalonPartie.this.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    viewJOUEUR.setText(message);
                }
            });
        }
    }










    private String getIpAddress() {
        String ip = "";
        try {
            Enumeration<NetworkInterface> enumNetworkInterfaces = NetworkInterface
                    .getNetworkInterfaces();
            while (enumNetworkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = enumNetworkInterfaces
                        .nextElement();
                Enumeration<InetAddress> enumInetAddress = networkInterface
                        .getInetAddresses();
                while (enumInetAddress.hasMoreElements()) {
                    InetAddress inetAddress = enumInetAddress.nextElement();

                    if (inetAddress.isSiteLocalAddress()) {
                        ip += "Votre adresse est : "
                                + inetAddress.getHostAddress() + "\n";
                    }

                }

            }

        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ip += "Something Wrong! " + e.toString() + "\n";
        }

        return ip;
    }










    public TextView getViewIP() {
        return viewIP;
    }

    public void setViewIP(TextView viewIP) {
        this.viewIP = viewIP;
    }

    public TextView getViewPORT() {
        return viewPORT;
    }

    public void setViewPORT(TextView viewPORT) {
        this.viewPORT = viewPORT;
    }
}
