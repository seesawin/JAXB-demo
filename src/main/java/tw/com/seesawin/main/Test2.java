package tw.com.seesawin.main;

import java.util.List;

import tw.com.seesawin.domain.CHANNEL;
import tw.com.seesawin.domain.ELEMENTARY_STREAM;
import tw.com.seesawin.domain.MPEG_TABLES;
import tw.com.seesawin.util.XMLUtil;

public class Test2 {
	public static void main(String[] args) {
		String path = "C:TEST\\NZ_PCH29_538M_Channel_ONE_Rating-AO-0_020912-1.xml";
		System.out.println("---将File类型的xml转换成对象 Start---");
		MPEG_TABLES table = (MPEG_TABLES) XMLUtil.convertXmlFileToObject(MPEG_TABLES.class, path);
		
		
		List<CHANNEL> channelList = table.getPmts().getChannelList();
		System.out.println("channel size : " + channelList.size());
		
		for(CHANNEL c : channelList) {
			System.out.println("ServiceNumber : " + c.getServiceNumber());
			List<ELEMENTARY_STREAM> elementaryStreamList = c.getElementaryStreamList();
			for(ELEMENTARY_STREAM e : elementaryStreamList) {
				System.out.println("AUDIO-LANGUAGE : " + e.getAudioLanguage());
			}
		}
		
		System.out.println("---将File类型的xml转换成对象 End---");

	}
}
