package tw.com.seesawin.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class HexConvter extends XmlAdapter<String, String> {
	
	@Override
	public String unmarshal(String dateStr) throws Exception {
		StringBuffer sb = new StringBuffer();
		String[] arr = dateStr.split(" ");
		for (String s : arr) {
			// HEXadecimal t0 BigDecimal
			// ...
			// BigDecimal to ASCII
			// ...
		}

		return dateStr;
	}

	@Override
	public String marshal(String date) throws Exception {
		return null;
	}

}
