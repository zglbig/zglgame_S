package org.zgl.http.message;

/**
 * @作者： big
 * @创建时间： 2018/6/8
 * @文件描述：
 */
public class IoMessagePackage {
    private short dataSrc;
    private IoMessage ioMessage;

    public IoMessagePackage(short dataSrc, IoMessage ioMessage) {
        this.dataSrc = dataSrc;
        this.ioMessage = ioMessage;
    }

    public short getDataSrc() {
        return dataSrc;
    }

    public IoMessage getIoMessage() {
        return ioMessage;
    }
}
