package org.zgl.platform.dto;

import org.zgl.IDto;

import java.util.List;

/**
 * @作者： big
 * @创建时间： 2018/6/12
 * @文件描述：
 */
public class StaticDataDto implements IDto {
    List<StaticDataModelDto> data;

    public StaticDataDto() {
    }

    public StaticDataDto(List<StaticDataModelDto> data) {
        this.data = data;
    }

    public List<StaticDataModelDto> getData() {
        return data;
    }

    public void setData(List<StaticDataModelDto> data) {
        this.data = data;
    }
}
