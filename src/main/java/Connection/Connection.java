package Connection;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Connection
{

    ConnectionFactory conFactory=null;

    public Channel connect() throws IOException, TimeoutException
    {
        conFactory = new ConnectionFactory();
        conFactory.setHost("localhost");
        conFactory.setUsername("guest");
        conFactory.setPassword("guest");
        conFactory.setConnectionTimeout(3000);
        com.rabbitmq.client.Connection connection=conFactory.newConnection();
        Channel mychannel=connection.createChannel();
        return mychannel;
    }


}
