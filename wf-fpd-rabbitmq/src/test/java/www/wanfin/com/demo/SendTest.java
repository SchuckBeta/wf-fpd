package www.wanfin.com.demo;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;

public class SendTest {
	
	private static String QUEUE_NAME="testQueue";

	public static void main(String[] argv) throws Exception{
		//create connection
		 // 1、创建rabbitmq服务连接
	      // 2、创建连接队列的channel
	      // 3、创建队列
	      // 4、发送消息
	      // 5、关闭连接和channel
		System.out.println("11111111111111");
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("127.0.0.1");
		factory.setPort(5672);
		factory.setUsername("root");
		factory.setPassword("123456");
		factory.setVirtualHost("/");
		
		Connection connection = factory.newConnection();
		//create channel
		Channel channel = connection.createChannel();
		//create queue
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "Hello World!";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");
		//finally
		channel.close();
		connection.close();
	}
	
}
