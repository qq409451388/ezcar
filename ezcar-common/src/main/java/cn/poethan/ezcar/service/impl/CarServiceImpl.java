package cn.poethan.ezcar.service.impl;

import cn.poethan.ezcar.entity.CarDO;
import cn.poethan.ezcar.facade.CarService;
import cn.poethan.ezcar.mapper.CarMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, CarDO>
        implements CarService {

    @Override
    public CarDO getById(Long id) {
        getBaseMapper();
        return lambdaQuery().eq(CarDO::getId, id).one();
    }
}
