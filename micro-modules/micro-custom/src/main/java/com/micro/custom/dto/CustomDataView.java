package com.micro.custom.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户数据Demo
 */
public class CustomDataView implements Serializable {
    private Long id;

    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "文件地址")
    private String fileUrl;

    private static final long serialVersionUID = 1L;

    public CustomDataView() {}
    public CustomDataView(Long id, String name, String description, String fileUrl) {
        this.id = id;
        this.name = name;
        this.fileUrl = fileUrl;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", fileUrl=").append(fileUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}