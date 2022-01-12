package com.atguigu.eduservice.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@ApiModel("课程信息")
@Data
public class EduCourse {
    @ApiModelProperty("课程信息的id")
    @TableId(value = "id",type = IdType.ID_WORKER_STR)
    private String id;

    private String teacherId;
    private String subjectId;
    private  String subjectParentId;
    @ApiModelProperty("课程标题")
    private String title;
    private BigDecimal price;
    private Integer lessonNum;
    private String cover;
    private BigInteger buyCount;
    private BigInteger viewCount;
    private BigInteger version;
    private String status;
    @ApiModelProperty("逻辑删除")
    @TableLogic
    private Integer isDelete;
    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
     @ApiModelProperty("修改时间")
     @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
