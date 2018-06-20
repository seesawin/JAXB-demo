package tw.com.seesawin.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ELEMENTARY-STREAM")
@XmlType(propOrder = { "audioLanguage" })
public class PMTs_CHANNEL_ELEMENTARY_STREAM {
	
	@XmlElement(name = "AUDIO-LANGUAGE")
	private String audioLanguage;

	public String getAudioLanguage() {
		return audioLanguage;
	}

	public void setAudioLanguage(String audioLanguage) {
		this.audioLanguage = audioLanguage;
	}
}
