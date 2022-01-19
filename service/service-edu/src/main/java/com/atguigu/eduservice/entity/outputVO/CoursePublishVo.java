package com.atguigu.eduservice.entity.outputVO;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;

@ApiModel("课程发布信息")
@Data
public class CoursePublishVo {
    String id;
    String title;
    BigDecimal price;
    Integer lessonNum;
    String cover;
    String name;
    String subjectLevelOne;
    String subjectLevelTwo;
}
