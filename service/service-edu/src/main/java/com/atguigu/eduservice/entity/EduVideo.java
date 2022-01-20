package com.atguigu.eduservice.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class EduVideo {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;
    private String courseId;
    private String chapterId;
    private String title;
    private String videoSourceId;
    private String videoOriginalName;
    private  Integer sort;
    private BigInteger playCount;
    private Integer isFree;
    private Double duration;
    private String status;
    private BigInteger size;
    private BigInteger version;
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
