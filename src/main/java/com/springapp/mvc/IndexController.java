package com.springapp.mvc;

import com.gaokaoshu.dao.ViewCountDAO;
import com.gaokaoshu.entity.ViewCountEntity;
import com.gaokaoshu.util.Constant;
import com.gaokaoshu.util.SessionFactoryHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        model.addAttribute("view_count", ViewCountDAO.increateViewCount(Constant.VIEW_COUNT_INDEX));
		return "hello";
	}
}