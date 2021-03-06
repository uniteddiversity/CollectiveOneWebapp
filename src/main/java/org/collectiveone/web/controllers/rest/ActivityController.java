package org.collectiveone.web.controllers.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.collectiveone.services.ActivityDtoListRes;
import org.collectiveone.services.DbServicesImp;
import org.collectiveone.services.Filters;
import org.collectiveone.web.dto.ActivityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/activity")
public class ActivityController {
	
	@Autowired
	DbServicesImp dbServices;
	
	@RequestMapping(value="/getList", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> getList(@RequestBody Filters filters) {
		if(filters.getPage() == 0) filters.setPage(1);
		if(filters.getNperpage() == 0) filters.setNperpage(15);
		
		ActivityDtoListRes actDtosRes = dbServices.activityDtoGetFiltered(filters);
		
		List<ActivityDto> actDtos = actDtosRes.getActivityDtos();
		int[] resSet = actDtosRes.getResSet();
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("activityDtos", actDtos);
		map.put("resSet", resSet);
		
		return map;
	}
	
}
