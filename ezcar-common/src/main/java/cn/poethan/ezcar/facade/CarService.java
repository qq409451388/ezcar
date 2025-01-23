package cn.poethan.ezcar.facade;

import cn.poethan.ezcar.entity.CarDO;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CarService extends IService<CarDO> {

    CarDO getById(Long id);
}
