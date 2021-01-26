package client;

import java.net.ServerSocket;

public class MyClient {

    private ServerService serverService;

    public MyClient () {
        serverService = new SocketServerService();
        serverService.openConnection();
    }

}
