package com.atguigu.eduservice.entity.InputVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageQuery {
    @ApiModelProperty("当前页")
    private Integer current;
    @ApiModelProperty("每页的条数")
    private Integer limit;
}
