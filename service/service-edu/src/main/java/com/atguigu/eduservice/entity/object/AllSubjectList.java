package com.atguigu.eduservice.entity.object;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel("课程")
public class AllSubjectList {
    private String title;
   List<Subject> children;
}
