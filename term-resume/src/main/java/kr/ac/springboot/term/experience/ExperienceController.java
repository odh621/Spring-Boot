package kr.ac.springboot.term.experience;


import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;


import kr.ac.springboot.term.resume.ResumeRepository;
import kr.ac.springboot.term.resumereplay.ResumeReplyRepository;

@ControllerAdvice
@Controller
@RequestMapping("/experience/")
public class ExperienceController {
	
	@Autowired
	private ExperienceRepository exrepo;
	
	@Autowired
	private ResumeRepository repo;
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest request, Exception e)   {
	  Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Request: " + request.getRequestURL() + " raised " + e);
	  return new ModelAndView("errors/404");
	}
	    
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleError404(HttpServletRequest request, Exception e)   {
	  Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Request: " + request.getRequestURL() + " raised " + e);
	  return new ModelAndView("errors/404");
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ModelAndView handleError400(HttpServletRequest request, Exception e)   {
	  Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Request: " + request.getRequestURL() + " raised " + e);
	  return new ModelAndView("errors/404");
	}
	
	@GetMapping("/")
	public void list(Model model) {
	  model.addAttribute("result1", repo.findByBno(1L));
      model.addAttribute("result", exrepo.findAllByOrderByRegdateDesc());
	}
	
	@GetMapping("/{bno}")
	public String view(@PathVariable("bno") long bno, Model model) {
	  if (exrepo.findById(bno).isPresent()) {
		 model.addAttribute("result", exrepo.findById(bno).get());
	  } else {
		  return "errors/404";
	  }
	  	return "/experience/item";
	}
	
	@GetMapping("/register")
	public void registerGET(@ModelAttribute("vo") Experience vo) {
	}

	@PostMapping("/register")
	public String registerPOST(@ModelAttribute("vo") Experience vo) {
		vo.setResume(repo.findById(1L).get());
		exrepo.save(vo);
		return "redirect:/experience/";
	}
	
	@GetMapping("/{bno}/delete")
	public String delete(@PathVariable("bno") long bno) {
		if (exrepo.findById(bno).isPresent()) {
			exrepo.deleteById(bno);
		} else {
			return "errors/404";
		}
		return "redirect:/experience/";
	}
	
	@GetMapping("/{bno}/update")
	public String editGet(@PathVariable("bno") long bno, @ModelAttribute("vo") Experience vo, Model model) {
		if (exrepo.findById(bno).isPresent()) {
			model.addAttribute("vo", exrepo.findById(bno).get());
		} else {
			return "errors/404";
		}
      	return "/experience/update";
	}
	
	@PostMapping("/update")
	public String editPost(@ModelAttribute("vo") Experience vo) {
		Optional<Experience> experience = exrepo.findById(vo.getBno()+1);
		if (experience.isPresent()) {
			experience.get().setTerm(vo.getTerm());
			experience.get().setTitle(vo.getTitle());
			experience.get().setPosition(vo.getPosition());
			experience.get().setContent(vo.getContent());
			exrepo.save(experience.get());
		} else {
			exrepo.save(vo);
		}
		return "redirect:/experience/";
	}
  
  
}
