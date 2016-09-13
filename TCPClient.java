import java.io.*;
import java.net.*;

class TCPClient {
 public static void main(String argv[]) throws Exception{
  String sentence;   // Lowercase sentence from user.
  String modifiedSentence; // Stores uppercase reply from server.
  
  // Input stream - from user keyboard.
  BufferedReader fromUser = new BufferedReader(
    new InputStreamReader(System.in));
  
  // Creates the Client socket and binds to the server
  // at localhost, port 4444
  Socket clientSocket = new Socket("localhost", 4444);
  
  // Output stream to send the sentence through this.
  DataOutputStream toServer = new DataOutputStream(clientSocket.getOutputStream());
  
  // Input stream to read the capitalized sentence from server.
  BufferedReader fromServer = new BufferedReader(
    new InputStreamReader(clientSocket.getInputStream()));
  
  System.out.print("Client> ");
  
  sentence = fromUser.readLine();
  toServer.writeBytes(sentence + '\n');
  
  modifiedSentence = fromServer.readLine();
  System.out.println("Server>" + modifiedSentence);
  clientSocket.close(); // TCP Client sends the close message to server.
 }
}

