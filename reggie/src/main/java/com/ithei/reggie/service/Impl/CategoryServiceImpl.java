package com.ithei.reggie.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ithei.reggie.common.CustomException;
import com.ithei.reggie.entity.Category;
import com.ithei.reggie.entity.Dish;
import com.ithei.reggie.entity.Setmeal;
import com.ithei.reggie.mapper.CategoryMapper;
import com.ithei.reggie.service.CategoryService;
import com.ithei.reggie.service.DishService;
import com.ithei.reggie.service.SetmelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private DishService dishService;

    @Autowired
    private SetmelService setmelService;
    /*
    * 根据id进行删除，删除之前需要进行判断
    * */
    @Override
    public void remove(Long ids) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<Dish>();
        //添加查询条件，根据id进行查询
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,ids);
        int count1 = dishService.count(dishLambdaQueryWrapper);
        //查询当前分类是否已经关联菜品，如果已经关联，抛出一个异常
        if(count1>0){
            //已关联菜品抛出业务异常
            throw new CustomException("当前分类下关联了菜品，不能删除");
        }
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<Setmeal>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,ids);
        int count2 = setmelService.count(setmealLambdaQueryWrapper);
        if(count2>0){
            //已关联套餐抛出业务异常
            throw new CustomException("当前分类下关联了套餐，不能删除");
        }
        //查询当前分类是否已经关联套餐，如果已经关联，抛出一个异常

        //正常删除
        super.removeById(ids);
    }
}
