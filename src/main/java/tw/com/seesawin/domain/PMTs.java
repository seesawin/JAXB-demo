package tw.com.seesawin.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PMTs")
@XmlType(propOrder = { "channelList" })
public class PMTs {
	
	@XmlElement(name = "CHANNEL")
	private List<CHANNEL> channelList;

	public List<CHANNEL> getChannelList() {
		return channelList;
	}

	public void setChannelList(List<CHANNEL> channelList) {
		this.channelList = channelList;
	}
}
