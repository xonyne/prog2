package xmlToConsole;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace="http://ch.fbi.xml.beispielEins", name="time_unit")
public class TimeUnit {
	@XmlElement(name="unit_label")
	private String UNIT_LABEL;
	
	@XmlTransient
	private int secretNumber;
	
	public TimeUnit (String unitLabel, int secretNumber) {
		this.UNIT_LABEL = unitLabel;
		this.secretNumber = secretNumber;
	}
	
	@SuppressWarnings("unused")
	private TimeUnit() {
		//only for JAXB -> Constructor without arguments is required
	}
	
	public void setUnitLabel(String uLabel) {
		this.UNIT_LABEL = uLabel;
	}
	
	public String getUnitLabel() {
		return UNIT_LABEL;
	}
	
	@Override
	public String toString() {
		return this.UNIT_LABEL;
	}

}
