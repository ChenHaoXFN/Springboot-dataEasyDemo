package com.symphony.springbootdata.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * AOP.
 *
 * @User: ch
 * @Date: 2017-11-27
 * @Time: 上午9:42
 */
@Aspect //aop标签
@Component //引入到spirng容器
public class HttpAspect {

  /**
   * 方法前执行.
   */
  @Before("execution(public * com.symphony.springbootdata.demo.controller.GrilController.finOneGril(..))")
  public void before() {
    System.out.println(11111111);
  }

  /**
   * 方法后执行.
   */
  @After("execution(public * com.symphony.springbootdata.demo.controller.GrilController.finOneGril(..))")
  public void after() {
    System.out.println(2222222);
  }

}
