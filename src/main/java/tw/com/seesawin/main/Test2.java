package tw.com.seesawin.main;

import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;

import tw.com.seesawin.domain.EIT_CHANNEL;
import tw.com.seesawin.domain.EIT_CHANNEL_EVENT;
import tw.com.seesawin.domain.EIT_CHANNEL_EVENT_DESCRIPTOR;
import tw.com.seesawin.domain.MPEG_TABLES;
import tw.com.seesawin.domain.PMTs_CHANNEL;
import tw.com.seesawin.domain.PMTs_CHANNEL_ELEMENTARY_STREAM;
import tw.com.seesawin.util.FileReader;
import tw.com.seesawin.util.XMLUtil;

public class Test2 {
	private static final Logger logger = Logger.getLogger(Test2.class);

	public static void main(String[] args) {
		// String path = "C:TEST\\NZ_PCH29_538M_Channel_ONE_Rating-AO-0_020912-1.xml";
		// MPEG_TABLES table = (MPEG_TABLES) XMLUtil.convertXmlFileToObject(MPEG_TABLES.class, path);

		InputStream is = FileReader.getFileWithUtil(Test2.class, "NZ_PCH29_538M_Channel_ONE_Rating-AO-0_020912-1.xml");
		MPEG_TABLES table = (MPEG_TABLES) XMLUtil.convertXmlFileToObject(MPEG_TABLES.class, is);

		logger.info("---将File类型的xml转换成对象 Start---");

		/************************************ PMTs ************************************/
		List<PMTs_CHANNEL> channelList = table.getPmts().getPmtsChannelList();
		logger.info("channel size : " + channelList.size());

		for (PMTs_CHANNEL c : channelList) {
			logger.info("ServiceNumber : " + c.getServiceNumber());
			List<PMTs_CHANNEL_ELEMENTARY_STREAM> elementaryStreamList = c.getPmtsChannelEementaryStreamList();
			for (PMTs_CHANNEL_ELEMENTARY_STREAM e : elementaryStreamList) {
				logger.info("AUDIO-LANGUAGE : " + e.getAudioLanguage());
			}
		}

		/************************************ EIT ************************************/
		List<EIT_CHANNEL> eitChannelList2 = table.getEit().getEitChannelList();
		for (EIT_CHANNEL ec : eitChannelList2) {
			logger.info("SERVICE-NUMBER : " + ec.getServiceNumber());

			List<EIT_CHANNEL_EVENT> eitChannelEventList2 = ec.getEitChannelEventList();
			for (EIT_CHANNEL_EVENT event : eitChannelEventList2) {
				logger.info("NAME : " + event.getName());

				List<EIT_CHANNEL_EVENT_DESCRIPTOR> descrptorList = event.getEitChannelEventDescriptor();
				for (EIT_CHANNEL_EVENT_DESCRIPTOR d : descrptorList) {
					// logger.info("DATA : " + d.getData());
				}
			}
		}

		logger.info("---将File类型的xml转换成对象 End---");

	}
}
