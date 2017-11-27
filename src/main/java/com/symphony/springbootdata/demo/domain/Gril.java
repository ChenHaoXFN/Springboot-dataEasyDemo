package com.symphony.springbootdata.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class Gril {

  @Id
  @GeneratedValue
  private Integer id;
  private String name;
  @Min(value = 18,message = "weichengnia")
  private Integer age;

  public Gril(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public Gril() {
  }

  public Gril(Integer id, String name, Integer age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
