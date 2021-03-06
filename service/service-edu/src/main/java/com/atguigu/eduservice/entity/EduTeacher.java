package com.atguigu.eduservice.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
public class EduTeacher {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;
    private String name;
    private String intro;
    private String career;
    private  Integer level;
    private  String avatar;
    private  Integer sort;
    @TableLogic
    private Integer isDeleted;
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
