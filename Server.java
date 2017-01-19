import java.io.*;
import java.net.*;

class Server {
   
   public static void main(String argv[]) throws Exception
   {
    String clientSentence;
    String capitalizedSentence;
    String toSendBack;
    BufferedReader inFromClient;
    DataOutputStream outToClient;

    ServerSocket welcomeSocket = new ServerSocket(8080);
 
    while (true) {
       System.out.println("Server Ready");
       System.out.println("Local Port: " + welcomeSocket.getLocalPort());
       Socket connectionSocket = welcomeSocket.accept();
       System.out.println("Connected Port: " + connectionSocket.getPort());
    
       inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
       outToClient = new DataOutputStream(connectionSocket.getOutputStream());

       clientSentence = inFromClient.readLine();
       clientSentence = clientSentence.toUpperCase();
       if(clientSentence.contains("ADD")){
         toSendBack = "Request to Add has been noted";
       } else{
         toSendBack = "Request Unrecognised";
       }
       outToClient.writeBytes(toSendBack + "\n");
       System.out.println("End");
    }
   }

}

