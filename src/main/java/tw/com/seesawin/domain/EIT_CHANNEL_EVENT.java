package tw.com.seesawin.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "EVENT")
@XmlType(propOrder = { "name", "eitChannelEventDescriptor" })
public class EIT_CHANNEL_EVENT {
	
	@XmlElement(name = "NAME")
	private String name;

	@XmlElement(name = "DESCRIPTOR")
	private List<EIT_CHANNEL_EVENT_DESCRIPTOR> eitChannelEventDescriptor;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EIT_CHANNEL_EVENT_DESCRIPTOR> getEitChannelEventDescriptor() {
		return eitChannelEventDescriptor;
	}

	public void setEitChannelEventDescriptor(List<EIT_CHANNEL_EVENT_DESCRIPTOR> eitChannelEventDescriptor) {
		this.eitChannelEventDescriptor = eitChannelEventDescriptor;
	}

}
