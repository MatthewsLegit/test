
import java.io.*;
import java.net.*;

class Client {
   public static void main(String argv[]) throws Exception
   {
    String sentence;
    String modifiedSentence;
    BufferedReader inFromUser; 
    BufferedReader inFromServer;
    Socket myClientSocket; 
    DataOutputStream outToServer;
    
    inFromUser = new BufferedReader(new InputStreamReader(System.in));
    myClientSocket = new Socket("192.168.0.19", 8080);
    outToServer = new DataOutputStream(myClientSocket.getOutputStream());
    inFromServer = new BufferedReader(new InputStreamReader(myClientSocket.getInputStream()));
  
    System.out.println("Enter a command");
    sentence = inFromUser.readLine();
  
    //write to server
    outToServer.writeBytes(sentence+'\n');
  
    modifiedSentence = inFromServer.readLine();
  
    System.out.println("FROM SERVER: "+modifiedSentence);
    
    myClientSocket.close();
   }
}
