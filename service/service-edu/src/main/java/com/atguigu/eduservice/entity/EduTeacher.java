package com.atguigu.eduservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
    private Integer is_deleted;
    private Date gmt_create;
    private Date gmt_modified;

}
