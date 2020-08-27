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
@ApiModel(value="Chatinfo对象", description="")
public class Chatinfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "cno", type = IdType.ID_WORKER)
    private Integer cno;

    private String uId;

    @TableField("Csendid")
    private String Csendid;

    @TableField("Creceiveid")
    private String Creceiveid;

    @TableField("Context")
    private String Context;


}
