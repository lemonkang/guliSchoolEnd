package com.atguigu.eduservice.entity.InputVO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("课程信息")
@Data
public class CourseInfo {
    @ApiModelProperty("教师id")
    private String teacherId;
    @ApiModelProperty("课程分类id")
    private String subjectId;
    @ApiModelProperty(name = "课程描述")
    private String description;
    @ApiModelProperty("课程标题")
    private String title;

}
