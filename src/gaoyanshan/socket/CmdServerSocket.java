package gaoyanshan.socket;

import gaoyanshan.operator.Connect;
import gaoyanshan.operator.Dir;
import gaoyanshan.operator.KEY;
import gaoyanshan.operator.Open;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class CmdServerSocket {
    private int port = 6543;
    private OutputStreamWriter writer;
    private BufferedReader bufferedReader;
    private String response;
    private String receiveStr;
    private  Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public CmdServerSocket(){

    }
    public CmdServerSocket(int port) {
        super();
        this.port = port;
    }
    public void work() throws Exception {
        ServerSocket serverSocket=new ServerSocket(port);
        while(true){

            System.out.println("Waiting client to connect.....");
            socket = serverSocket.accept();//阻塞式，直到有客户端连接进来，才会继续往下执行，否则一直停留在此代码
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("Client connected from: "+socket.getRemoteSocketAddress().toString());

            BufferedOutputStream os = new BufferedOutputStream(socket.getOutputStream());//socket.getOutputStream()是输出流，BufferedOutputStream则将其封装为带缓冲的输出流


            OutputStreamWriter writer=new OutputStreamWriter(os,"UTF-8");//尝试将字符编码改成"GB2312"
            getAndDealCmd(socket);

            writer.close();
            socket.close();
            System.out.println("当前Socket服务结束");
        }
    }
    public void getAndDealCmd(Socket socket) throws Exception
    {
        InputStream inputStream = socket.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream, "utf-8");
        System.out.println(receiveStr);
        bufferedReader=new BufferedReader(reader);
        receiveStr=bufferedReader.readLine();
        String type=receiveStr.split(":")[0];
        int index=receiveStr.indexOf(":");
        String operator=receiveStr.substring(index+1,receiveStr.length());
        switch (type){
            case "conn":
                response=new Connect().exe("");
                break;
            case"dir":
                response=new Dir().exe(operator);
                break;
            case "open":
                response=new Open().exe(operator);
                break;
            case "key":
                response=new KEY().exe(operator);
                break;

        }
        writeBackMsg(socket);
    }
    private void writeBackMsg(Socket socket) throws Exception {
        // TODO Auto-generated method stub
        BufferedOutputStream os = new BufferedOutputStream(socket.getOutputStream());
        writer=new OutputStreamWriter(os,"UTF-8");//尝试将字符编码改成"GB2312"
        writer.write(response);
        writer.flush();


    }
}
