package ar.edu.escmi.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
  @GetMapping({"/index","/home","/"})
  public String getmenu(){
    return "index";
  }
}
