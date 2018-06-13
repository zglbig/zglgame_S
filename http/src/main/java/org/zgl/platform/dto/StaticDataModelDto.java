package org.zgl.platform.dto;

import org.zgl.IDto;

import java.util.List;

/**
 * @作者： big
 * @创建时间： 2018/6/12
 * @文件描述：静态数据序列化
 */
public class StaticDataModelDto implements IDto {
    //类名 是那个静态数据类
    private String clazzName;
    //类的数据
    List<IDto> clazzData;

    public StaticDataModelDto() {
    }

    public StaticDataModelDto(String clazzName, List<IDto> clazzData) {
        this.clazzName = clazzName;
        this.clazzData = clazzData;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public List<IDto> getClazzData() {
        return clazzData;
    }

    public void setClazzData(List<IDto> clazzData) {
        this.clazzData = clazzData;
    }
}
