package cn.poethan.ezcar.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseDO {
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @TableField("ver")
    private Integer ver;

    @TableField("create_time")
    private DateTime createTime;

    @TableField("update_time")
    private DateTime updateTime;
}
