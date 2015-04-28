package dice;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import xmlToObject.XMLHelper;

@XmlType(name = "Dice", propOrder = { "minValue", "maxValue", "actValue",
		"statistics" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = "http://ch.fbi.xml.Dice", name = "statisticalDice")
public class Dice {
	@XmlElement(name = "statistics", nillable = false, required = true)
	private int[] statistics;
	@XmlElement(name = "minValue", nillable = false, required = true)
	private int minValue;
	@XmlElement(name = "maxValue", nillable = false, required = true)
	private int maxValue;
	@XmlElement(name = "actValue", nillable = false, required = true)
	private int actValue;
	
	@SuppressWarnings("unused")
	private Dice() {
		// only for JAXB -> Constructor without arguments is required
	}

	public Dice(int minValue, int maxValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.statistics = new int[this.maxValue - this.minValue + 1];
	}

	public void play() {
		this.actValue = (int) (minValue + (Math.random() * maxValue));
		this.statistics[actValue - minValue]++;
	}

	public int getMinValue() {
		return minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public int getActValue() {
		return actValue;
	}

	public int[] getStatistics() {
		return statistics.clone();
	}

	@Override
	public String toString() {
		return "[actValue=" + this.actValue + ", minValue=" + this.minValue
				+ ", maxValue=" + this.maxValue + "]";
	}

}
