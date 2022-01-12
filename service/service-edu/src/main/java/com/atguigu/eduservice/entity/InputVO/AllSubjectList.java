package com.atguigu.eduservice.entity.InputVO;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("课程")
public class AllSubjectList {
    private String title;
   List<Subject> children;
}
