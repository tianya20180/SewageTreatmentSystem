package com.qdu.diaisheng.Server;

import com.qdu.diaisheng.dao.DataModelDao;
import com.qdu.diaisheng.dao.DataPointDao;
import com.qdu.diaisheng.dao.DataVauleDao;
import com.qdu.diaisheng.entity.DataModel;
import com.qdu.diaisheng.entity.DataPoint;
import com.qdu.diaisheng.entity.DataValue;
import com.qdu.diaisheng.entity.RequestDataConfig;
import com.qdu.diaisheng.util.ByteUtil;

import com.qdu.diaisheng.util.UnitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import sun.tools.jconsole.Plotter;


import javax.print.DocFlavor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Srever {



    @Autowired
    private DataModelDao dataModelDao;
    @Autowired
    private DataPointDao dataPointDao;
    @Autowired
    private DataVauleDao dataVauleDao;

    public static int PORT=20001;
    public static RequestDataConfig requestDataConfig[]=new RequestDataConfig[5];

    public static ServerSocket createSocket() throws IOException {
        ServerSocket socketServer=new ServerSocket();

        return socketServer;
    }

    public void initRequestConfig(){

    }


    public void addValue(){

    }



    public static void initSocket(ServerSocket serverSocket) throws SocketException {
        serverSocket.setReuseAddress(true);
        serverSocket.setReceiveBufferSize(6*1024*1024);
        serverSocket.setPerformancePreferences(2,2,1);
    }


    public static void main(String[] args) throws IOException {

        requestDataConfig[0]=new RequestDataConfig();
       requestDataConfig[0].setSlavaId(1);
       requestDataConfig[0].setLength((short) 16);
       requestDataConfig[0].setMessage(new int[]{0x01, 0x03, 0x00, 0x00, 0x00, 0x0C, 0x45,0xCF});
       requestDataConfig[0].setType(new String[]{"int16","float32","int32","float32"});
       requestDataConfig[0].setColumn(new String[]{"1","2","3","4","5"});

        requestDataConfig[1]=new RequestDataConfig();
        requestDataConfig[1].setSlavaId(2);
        requestDataConfig[1].setLength((short) 20);
        requestDataConfig[1].setMessage(new int[]{0x02, 0x03, 0x00, 0x00, 0x00, 0x04, 0x44,0x3A});
        requestDataConfig[1].setType(new String[]{"uint16","uint16","uint32","uint16"});
        requestDataConfig[1].setColumn(new String[]{"","","","",""});

        requestDataConfig[2]=new RequestDataConfig();
        requestDataConfig[2].setSlavaId(3);
        requestDataConfig[2].setLength((short) 20);
        requestDataConfig[2].setMessage(new int[]{0x03, 0x03, 0x00, 0x00, 0x00, 0x0C, 0x44,0x4B});
        requestDataConfig[2].setType(new String[]{"uint16","uint16","uint32","uint16"});
        requestDataConfig[2].setColumn(new String[]{"","","","",""});


        requestDataConfig[3]=new RequestDataConfig();
        requestDataConfig[3].setSlavaId(4);
        requestDataConfig[3].setLength((short) 20);
        requestDataConfig[3].setMessage(new int[]{0x04, 0x03, 0x00, 0x00, 0x00, 0x0C,0x44,0x4B});
        requestDataConfig[3].setType(new String[]{"uint16","uint16","uint32","uint16"});
        requestDataConfig[3].setColumn(new String[]{"","","","",""});


        requestDataConfig[4]=new RequestDataConfig();
        requestDataConfig[4].setSlavaId(5);
        requestDataConfig[4].setLength((short) 20);
        requestDataConfig[4].setMessage(new int[]{0x05, 0x03, 0x00, 0x00, 0x00, 0x0C, 0x45,0xCF});
        requestDataConfig[4].setType(new String[]{"uint16","uint16","uint32","uint16"});
        requestDataConfig[4].setColumn(new String[]{"","","","",""});


       ServerSocket serverSocket=createSocket();
       initSocket(serverSocket);
       serverSocket.bind(new InetSocketAddress(Inet4Address.getLocalHost(),PORT),50);

       System.out.println("start server successful......");
       while (true){
           Socket clientSocket=serverSocket.accept();
           System.out.println("accept tcp client "+clientSocket.getRemoteSocketAddress().toString());
           ClientHander clientHander=new ClientHander(clientSocket);
           clientHander.start();
       }



    }




    private static class ClientHander extends Thread{

        private Socket socket;
        private boolean flag=true;
        public ClientHander(Socket socket){
            this.socket=socket;
        }







        public long getTimeStamp() throws ParseException {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = df.parse(new Date().toString());
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            long timestamp = cal.getTimeInMillis();
            return timestamp;
        }


        public Map<String,Object> getValue(RequestDataConfig requestDataConfig,byte[]results) throws ParseException {

            Map<String,Object>data=new HashMap<String,Object>();
            //data.put("tsp",getTimeStamp());
            int pos=0,flen=0;
            int i=0;
            for(String type:requestDataConfig.getType()){
                System.out.println("columns:"+requestDataConfig.getColumn()[i]);
                pos=pos+flen;

                float v=0;
                switch (type){
                    case "int16":
                        short int16=ByteUtil.getShort(results,pos);
                        System.out.println(int16);
                        flen=2;
                        break;
                    case "int32":
                        int int32=ByteUtil.getInt(results,pos);
                        System.out.println(int32);
                        flen=4;
                        break;
                    case "int64":
                        long int64=ByteUtil.getLong(results,pos);
                        System.out.println(int64);
                        flen=4;
                        break;
                    case "uint16":
                        int unit16;
                        unit16= UnitUtil.getUint16(ByteUtil.getInt(results,pos));
                        System.out.println(unit16);
                        flen=2;
                        break;
                    case "uint32":
                        long unit32;
                        unit32= UnitUtil.getUint32(ByteUtil.getLong(results,pos));
                        System.out.println(unit32);
                        flen=4;
                        break;
                    case "float32":
                        float float32;
                        float32=ByteUtil.getFloat(results,pos);
                        System.out.println(float32);
                        flen=4;
                        break;
                    case "float64":
                        double float64;
                        float64=ByteUtil.getDouble(results,pos);
                        flen=8;
                        System.out.println(float64);
                        break;
                    default:
                        System.out.println("error");



                }

                if(requestDataConfig.getColumn()[i]!="NG"){
                    data.put(requestDataConfig.getColumn()[i],v);
                }


                i++;
            }
            //System.out.println(data);
            return data;

        }

        @Override
        public void run(){

                super.run();
                System.out.println("start comm");
             //   for(RequestDataConfig request:requestDataConfig){
                    RequestDataConfig request=requestDataConfig[0];
                    System.out.println(request.getSlavaId());

                    byte[] sendBuffer=new byte[128];
                    byte[] receiveBuffer=new byte[512];
                    int cursor=0;
                    OutputStream outputStream;
                    InputStream inputStream;


                    try {
                        outputStream=socket.getOutputStream();
                        inputStream=socket.getInputStream();


                        ByteBuffer byteBuffer=ByteBuffer.wrap(sendBuffer);
                        for(int i=0;i<request.getMessage().length;i++){

                            byteBuffer.putInt(request.getMessage()[i]);
                        }

                        outputStream.write(sendBuffer,0,byteBuffer.position()+1);

                        System.out.println("byteBuffer"+byteBuffer+"sendBuffer"+sendBuffer);

                        int readCnt=inputStream.read(receiveBuffer);
                        System.out.println(readCnt);
                        if(readCnt>0){

                            getValue(request,receiveBuffer);


                        }else{
                            System.out.println("can't receive:" + readCnt);
                        }

                        getValue(request,receiveBuffer);


                    }catch (Exception e){

                      ///  System.out.println(e.getStackTrace());
                    }finally {

                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }




                //    break;

               // }





        }




    }

}
