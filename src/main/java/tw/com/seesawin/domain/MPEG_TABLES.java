package tw.com.seesawin.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "MPEG-TABLES")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "pmts" })
public class MPEG_TABLES implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "PMTs")
	private PMTs pmts;

	public PMTs getPmts() {
		return pmts;
	}

	public void setPmts(PMTs pmts) {
		this.pmts = pmts;
	}
}
