import java.io.*;
import java.net.*;

class Clientsort {
    public static void main(String argv[]) throws Exception{
        //String sentence;   // Lowercase sentence from user.
        //String modifiedSentence; // Stores uppercase reply from server.
        int n;
        String names[]=new String[100];
        names[0] ={'hii'};
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

        System.out.print("enter no of names ");
        n=Integer.parseInt(fromUser.readLine());
        //sentence = fromUser.readLine();
        toServer.writeBytes(n+"\n");
        for(int i =0; i<n;i++)
        {
            names[i]=fromUser.readLine();
            toServer.writeBytes(names[i]+"\n");
        }
        System.out.println("From server:\n");
        for(int j=0;j<n;j++)
        {
            names[j]=fromServer.readLine();
            System.out.println(names[j]);
        }

        //modifiedSentence = fromServer.readLine();
        //System.out.println("Server>" + modifiedSentence);
        clientSocket.close(); // TCP Client sends the close message to server.
    }
}