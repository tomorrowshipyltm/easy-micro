package com.easy.micro.model.dataset;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class DatasetView implements Serializable {
    private Long id;

    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "文件地址")
    private String fileUrl;

    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @ApiModelProperty(value = "数据量")
    private Integer datasetCount;

    @ApiModelProperty(value = "是否展示：0->否；1->是")
    private Integer showStatus;

    private static final long serialVersionUID = 1L;

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

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getDatasetCount() {
        return datasetCount;
    }

    public void setDatasetCount(Integer datasetCount) {
        this.datasetCount = datasetCount;
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
        sb.append(", author=").append(author);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}