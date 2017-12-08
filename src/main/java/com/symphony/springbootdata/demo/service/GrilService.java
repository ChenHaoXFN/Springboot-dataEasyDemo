package com.symphony.springbootdata.demo.service;

import com.symphony.springbootdata.demo.repository.GrilPagingAndSortingRepository;
import com.symphony.springbootdata.demo.repository.GrilRepository;
import com.symphony.springbootdata.demo.domain.Gril;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by ch on 2017-11-27
 */
@Service
public class GrilService {

  @Autowired
  private GrilRepository grilRepository;

  @Autowired
  private GrilPagingAndSortingRepository grilPagingAndSortingRepository;

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
    List<Gril> lists = grilRepository.findByNameStartingWithAndAgeLessThan("陈浩", 22);
    for (Gril gril : lists) {
      System.out.println(gril.toString());
    }
    grilRepository.findAll();
    return grilRepository.findOne(id);
  }

  //修改时 需要 添加@Transactional注解，
  @Transactional
  public void updataGril(Integer age, Integer id) {
    grilRepository.updataGril(age, id);
  }


  //删除时 需要 添加@Transactional注解，
  @Transactional
  public void deldteGril(Integer id) {
    grilRepository.deleteGril(id);
  }


  public void page(Pageable pageable) {
    Page<Gril> grils = grilPagingAndSortingRepository.findAll(pageable);
    System.out.println("总共多少页？++++" + grils.getTotalPages());
    System.out.println("当前第几页？++++" + ((pageable.getPageNumber() + 1)));
    System.out.println("一共多少条？++++" + grils.getTotalElements());
    System.out.println("getNumber()++++" + grils.getNumber());
    System.out.println("getNumberOfElements()++++" + grils.getNumberOfElements());
    System.out.println("getSize()++++" + grils.getSize());
    System.out.println("getSort()++++" + grils.getSort());
    System.out.println("-----------------------");
    System.out.println("-----------------------");
    System.out.println("-----------------------");
    List<Gril> grilList = grils.getContent();
    for (Gril gril : grilList) {
      System.out.println(gril.toString());
    }

  }

}
