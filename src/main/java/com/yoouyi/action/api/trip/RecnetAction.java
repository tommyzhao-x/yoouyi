package com.yoouyi.action.api.trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoouyi.action.api.BasicAction;
import com.yoouyi.common.MessageDTO;
import com.yoouyi.model.trip.RecentPO;
import com.yoouyi.service.trip.RecentService;
import com.yoouyi.service.trip.TripService;

@RestController
@RequestMapping("/api/recent")
public class RecnetAction extends BasicAction {
    
    @Autowired
    private RecentService recentService;
    @Autowired
    private TripService tripService;
    
    
    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)  
    public MessageDTO add(@RequestBody RecentPO recentPO) {
        
        boolean result = recentService.add(recentPO, getUser());
        tripService.updateViewedTimes(recentPO.getTrip());
        MessageDTO message = new MessageDTO();
        message.setSuccess(result);
        return message;
    }
    

}
