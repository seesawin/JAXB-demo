package tw.com.seesawin.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CHANNEL")
@XmlType(propOrder = { "serviceNumber", "eitChannelEventList" })
public class EIT_CHANNEL {

	@XmlElement(name = "SERVICE-NUMBER")
	private String serviceNumber;

	@XmlElement(name = "EVENT")
	private List<EIT_CHANNEL_EVENT> eitChannelEventList;

	public String getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	public List<EIT_CHANNEL_EVENT> getEitChannelEventList() {
		return eitChannelEventList;
	}

	public void setEitChannelEventList(List<EIT_CHANNEL_EVENT> eitChannelEventList) {
		this.eitChannelEventList = eitChannelEventList;
	}
	
}
