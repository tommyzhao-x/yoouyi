package com.zgt.action.api;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zgt.dao.mongo.TravelLineDAO;

@Controller
@RequestMapping("/api/travelSearch")
public class TravelSearchAction {

    private TravelLineDAO travelLineDAO;

    public TravelLineDAO getTravelLineDAO() {
        return travelLineDAO;
    }

    @Resource
    public void setTravelLineDAO(TravelLineDAO travelLineDAO) {
        this.travelLineDAO = travelLineDAO;
    }
    
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> index(@RequestParam("keyWord") String keyWord) {

        Map<String, Object> result = new HashMap<String, Object>();

        result.put("lines", travelLineDAO.getTravelLine("上海", keyWord, null));

        return result;
    }

}
