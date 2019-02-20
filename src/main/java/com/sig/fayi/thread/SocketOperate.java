package com.sig.fayi.thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketOperate extends Thread{
    private Socket socket;

    public SocketOperate(Socket socket) {
        this.socket=socket;
    }
    @SuppressWarnings("unused")
    public void run()
    {
        try{
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            while(scanner.hasNextLine()){
                String str = scanner.nextLine();
                System.out.println(str);
                Scanner s = new Scanner(System.in);
                if (s.hasNextLine()) {
                    String  msg = s.nextLine();
                    pw.println(msg);
                    pw.flush();
                }
            }
            socket.close();
            scanner.close();

        }catch(IOException ex){

        }finally{

        }
    }
}
