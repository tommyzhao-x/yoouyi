package com.zgt.action.api;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zgt.dao.travel.TravelLineDAO;
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

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> index(@RequestParam("keyWord") String keyWord, HttpServletRequest request) {

        Integer pageNum = new Integer(request.getParameter("pageNum"));

        Map<String, Object> result = new HashMap<String, Object>();

        result.put("lines", travelService.getAll(pageNum, "上海", keyWord, null));

        return result;
    }

    @RequestMapping(value = "/metaData", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> time(@RequestParam("keyWord") String keyWord, HttpServletRequest request) {

        Map<String, Object> result = new HashMap<String, Object>();

        result.put("timeList", travelService.getAllTravelTimes("上海", keyWord, null));
        result.put("platformList", travelService.getAllTravelPlatforms("上海", keyWord, null));

        return result;
    }
}
