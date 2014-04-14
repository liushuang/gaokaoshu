package com.springapp.mvc;

import com.gaokaoshu.dao.BasicInfoDAO;
import com.gaokaoshu.dao.ViewCountDAO;
import com.gaokaoshu.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
        model.addAttribute("view_count", ViewCountDAO.increaseViewCount(Constant.VIEW_COUNT_INDEX));
        model.addAttribute("web_introduction", BasicInfoDAO.getBasicInfoById(Constant.BASIC_INFO__WEB_INTRODUCTION));
		return "hello";
	}
}