package com.feige.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="Groupchatinfo对象", description="")
public class Groupchatinfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "群聊记录编号")
    @TableId(value = "gcno", type = IdType.ID_WORKER)
    private String gcno;

    @ApiModelProperty(value = "发送者id")
    @TableField("gCreceiveid")
    private String gCreceiveid;

    @ApiModelProperty(value = "内容")
    @TableField("Context")
    private String Context;

    @ApiModelProperty(value = "群编号")
    private Integer gon;

}
