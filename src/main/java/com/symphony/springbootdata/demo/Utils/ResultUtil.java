package com.symphony.springbootdata.demo.Utils;

import com.symphony.springbootdata.demo.Result.GrilResult;
import com.symphony.springbootdata.demo.domain.Gril;

/**
 * Created by ch on 2017-11-27
 */
public class ResultUtil {

  public static GrilResult<Gril> error(Integer code, String msg) {
    GrilResult result = new GrilResult();
    result.setCode(code);
    result.setMsg(msg);
    return result;
  }


  public static GrilResult<Gril> success(Object o) {
    GrilResult result = new GrilResult();
    result.setData(o);
    result.setCode(0);
    result.setMsg("成功");
    return result;
  }

  public static GrilResult<Gril> success() {
    return success(null);
  }

}
