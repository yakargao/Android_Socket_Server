package gaoyanshan.app;

import gaoyanshan.socket.CmdServerSocket;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;

public class ServerSocketApp {
    public static void main(String[] args) {
        // TODO Auto-generated method stuba
        boolean isFail=true;

//        OutputStreamWriter writer;
//        BufferedOutputStream os = null;
        while (true){
            try {
                if (isFail==true)
                {
                    CmdServerSocket serverSocket= new CmdServerSocket();
                    serverSocket.work();
//                    os = new BufferedOutputStream(serverSocket.getSocket().getOutputStream());
//                    writer=new OutputStreamWriter(os,"UTF-8");//尝试将字符编码改成"GB2312"
//                    writer.flush();
//                    writer.close();
                    isFail=false;
                }

            } catch (Exception e) {
                isFail=true;

                e.printStackTrace();
            }
        }

//        boolean isFail=true;
//        while (true){
//            try {
//                if(isFail){
//                    isFail=false;
//
//                }
//
//            } catch (Exception e) {
//                isFail=true;
//                e.printStackTrace();
//            }
//        }
    }
}
