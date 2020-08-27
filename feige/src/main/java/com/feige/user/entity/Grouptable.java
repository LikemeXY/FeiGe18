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
 * Ⱥ
 * </p>
 *
 * @author LIKE
 * @since 2020-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Grouptable对象", description="Ⱥ")
public class Grouptable extends BaseEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "群编号")
    @TableId(value = "Gon")
    private String Gon;

    @ApiModelProperty(value = "群名称")
    @TableField("Gname")
    private String Gname;

    @ApiModelProperty(value = "群头像")
    @TableField("Gavater")
    private String Gavatar;

    @ApiModelProperty(value = "群主")
    private String master;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getGon() {
        return Gon;
    }

    public void setGon(String gon) {
        Gon = gon;
    }

    public String getGname() {
        return Gname;
    }

    public void setGname(String gname) {
        Gname = gname;
    }

    public String getGavater() {
        return Gavatar;
    }

    public void setGavater(String gavater) {
        Gavatar = gavater;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }


}
