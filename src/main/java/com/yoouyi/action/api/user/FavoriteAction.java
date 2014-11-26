package com.yoouyi.action.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoouyi.action.api.BasicAction;
import com.yoouyi.common.MessageDTO;
import com.yoouyi.model.FavoritePO;
import com.yoouyi.service.trip.TripService;
import com.yoouyi.service.user.FavoriteService;

@RestController
@RequestMapping("/api/user/favorite")
public class FavoriteAction extends BasicAction {

    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private TripService tripService;
    
    @RequestMapping(method = RequestMethod.GET)
    public MessageDTO index(@RequestParam Integer pageNum) {
        MessageDTO message = new MessageDTO();
        message.setData(favoriteService.findAll(pageNum, getUser()));
        message.setSuccess(true);
        return message;
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public MessageDTO add(@RequestBody FavoritePO favoritePO) {
        MessageDTO message = new MessageDTO();
        
        if (!favoriteService.isExist(favoritePO.getTrip(), getUser())) {

            tripService.updateFavoriteTime(favoritePO.getTrip());
            
        }

        message.setData(favoriteService.save(favoritePO, getUser()));
        
        message.setSuccess(true);

        return message;
    }

}
