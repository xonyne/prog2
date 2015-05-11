package chat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

public class ChatSenderSerialize {
	public static void main(String[] args) throws MqttSecurityException,
			MqttException, IOException {
		sendMessage();
	}

	private static void sendMessage() throws MqttSecurityException,
			MqttException, IOException {
		MqttClient mqttClient = new MqttClient("tcp://iot.eclipse.org:1883",
				"ch.bfh.fbi.sutek1.sender");
		mqttClient.connect();
		while (true) {
			String payloadString = JOptionPane.showInputDialog("Talk");
			if (payloadString == null) {
				break;
			}
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(payloadString);
			oos.close();
			MqttMessage message = new MqttMessage(baos.toByteArray());
			mqttClient.publish("ch/bfh/fbi/talk/sutek1", message);
		}
		mqttClient.disconnect();
	}
}
