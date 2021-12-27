package com.atguigu.eduservice.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class EduSubject {
    @TableId(value = "id",type = IdType.ID_WORKER_STR )
    @ApiModelProperty(name = "id",value="课程类别ID")
    private String id;
    @ApiModelProperty(name = "title",value="类别名称")
    private String title;
    @ApiModelProperty(name = "parent_id",value="父ID")
    private String parent_id;
    @ApiModelProperty(name = "sort",value="排序字段")
    private Integer sort;
    @TableField(fill = FieldFill.INSERT)  //自动填充
    @ApiModelProperty(name = "gmt_create",value="创建时间")
    private Date gmt_create;
    @TableField(fill = FieldFill.UPDATE)  //自动填充
    @ApiModelProperty(name = "gmt_modified",value="更新时间")
    private Date gmt_modified;

}
