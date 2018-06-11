package org.zgl.utils.builder_rpc_interface;

/**
 * @作者： big
 * @创建时间： 2018/6/6
 * @文件描述：
 */
public class ParamertModel {
    private String type;
    private String name;

    public ParamertModel(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
