package com.atguigu.eduservice.entity.object;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class PageQueryWrapper {
    @ApiModelProperty("当前页")
    private Integer current;
    @ApiModelProperty("每页的条数")
    private Integer limit;
    @ApiModelProperty("姓名模糊查询")
    private String name;
    @ApiModelProperty("创建起始时间")
    private Date gmt_create;
    @ApiModelProperty("创建结束时间时间")

    private Date gmt_modified;
}
