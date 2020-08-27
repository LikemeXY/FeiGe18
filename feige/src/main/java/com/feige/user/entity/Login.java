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
@ApiModel(value="Login对象", description="")
public class Login extends BaseEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "登录编号")
    @TableId(value = "Lon", type = IdType.ID_WORKER)
    private Integer Lon;

    @ApiModelProperty(value = "用户id")
    private String uId;

    @ApiModelProperty(value = "登录ip")
    @TableField("Lip")
    private String Lip;

    @ApiModelProperty(value = "端口号")
    @TableField("Lport")
    private String Lport;




}
