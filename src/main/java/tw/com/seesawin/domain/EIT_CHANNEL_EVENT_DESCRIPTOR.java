package tw.com.seesawin.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import tw.com.seesawin.util.HexConvter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DESCRIPTOR")
@XmlType(propOrder = { "data" })
public class EIT_CHANNEL_EVENT_DESCRIPTOR {

	@XmlElement(name = "DATA")
	@XmlJavaTypeAdapter(value=HexConvter.class)
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
