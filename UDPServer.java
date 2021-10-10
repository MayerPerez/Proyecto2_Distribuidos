
import java.net.*;
import java.io.*;
import java.lang.management.ManagementFactory;
import java.time.LocalTime;

public class UDPServer{

    public static void main(String args[]){
        DatagramSocket rSocket = null;
        DatagramSocket eSocket = null;
        try{
            LocalTime t_act = LocalTime.now();
            int p_esc = Integer.parseInt(args[0]);
            int p_env = Integer.parseInt(args[1]);
            rSocket = new DatagramSocket(p_esc);
            byte[] buffer = new byte[1000];
            //System.out.println("Servidor:");
            while(true){
                //Creamos y enviamos token
                String id = ManagementFactory.getRuntimeMXBean().getName();
                Token token = new Token(InetAddress.getLocalHost().getHostAddress(),p_esc,p_env,id,t_act,LocalTime.now());
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(outputStream);
                os.writeObject(token);
                eSocket = new DatagramSocket();
                byte [] m =outputStream.toByteArray();
                InetAddress aHost = InetAddress.getByName("localhost");
                DatagramPacket request = new DatagramPacket(m, m.length, aHost, p_env);
                eSocket.send(request);
                //Recibimos token
                DatagramPacket requestR = new DatagramPacket(buffer, buffer.length);
                rSocket.receive(requestR);
                byte[] data = requestR.getData();
                ByteArrayInputStream in = new ByteArrayInputStream(data);
                ObjectInputStream is = new ObjectInputStream(in);
                try{
                    Token dato = (Token) is.readObject();
                    System.out.println(dato);
                    System.out.println("\n\n");
                } catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
                try{
                    Thread.sleep(3000);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        } catch (SocketException e){System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {System.out.println("IO: " + e.getMessage());
        } finally {if (rSocket != null) rSocket.close();}
    }
}