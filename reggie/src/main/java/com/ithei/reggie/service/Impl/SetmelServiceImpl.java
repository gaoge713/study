package com.ithei.reggie.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ithei.reggie.entity.Setmeal;
import com.ithei.reggie.mapper.SetmealMapper;
import com.ithei.reggie.service.SetmelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SetmelServiceImpl extends ServiceImpl<SetmealMapper, Setmeal>implements SetmelService {
}
