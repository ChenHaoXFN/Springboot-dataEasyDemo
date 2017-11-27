package com.symphony.springbootdata.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @User: ch
 * @Date: 2017-11-27
 * @Time: 上午9:42
 */
@Aspect
@Component
public class HttpAspect {

  @Before("execution(public * com.symphony.springbootdata.demo.controller.GrilController.finOneGril(..))")
  public void before(){
    System.out.println(11111111);
  }

  @After("execution(public * com.symphony.springbootdata.demo.controller.GrilController.finOneGril(..))")
  public void after(){
    System.out.println(2222222);
  }

}
