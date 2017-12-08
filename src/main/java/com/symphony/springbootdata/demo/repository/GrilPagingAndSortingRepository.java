package com.symphony.springbootdata.demo.repository;

import com.symphony.springbootdata.demo.domain.Gril;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

/**
 * Created by ch on 2017-12-08
 * 带有分页跟排序功能的接口
 */
public interface GrilPagingAndSortingRepository extends PagingAndSortingRepository<Gril, Integer> {


}
