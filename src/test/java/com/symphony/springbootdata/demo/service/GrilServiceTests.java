package com.symphony.springbootdata.demo.service;

import com.symphony.springbootdata.demo.repository.GrilRepository;
import com.symphony.springbootdata.demo.domain.Gril;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ch on 2017-12-08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GrilServiceTests {

  @Autowired
  private GrilRepository grilRepository;
  @Autowired
  private GrilService grilService;

  private PagingAndSortingRepository pagingAndSortingRepository;


  @Test
  public void findOne() throws Exception {
    String phoneNum = "545";
    String phoneNumber = "%" + phoneNum + "%";
    List<Gril> lists = grilRepository.findByPhoneNumIsLike(phoneNumber);
    for (Gril gril : lists) {
      System.out.println(gril.toString());
    }
  }

  @Test
  public void queryParams1() throws Exception {
    List<Gril> list = grilRepository.queryParams1("陈浩", 20);
    for (Gril gril : list) {
      System.out.println(gril.toString());
    }
  }

  @Test
  public void queryMaxAge() throws Exception {
    List<Gril> list = grilRepository.queryMaxAge();
    for (Gril gril : list) {
      System.out.println(gril.toString());
    }

  }

  @Test
  public void queryParams2() throws Exception {
    List<Gril> list = grilRepository.queryParams2("陈浩", 20);
    for (Gril gril : list) {
      System.out.println(gril.toString());
    }
  }

  @Test
  public void queryCont() throws Exception {
    long l = grilRepository.queryCont();
    System.out.println(l);
  }

  @Test
  public void updataGril() throws Exception {
    grilService.updataGril(555, 2);
  }


  @Test
  public void deleteGril() throws Exception {
    grilService.deldteGril(1);
  }

  //批量添加测试数据
  @Test
  public void saveTestData() {
    List<Gril> grils = new ArrayList<>();
    Gril gril = null;
    for (int a = 0; a < 100; a++) {
      gril = new Gril();
      gril.setId(a + 10);
      gril.setAge(1000 - a);
      gril.setName("test" + a);
      gril.setPhoneNum("3213456" + a);
      grils.add(gril);
    }
    grilRepository.save(grils);
  }


  /**
   * 测试分页跟排序
   */

  /*@Test
  public void testSort(){
    Iterable sort = new ;
    pagingAndSortingRepository.findAll(sort);
  }*/
  @Test
  public void testPage() {
    //设置升续降续，以什么字段排序
    Order order = new Order(Direction.ASC, "age");
    Sort sort = new Sort(order);
    //page 0、index 以0未开始，size 每一页显示几条
    Pageable pageable = new PageRequest(0, 10, sort);
    grilService.page(pageable);
  }

}