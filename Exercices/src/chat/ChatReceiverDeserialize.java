package chat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;



import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

public class ChatReceiverDeserialize {
	public static void main(String[] args) throws MqttSecurityException,
			MqttException, IOException {
		receiveMessage();
	}

	private static void receiveMessage() throws MqttSecurityException,
			MqttException, IOException {
		MqttClient mqttClient = new MqttClient("tcp://iot.eclipse.org:1883",
				"ch.bfh.fbi.sutek1.listener");
		mqttClient.setCallback(new MqttCallback() {

			@Override
			public void connectionLost(Throwable throwable) {
			}

			@Override
			public void messageArrived(String string, MqttMessage mm)
					throws Exception {

				System.out.printf("From (%s):", string);

				try {
					ByteArrayInputStream bais = new ByteArrayInputStream(mm.getPayload());
					ObjectInputStream ois = new ObjectInputStream(bais);
					System.out.println(ois.readObject());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
			}

			@Override
			public void deliveryComplete(IMqttDeliveryToken imdt) {
			}
		});
		MqttConnectOptions options = new MqttConnectOptions();
		options.setCleanSession(false);
		mqttClient.connect(options);
		mqttClient.subscribe("ch/bfh/fbi/talk/<kürzel>");
		System.in.read();

	}
}
