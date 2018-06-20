package tw.com.seesawin.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CHANNEL")
@XmlType(propOrder = { "serviceNumber", "elementaryStreamList" })
public class CHANNEL {

	@XmlElement(name = "SERVICE-NUMBER")
	private String serviceNumber;

	@XmlElement(name = "ELEMENTARY-STREAM")
	private List<ELEMENTARY_STREAM> elementaryStreamList;

	public String getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	public List<ELEMENTARY_STREAM> getElementaryStreamList() {
		return elementaryStreamList;
	}

	public void setElementaryStreamList(List<ELEMENTARY_STREAM> elementaryStreamList) {
		this.elementaryStreamList = elementaryStreamList;
	}
}
