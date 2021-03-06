import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.Inet4Address;

/**
 * Created by Tristen Tulkens and Jacob Smith on 2017-02-20.
 */
public class ServerConnection extends Connection{
    private ServerSocket server;

    public ServerConnection(){ }

    public static ServerSocket createServer(int port){
        ServerSocket server = null;
        boolean found = false;
        while(!found){
            //port++;
            try {
                server = new ServerSocket(port);
                System.out.println("Port opened on port "+port);
                 found  = true;
            }
            catch (IOException e) {
                System.err.println("Could not listen on port:  " + port);
                System.exit(-1);
            }
        }
        
		return server;
    }

    public void startConnection(ServerSocket server){
		this.server = server;
        Socket socket = null;
        try {
            socket = server.accept();
        }
        catch (IOException e) {
            System.err.println("Accept failed: " + e.getMessage());
            System.exit(-1);
        }
        super.startConnection(socket);
    }

    public void closeConnection(){
        try{
            server.close();
        }
        catch (IOException e) {
            System.err.println("Unable to close server");
        }
        super.closeConnection();
    }
}
