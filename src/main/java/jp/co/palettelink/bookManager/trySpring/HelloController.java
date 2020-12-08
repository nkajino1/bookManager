package jp.co.palettelink.bookManager.trySpring;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller

public class HelloController {

  @GetMapping({"/","/hello"})
  public String getHello(/*Model model*/) {
    return "hello";
  }

  @PostMapping("/hello_other_language")/*お送り先のview*/
  public ModelAndView result(@RequestParam("sample")String sample, ModelAndView SR) {

	  SR.setViewName("hello_other_language");/*お送り先のview*/
	  SR.addObject("sample", sample);/*送る変数*/

	  return SR;
  }

}
