package com.springapp.mvc;

import com.gaokaoshu.dao.BasicInfoDAO;
import com.gaokaoshu.dao.HotTypeDAO;
import com.gaokaoshu.dao.ViewCountDAO;
import com.gaokaoshu.entity.HotTypeEntity;
import com.gaokaoshu.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
        List<HotTypeEntity> firstHotTypeList = HotTypeDAO.getHotTypeListByLevel(1);
        model.addAttribute("first_hot_list",firstHotTypeList);
        List<HotTypeEntity> secondHotTypeList = HotTypeDAO.getHotTypeListByLevel(2);
        model.addAttribute("second_hot_list",secondHotTypeList);
        model.addAttribute("view_count", ViewCountDAO.increaseViewCount(Constant.VIEW_COUNT_INDEX));
        model.addAttribute("web_introduction", BasicInfoDAO.getBasicInfoById(Constant.BASIC_INFO_WEB_INTRODUCTION));
        model.addAttribute("baokaogaishu",BasicInfoDAO.getBasicInfoById(Constant.BASIC_INFO_BAOKAOGAISHU));
		return "index";
	}
}