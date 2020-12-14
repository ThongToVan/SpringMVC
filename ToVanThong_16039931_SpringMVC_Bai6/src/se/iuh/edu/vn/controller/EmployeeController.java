/**
 * 
 */
package se.iuh.edu.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import se.iuh.edu.vn.beans.Employee;
import se.iuh.edu.vn.dao.EmployeeDao;

/**
 * @author ToThong
 *
 */
@Controller
public class EmployeeController {
	@Autowired
	EmployeeDao dao;

	@RequestMapping(value = "/emform", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("emform", "command", new Employee());

	}

	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public ModelAndView
	 * show() { return new ModelAndView(""); }
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") Employee emp) {
		dao.save(emp);
		return new ModelAndView("redirect:/viewemp");

	}

	@RequestMapping("/")
	public ModelAndView viewmp() {
		List<Employee> list = dao.getEmployee();
		return new ModelAndView("viewemp", "list", list);

	}

	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)

	public ModelAndView delete(@PathVariable int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/viewemp");

	}
	
	@RequestMapping("/editemp/{id}")
	public ModelAndView edit(@PathVariable int id) {
		Employee emp = dao.getEmpById(id);
		return new ModelAndView("editform","command", emp);
		
	}
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("emp") Employee emp) {
		dao.update(emp);
		 return new ModelAndView("redirect:/viewemp");
		
		
		
	}
	

}
