package com.atguigu.eduservice.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SubjectData {
    @ApiModelProperty("一级目录")
    @ExcelProperty(index = 0)
    private String oneLevel;
    @ApiModelProperty("二级目录")
    @ExcelProperty(index = 1)
    private String twoLevel;

}
