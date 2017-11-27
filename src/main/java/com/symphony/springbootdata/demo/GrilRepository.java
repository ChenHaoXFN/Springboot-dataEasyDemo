package com.symphony.springbootdata.demo;

import com.symphony.springbootdata.demo.domain.Gril;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @User: ch
 * @Date: 2017-11-24
 * @Time: 下午1:50
 */
public interface GrilRepository extends JpaRepository<Gril,Integer> {
  //根据年龄来查女生
  public List<Gril> findByAge(Integer age);


}
