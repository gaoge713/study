package com.ithei.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ithei.reggie.entity.Category;

public interface CategoryService extends IService<Category> {
    public void remove(Long ids);
}
