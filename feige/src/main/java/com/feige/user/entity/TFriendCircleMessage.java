package com.feige.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="TFriendCircleMessage对象", description="")
public class TFriendCircleMessage extends BaseEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "FcmId", type = IdType.AUTO)
    private Integer FcmId;

    @ApiModelProperty(value = "用户id")
    private String uid;

    @ApiModelProperty(value = "内容")
    private String context;

    @ApiModelProperty(value = "照片")
    private String picture;

    @ApiModelProperty(value = "视频")
    private String video;




}
