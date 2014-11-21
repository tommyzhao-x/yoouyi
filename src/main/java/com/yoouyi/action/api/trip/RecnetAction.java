package com.yoouyi.action.api.trip;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoouyi.action.api.BasicAction;
import com.yoouyi.common.MessageDTO;
import com.yoouyi.model.trip.RecentPO;
import com.yoouyi.model.trip.TripPO;
import com.yoouyi.service.trip.RecentService;

@RestController
@RequestMapping("/api/recent")
public class RecnetAction extends BasicAction {
    
    @Autowired
    private RecentService recentService;
    
    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)  
    public MessageDTO add(@RequestBody RecentPO recentPO) {
        
        recentService.add(recentPO, getUser());
        MessageDTO message = new MessageDTO();
        message.setSuccess(true);
        return message;
    }
    

}
