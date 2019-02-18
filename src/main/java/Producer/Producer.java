package Producer;

/*
*
* A Simple class to produce event(s)
* Author: Manish A.Shetty
*
* */

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import Connection.Connection;

public class Producer
{
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException, TimeoutException, InterruptedException
    {
        int count=5000;
        String data="Vishnu and Krishna";
        Channel firstChannel = new Connection().connect();

        firstChannel.exchangeDeclare("FirstExchange", BuiltinExchangeType.DIRECT);
        firstChannel.queueDeclare("FirstQueue",true,false,false,null);
        firstChannel.queueBind("FirstQueue","FirstExchange","");

        while(true)
        {
            firstChannel.basicPublish("FirstExchange","FirstQueue",null,data.getBytes());
            Thread.sleep(5000);
            System.out.println("Published: "+data);
        }
    }


}


