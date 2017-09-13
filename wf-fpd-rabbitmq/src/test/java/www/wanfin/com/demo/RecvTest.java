package www.wanfin.com.demo;

import java.io.IOException;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;


public class RecvTest {
	
	private static String QUEUE_NAME="testQueue";

/*	public static void main(String[] argv) throws Exception{
		
	   // 1、创建rabbitmq服务连接
       // 2、建立到队列的channel
       // 3、处理消息的回调
       // 4、处理消息
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("127.0.0.1");
		factory.setPort(5672);
		factory.setUsername("root");
		factory.setPassword("123456");
		factory.setVirtualHost("/");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    //we declare the queue here, as well. Because we might start the consumer before the publisher 
	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    System.out.println(" [*] Waiting for messages.");
	    
	    Consumer consumer = new DefaultConsumer(channel) {
    	  @Override
    	  public void handleDelivery(String consumerTag, Envelope envelope,
    	                             AMQP.BasicProperties properties, byte[] body)
    	      throws IOException {
    	    String message = new String(body, "UTF-8");
    	    System.out.println(" [x] Received '" + message + "'");
    	  }
    	};
    	channel.basicConsume(QUEUE_NAME, true, consumer);
    	
	}*/
	
}
