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
@ApiModel(value="UserGroup对象", description="")
public class UserGroup extends BaseEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "关系编号")
    @TableId(value = "ugno", type = IdType.ID_WORKER)
    private Integer ugno;

    @ApiModelProperty(value = "群编号")
    @TableField("Gon")
    private String Gon;

    @ApiModelProperty(value = "用户id")
    private String uId;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUgno() {
        return ugno;
    }

    public void setUgno(Integer ugno) {
        this.ugno = ugno;
    }

    public String getGon() {
        return Gon;
    }

    public void setGon(String gon) {
        Gon = gon;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

}
