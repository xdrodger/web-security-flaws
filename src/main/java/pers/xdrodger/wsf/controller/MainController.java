package pers.xdrodger.wsf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pers.xdrodger.wsf.service.AccessLogService;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	private AccessLogService accessLogService;
	
	public MainController() {
	}


//	@Autowired 
//	private AddressDetailService addressDetailService;
	
//	@RequestMapping(value = "/index", method = RequestMethod.GET)
//	public @ResponseBody AddressEditOutput edit(
//			@Valid @RequestBody AddressEditInput input) {
//		AddressEditOutput output = editService.process(input); 
//		return output;
//	}
	@RequestMapping(value = "/index")
	public ModelAndView index() {
		System.out.println("main-index");
		accessLogService.process();
//		return new ModelAndView("main/index");
		return new ModelAndView("/index");
	}


}
