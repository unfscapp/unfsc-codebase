/**
 * 
 */
package corp.ospreys.edu.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import corp.ospreys.edu.dao.EventDetailsDao;
import corp.ospreys.edu.dto.EventDetails;
import corp.ospreys.edu.service.EventDetailsService;
import corp.ospreys.edu.util.Emailer;

/**
 * @author sandyturlapaty
 *
 */
@Service("eventDetailsService")
public class EventDetailsServiceImpl implements EventDetailsService {
	
	@Autowired
	private EventDetailsDao eventDetailsDao;

	@Override
	public List<EventDetails> retrieveEventById(String idValue, String idType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createEvent(EventDetails event) {
		try {
			eventDetailsDao.createEvent(event);
			if(StringUtils.isNotEmpty(event.getPublicInd()) && "yes".equalsIgnoreCase(event.getPublicInd())){
				Emailer.triggerEmail("New Event Request", "Name : "+event.getEventName()+ "  Event Location : "+event.getEventLocation());
			}
			return "201";
		} catch (Exception e){
			return "400";
		}
	}

	
}
