package com.pb.kopejkin.hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class Client extends JFrame {
    private static final String serverIp = "127.0.0.1";
    private static final int serverPort = 1234;

    private Socket server;
    private BufferedReader inMsg;
    private PrintWriter outMsg;

    private JTextArea jtAreaMessage;
    private JTextField jtfMessage;

    public Client() {
        try {
            server = new Socket(serverIp, serverPort);
            inMsg = new BufferedReader(new InputStreamReader(server.getInputStream()));
            outMsg = new PrintWriter(server.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        setBounds(600, 300, 600, 500);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jtAreaMessage = new JTextArea();
        jtAreaMessage.setEditable(false);
        jtAreaMessage.setLineWrap(true);
        add(jtAreaMessage, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        jtfMessage = new JTextField();
        bottomPanel.add(jtfMessage, BorderLayout.CENTER);
        JButton jbSendMessage = new JButton("Отправить");
        bottomPanel.add(jbSendMessage, BorderLayout.EAST);

        jbSendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jtfMessage.getText().trim().isEmpty()) {
                    sendMsg();
                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String dataFromServer;
                    while ((dataFromServer = inMsg.readLine()) != null) {
                        jtAreaMessage.append(dataFromServer);
                        jtAreaMessage.append("\n");
                    }
                } catch (Exception e) {
                }
            }
        }).start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    outMsg.println("Отключился");
                    outMsg.close();
                    inMsg.close();
                    server.close();
                } catch (IOException exc) {
                }
            }
        });

        setVisible(true);
    }

    public void sendMsg() {
        String messageStr = jtfMessage.getText();
        outMsg.println(messageStr);
        jtfMessage.setText("");
    }
}
