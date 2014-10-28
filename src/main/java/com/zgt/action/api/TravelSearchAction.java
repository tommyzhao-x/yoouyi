package com.zgt.action.api;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zgt.common.MessageDTO;
import com.zgt.dao.travel.TravelLineDAO;
import com.zgt.model.UserPO;
import com.zgt.model.vo.TravelLineSearchVO;
import com.zgt.service.travel.TravelService;

@Controller
@RequestMapping("/api/travelSearch")
public class TravelSearchAction {

    private TravelService travelService;

    public TravelService getTravelService() {
        return travelService;
    }

    @Resource
    public void setTravelService(TravelService travelService) {
        this.travelService = travelService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> index(@RequestBody TravelLineSearchVO searchVO) {


        Map<String, Object> result = new HashMap<String, Object>();

        result.put("lines", travelService.getAll(searchVO));

        return result;
    }

    @RequestMapping(value = "/metaData", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> time(@RequestParam("starting") String starting, 
            @RequestParam("destination") String destination, HttpServletRequest request) {

        Map<String, Object> result = new HashMap<String, Object>();

        result.put("timeList", travelService.getAllTravelTimes(starting, destination, null));
        result.put("platformList", travelService.getAllTravelPlatforms(starting, destination, null));

        return result;
    }
}
