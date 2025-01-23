package cn.poethan.ezcar.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@TableName("cars")
public class CarDO {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("ver")
    private Integer ver;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
    /**
     * 车辆品牌
     */
    @TableField("brand")
    private String brand;

    /**
     * 车辆型号
     */
    @TableField("model")
    private String model;
}
