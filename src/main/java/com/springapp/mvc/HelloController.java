package com.springapp.mvc;

import com.gaokaoshu.entity.ViewCountEntity;
import com.gaokaoshu.util.SessionFactoryHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        ViewCountEntity viewCountEntity = (ViewCountEntity) session.byId(ViewCountEntity.class).load(1);
        viewCountEntity.setCount(viewCountEntity.getCount() + 1);
        session.saveOrUpdate(viewCountEntity);
        session.getTransaction().commit();
        session.close();
		return "hello";
	}

    public static void main(String[] args){
        Session session = SessionFactoryHelper.getSessionFactory().openSession();
        session.beginTransaction();
        ViewCountEntity viewCountEntity = new ViewCountEntity();
        viewCountEntity.setCount(1);
        session.save(viewCountEntity);
        session.getTransaction().commit();
        session.close();
    }
}