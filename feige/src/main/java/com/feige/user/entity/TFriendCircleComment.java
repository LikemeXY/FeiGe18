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
@ApiModel(value="TFriendCircleComment对象", description="")
public class TFriendCircleComment extends BaseEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "fcc_id", type = IdType.AUTO)
    private Integer fccId;

    @ApiModelProperty(value = "用户id")
    private String fccUid;

    @ApiModelProperty(value = "朋友圈信息id")
    private Integer fcmid;

    @ApiModelProperty(value = "内容")
    private String context;

    @ApiModelProperty(value = "点赞数")
    private Integer likeCount;




}
