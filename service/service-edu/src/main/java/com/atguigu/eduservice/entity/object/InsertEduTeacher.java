package com.atguigu.eduservice.entity.object;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class InsertEduTeacher {
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("序号")
    private  Integer sort;
}
