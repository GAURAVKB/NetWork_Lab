import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.lang.Iterable;

class Serversort {
    public static void main(String argv[]) throws Exception {
        //String clientSentence;  // Stores sentence sent by client.
        //String upperCaseSentence; // Uppercase sentence.

        // Creates a server socket, which waits for clients
        // to initiate connection.
        ServerSocket welcomeConnection = new ServerSocket(4444);
        String names[] = new String[100];
        while (true) {
            System.out.println("Waiting for clients to connect....");

            // Creates a new socket when a client contacts
            // the server for the first time.
            Socket connection = welcomeConnection.accept();

            System.out.println("Client Connected.");

            BufferedReader fromClient = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            DataOutputStream toClient = new DataOutputStream(
                    connection.getOutputStream());

            int n = Integer.parseInt(fromClient.readLine());
            System.out.println("no of names = "+n);
            for(int i=0 ;i<n ;i++)
            {
                names[i] =fromClient.readLine();
                System.out.println(names[i]);
                if(names[i]=="null")
                    break;
            }
            Arrays.sort(names);System.out.println(Arrays.toString(names));
            //for(String j : Arrays.toString(names))
            //{
             //   System.out.println(j);
              //  toClient.writeBytes(j+"\n");
            //}
            //clientSentence = fromClient.readLine();
            //System.out.println("Client sent: " + clientSentence);
            //upperCaseSentence = clientSentence.toUpperCase() + '\n';

            //toClient.writeBytes(upperCaseSentence);
        }
    }
}