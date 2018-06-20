package tw.com.seesawin.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import tw.com.seesawin.domain.EIT;
import tw.com.seesawin.domain.EIT_CHANNEL;
import tw.com.seesawin.domain.EIT_CHANNEL_EVENT;
import tw.com.seesawin.domain.EIT_CHANNEL_EVENT_DESCRIPTOR;
import tw.com.seesawin.domain.MPEG_TABLES;
import tw.com.seesawin.domain.PMTs;
import tw.com.seesawin.domain.PMTs_CHANNEL;
import tw.com.seesawin.domain.PMTs_CHANNEL_ELEMENTARY_STREAM;
import tw.com.seesawin.util.XMLUtil;

public class Test {
	private static final Logger logger = Logger.getLogger(Test.class);
	
	public static void main(String[] args) {
		/************************************ PMTs ************************************/
		// ELEMENTARY_STREAM
		List<PMTs_CHANNEL_ELEMENTARY_STREAM> elementaryStreamList01 = new ArrayList<PMTs_CHANNEL_ELEMENTARY_STREAM>();
		PMTs_CHANNEL_ELEMENTARY_STREAM e1 = new PMTs_CHANNEL_ELEMENTARY_STREAM();
		e1.setAudioLanguage("eng");
		PMTs_CHANNEL_ELEMENTARY_STREAM e2 = new PMTs_CHANNEL_ELEMENTARY_STREAM();
		e2.setAudioLanguage("tw");
		PMTs_CHANNEL_ELEMENTARY_STREAM e3 = new PMTs_CHANNEL_ELEMENTARY_STREAM();
		e3.setAudioLanguage("cn");
		
		elementaryStreamList01.add(e1);
		elementaryStreamList01.add(e2);
		elementaryStreamList01.add(e3);
		
		// CHANNEL
		List<PMTs_CHANNEL> channel = new ArrayList<PMTs_CHANNEL>();
		PMTs_CHANNEL c1 = new PMTs_CHANNEL();
		c1.setServiceNumber("1201");
		c1.setPmtsChannelEementaryStreamList(elementaryStreamList01);
		PMTs_CHANNEL c2 = new PMTs_CHANNEL();
		c2.setServiceNumber("1200");;
		c2.setPmtsChannelEementaryStreamList(elementaryStreamList01);
		channel.add(c1);
		channel.add(c2);
		
		PMTs p = new PMTs();
		p.setPmtsChannelList(channel);
		
		/************************************ EIT ************************************/
		List<EIT_CHANNEL_EVENT_DESCRIPTOR> eitChannelEventDescriptor = new ArrayList<EIT_CHANNEL_EVENT_DESCRIPTOR>();
		EIT_CHANNEL_EVENT_DESCRIPTOR eced1 = new EIT_CHANNEL_EVENT_DESCRIPTOR();
		eced1.setData("data001");
		EIT_CHANNEL_EVENT_DESCRIPTOR eced2 = new EIT_CHANNEL_EVENT_DESCRIPTOR();
		eced2.setData("data002");
		
		eitChannelEventDescriptor.add(eced1);
		eitChannelEventDescriptor.add(eced2);
		
		List<EIT_CHANNEL_EVENT> eitChannelEventList = new ArrayList<EIT_CHANNEL_EVENT>();
		EIT_CHANNEL_EVENT ece1 = new EIT_CHANNEL_EVENT();
		ece1.setName("name001");
		ece1.setEitChannelEventDescriptor(eitChannelEventDescriptor);
		EIT_CHANNEL_EVENT ece2 = new EIT_CHANNEL_EVENT();
		ece2.setName("name002");
		ece2.setEitChannelEventDescriptor(eitChannelEventDescriptor);
		
		eitChannelEventList.add(ece1);
		eitChannelEventList.add(ece2);
		
		List<EIT_CHANNEL> eitChannelList = new ArrayList<EIT_CHANNEL>();
		EIT_CHANNEL ec1 = new EIT_CHANNEL();
		ec1.setServiceNumber("servName001");
		ec1.setEitChannelEventList(eitChannelEventList);
		EIT_CHANNEL ec2 = new EIT_CHANNEL();
		ec2.setServiceNumber("servName002");
		ec2.setEitChannelEventList(eitChannelEventList);
		
		eitChannelList.add(ec1);
		eitChannelList.add(ec2);
		
		EIT eit = new EIT();
		eit.setEitChannelList(eitChannelList);
		
		// MPEG_TABLES
		MPEG_TABLES table = new MPEG_TABLES();
		table.setPmts(p);
		table.setEit(eit);
		
		String path = "C:TEST\\user.xml";
		logger.info("---将对象转换成File类型的xml Start---");
		XMLUtil.convertToXml(table, path);
		logger.info("---将对象转换成File类型的xml End---");
		logger.info("");
		
		logger.info("---将File类型的xml转换成对象 Start---");
		
		/************************************ PMTs ************************************/
		MPEG_TABLES resultTab = (MPEG_TABLES) XMLUtil.convertXmlFileToObject(MPEG_TABLES.class, path);
		List<PMTs_CHANNEL> channelList = resultTab.getPmts().getPmtsChannelList();
		for(PMTs_CHANNEL c : channelList) {
			logger.info("SERVICE-NUMBER : " + c.getServiceNumber());
			
			List<PMTs_CHANNEL_ELEMENTARY_STREAM> elementaryStreamList = c.getPmtsChannelEementaryStreamList();
			for(PMTs_CHANNEL_ELEMENTARY_STREAM e : elementaryStreamList) {
				logger.info("AUDIO-LANGUAGE : " + e.getAudioLanguage());
			}
		}
		
		/************************************ EIT ************************************/
		List<EIT_CHANNEL> eitChannelList2 = resultTab.getEit().getEitChannelList();
		for(EIT_CHANNEL ec : eitChannelList2) {
			logger.info("SERVICE-NUMBER : " + ec.getServiceNumber());
			
			List<EIT_CHANNEL_EVENT> eitChannelEventList2 = ec.getEitChannelEventList();
			for(EIT_CHANNEL_EVENT event : eitChannelEventList2) {
				List<EIT_CHANNEL_EVENT_DESCRIPTOR> descrptorList = event.getEitChannelEventDescriptor();
				for(EIT_CHANNEL_EVENT_DESCRIPTOR d : descrptorList) {
					logger.info("DATA : " + d.getData());
				}
			}
		}
		
		logger.info("---将File类型的xml转换成对象 End---");
	}
}
