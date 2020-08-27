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
@ApiModel(value="Friends对象", description="")
public class Friends extends BaseEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "Fno", type = IdType.ID_WORKER)
    private Integer Fno;

    @ApiModelProperty(value = "用户id")
    private String uId;

    @ApiModelProperty(value = "好友id")
    @TableField("Fid")
    private String Fid;

    @ApiModelProperty(value = "备注")
    @TableField("Fremarks")
    private String Fremarks;

    @ApiModelProperty(value = "好友分组id")
    private String friendGroupId;

    @ApiModelProperty(value = "用户分组id")
    private String userGroupId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getFno() {
        return Fno;
    }

    public void setFno(Integer fno) {
        Fno = fno;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getFid() {
        return Fid;
    }

    public void setFid(String fid) {
        Fid = fid;
    }

    public String getFremarks() {
        return Fremarks;
    }

    public void setFremarks(String fremarks) {
        Fremarks = fremarks;
    }

    public String getFriendGroupId() {
        return friendGroupId;
    }

    public void setFriendGroupId(String friendGroupId) {
        this.friendGroupId = friendGroupId;
    }

    public String getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(String userGroupId) {
        this.userGroupId = userGroupId;
    }
}
