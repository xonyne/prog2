package xmlToObjectStub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "DiceStatistics")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = "http://ch.fbi.xml.Dice", name = "statisticalDice")
public class DiceStatistics {
	
	@XmlElement(name = "statistics", nillable = false, required = true)
	private int[] statistics;

	private DiceStatistics() {
		// only for JAXB -> Constructor without arguments is required
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < statistics.length; i++) {
			sb.append(statistics[i] + ", ");
		}
		
		return "[statistics=" + sb.toString() + "]";
	}

}
