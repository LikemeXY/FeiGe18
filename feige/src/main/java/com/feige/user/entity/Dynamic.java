package com.feige.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;

import com.feige.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author LIKE
 * @since 2020-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Dynamic对象", description="")
public class Dynamic extends BaseEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "动态编号")
    @TableId(value = "Don", type = IdType.ID_WORKER)
    private Integer Don;

    @ApiModelProperty(value = "用户id")
    private String uId;

    @ApiModelProperty(value = "动态图片")
    private String img;

    @ApiModelProperty(value = "动态视频")
    private String video;

    @ApiModelProperty(value = "动态类容")
    private String context;

}
