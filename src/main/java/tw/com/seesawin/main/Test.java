package tw.com.seesawin.main;

import java.util.ArrayList;
import java.util.List;

import tw.com.seesawin.domain.CHANNEL;
import tw.com.seesawin.domain.ELEMENTARY_STREAM;
import tw.com.seesawin.domain.MPEG_TABLES;
import tw.com.seesawin.domain.PMTs;
import tw.com.seesawin.util.XMLUtil;

public class Test {
	public static void main(String[] args) {
		// ELEMENTARY_STREAM
		List<ELEMENTARY_STREAM> elementaryStreamList01 = new ArrayList<ELEMENTARY_STREAM>();
		ELEMENTARY_STREAM e1 = new ELEMENTARY_STREAM();
		e1.setAudioLanguage("eng");
		ELEMENTARY_STREAM e2 = new ELEMENTARY_STREAM();
		e2.setAudioLanguage("tw");
		ELEMENTARY_STREAM e3 = new ELEMENTARY_STREAM();
		e3.setAudioLanguage("cn");
		
		elementaryStreamList01.add(e1);
		elementaryStreamList01.add(e2);
		elementaryStreamList01.add(e3);
		
		// CHANNEL
		List<CHANNEL> channel = new ArrayList<CHANNEL>();
		CHANNEL c1 = new CHANNEL();
		c1.setServiceNumber("1201");
		c1.setElementaryStreamList(elementaryStreamList01);
		CHANNEL c2 = new CHANNEL();
		c2.setServiceNumber("1200");;
		c2.setElementaryStreamList(elementaryStreamList01);
		channel.add(c1);
		channel.add(c2);
		
		// PMTs
		PMTs p = new PMTs();
		p.setChannelList(channel);
		
		// MPEG_TABLES
		MPEG_TABLES table = new MPEG_TABLES();
		table.setPmts(p);
		
		String path = "C:TEST\\user.xml";
		System.out.println("---将对象转换成File类型的xml Start---");
		XMLUtil.convertToXml(table, path);
		System.out.println("---将对象转换成File类型的xml End---");
		System.out.println();
		
		System.out.println("---将File类型的xml转换成对象 Start---");
		MPEG_TABLES resultTab = (MPEG_TABLES) XMLUtil.convertXmlFileToObject(MPEG_TABLES.class, path);
		List<CHANNEL> channelList = resultTab.getPmts().getChannelList();
		for(CHANNEL c : channelList) {
			System.out.println("SERVICE-NUMBER : " + c.getServiceNumber());
			
			List<ELEMENTARY_STREAM> elementaryStreamList = c.getElementaryStreamList();
			for(ELEMENTARY_STREAM e : elementaryStreamList) {
				System.out.println("AUDIO-LANGUAGE : " + e.getAudioLanguage());
			}
		}
		
		System.out.println("---将File类型的xml转换成对象 End---");

	}
}
