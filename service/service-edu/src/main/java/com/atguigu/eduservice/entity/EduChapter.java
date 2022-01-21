package com.atguigu.eduservice.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Data
public class EduChapter {
    @ApiModelProperty("课程信息的id")
    @TableId(value = "id",type = IdType.ID_WORKER_STR)
    private String courseId;
    @ApiModelProperty("课程标题")
    private String title;
    private  Integer sort;
    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
