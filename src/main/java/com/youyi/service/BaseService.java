package com.youyi.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends Serializable> {
    
    public List<T> getDateByPageNum(Integer pageNum);

}
