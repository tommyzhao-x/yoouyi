package com.yoouyi.action.api;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yoouyi.model.vo.TripSearchVO;
import com.yoouyi.service.trip.TripService;

@Controller
@RequestMapping("/api/travelSearch")
public class TravelSearchAction {

    @Autowired
    private TripService tripService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> index(@RequestBody TripSearchVO searchVO) {


        Map<String, Object> result = new HashMap<String, Object>();

        result.put("lines", tripService.getAll(searchVO));

        return result;
    }

    @RequestMapping(value = "/metaData", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> time(@RequestParam("starting") String starting, 
            @RequestParam("destination") String destination, HttpServletRequest request) {

        Map<String, Object> result = new HashMap<String, Object>();

        result.put("timeList", tripService.getAllTravelTimes(starting, destination, null));
        result.put("platformList", tripService.getAllTravelPlatforms(starting, destination, null));

        return result;
    }
}
