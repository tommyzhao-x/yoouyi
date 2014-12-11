package com.yoouyi.action.api.trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoouyi.action.api.BasicAction;
import com.yoouyi.common.MessageDTO;
import com.yoouyi.model.user.FavoritePO;
import com.yoouyi.service.trip.RecentService;
import com.yoouyi.service.trip.TripService;
import com.yoouyi.service.user.FavoriteService;

@RestController
@RequestMapping("/api/trip/recent")
public class RecentAction extends BasicAction {

    @Autowired
    private RecentService recentService;
    
    @RequestMapping(method = RequestMethod.GET)
    public MessageDTO index() {
        MessageDTO message = new MessageDTO();
        message.setData(recentService.findAll(getUser()));
        message.setSuccess(true);
        return message;
    }

}
