package com.symphony.springbootdata.demo.service;

import com.symphony.springbootdata.demo.GrilRepository;
import com.symphony.springbootdata.demo.domain.Gril;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ch on 2017-11-27
 */
@Service
public class GrilService {

  @Autowired
  private GrilRepository grilRepository;

  public Gril findGrilById(Integer id) {
    return grilRepository.findOne(id);
  }

  /**
   * 这里做一个异常捕获，判断女孩年级.
   */
  public void findGrilId(Integer id) {

  }

  /**
   * 测试方法测试.
   */
  public Gril findOne(Integer id) {
    return grilRepository.findOne(id);
  }
}
