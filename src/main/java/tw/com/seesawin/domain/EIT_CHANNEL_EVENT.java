package tw.com.seesawin.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import tw.com.seesawin.util.DateAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "EVENT")
@XmlType(propOrder = { "startUtcDate", "name", "eitChannelEventDescriptor" })
public class EIT_CHANNEL_EVENT {
	
	@XmlElement(name = "START-UTC-DATE")	
	@XmlJavaTypeAdapter(value=DateAdapter.class)
	private String startUtcDate;
	
	@XmlElement(name = "NAME")
	private String name;

	@XmlElement(name = "DESCRIPTOR")
	private List<EIT_CHANNEL_EVENT_DESCRIPTOR> eitChannelEventDescriptor;
	
	public String getStartUtcDate() {
		return startUtcDate;
	}

	public void setStartUtcDate(String startUtcDate) {
		this.startUtcDate = startUtcDate;
	}

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
