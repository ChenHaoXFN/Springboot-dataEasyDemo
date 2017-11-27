package com.symphony.springbootdata.demo.controller;

import com.symphony.springbootdata.demo.domain.Gril;
import com.symphony.springbootdata.demo.GrilPro;
import com.symphony.springbootdata.demo.GrilRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrilController {

  @Autowired
  private GrilRepository grilRepository;

  @Autowired
  private GrilPro grilPro;

  @Value("${commont}")
  private String commont;

  @RequestMapping(value = "hello", method = RequestMethod.GET)
  public String sayHello() {
//    return "hello" + grilPro.getCupSize() + grilPro.getAge();
    return commont;
  }

  @RequestMapping(value = {"test"}, method = RequestMethod.GET)
  public String H(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
    return "ID: " + id;
  }

  @RequestMapping(value = {"/{id}/test"}, method = RequestMethod.GET)
  public String He(@PathVariable(value = "id", required = true) Integer id) {
    return "ID: " + id;
  }


  @GetMapping("/grils")
  public List<Gril> findUser() {
    return grilRepository.findAll();
  }

  @PostMapping("/grils")
  public Gril addUser(@Valid Gril gril,BindingResult bindingResult) {
    if (bindingResult.hasErrors()){
      System.out.println(bindingResult.getFieldError().getDefaultMessage());
      return null;
    }
    return grilRepository.save(gril);
  }

  @GetMapping("/grils/{id}")
  public Gril finOneGril(@PathVariable(value = "id") Integer id) {
    return grilRepository.findOne(id);
  }

  @PutMapping("grils/{id}")
  public Gril updataGril(@PathVariable(value = "id") Integer id,
      @RequestParam("name") String name,
      @RequestParam("age") Integer age) {
    return grilRepository.save(new Gril(id, name, age));
  }

  @DeleteMapping("/grils/{id}")
  public void delGril(@PathVariable("id") Integer id){
    grilRepository.delete(id);
  }

  @GetMapping("grils/agee/{age}")
  public List<Gril> findByAge(@PathVariable("age") Integer age){
    return grilRepository.findByAge(age);
  }


}
