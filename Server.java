import java.io.*;
import java.net.*;
import java.time.LocalDateTime;

class ChatServer
{
    public static void main(String A[]) throws Exception
    {
        System.out.println("Server application is Running...");

        ServerSocket ssobj = new ServerSocket(2100);

        System.out.println("Server is waiting at port 2100");

        Socket sobj = ssobj.accept();

        System.out.println("Client Request gets Accepted Successfully");

        PrintStream pobj = new PrintStream(sobj.getOutputStream());

        BufferedReader bobj1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

        BufferedReader bobj2 = new BufferedReader(new InputStreamReader(System.in));

        // Create log file
        FileWriter fw = new FileWriter("ChatLog.txt", true);
        PrintWriter log = new PrintWriter(fw, true);

        log.println("----------- Chat Session Started -----------");
        log.println("Session Time: " + LocalDateTime.now());

        System.out.println("----------------------------------------------------");
        System.out.println("-------------- Marvellous Chat Server --------------");
        System.out.println("----------------------------------------------------");

        String str1 = null, str2 = null;

        while((str1 = bobj1.readLine()) != null)
        {
            System.out.println("Client says: " + str1);

            // Store client message
            log.println(LocalDateTime.now() + " Client: " + str1);

            System.out.println("Enter Message for Client");

            str2 = bobj2.readLine();

            if(str2 == null)
            {
                break;
            }

            pobj.println(str2);

            // Store server message
            log.println(LocalDateTime.now() + " Server: " + str2);
        }

        log.println("----------- Chat Session Ended -----------");
        log.close();

        sobj.close();
        ssobj.close();
    }
}