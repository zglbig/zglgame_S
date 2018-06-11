package org.zgl.tcp.proxy.socket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.zgl.tcp.proxy.message.IoMessage;
import org.zgl.tcp.proxy.message.IoMessageBaseTypeImpl;
import org.zgl.tcp.proxy.message.IoMessageJavaTpeImpl;
import org.zgl.tcp.proxy.message.IoMessagePBTypeImpl;
import org.zgl.tcp.utils.ProtostuffUtils;

/**
 * @作者： big
 * @创建时间： 2018/6/5
 * @文件描述：
 */
public class IoMessageToByteEncoder extends MessageToByteEncoder<IoMessage> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, IoMessage msg, ByteBuf byteBuf) throws Exception {
        if(msg == null){
            throw new RuntimeException("数据回发异常,消息踢不能为空");
        }
        byteBuf.writeInt(-777888);//包头:请使用一个不常用到的int类型数据
        //数据类型
        short dataDest = -55;
        if(msg instanceof IoMessageJavaTpeImpl){
            dataDest = 2;
        }else if(msg instanceof IoMessageBaseTypeImpl){
            dataDest = 1;
        }else if(msg instanceof IoMessagePBTypeImpl){
            dataDest = 2;
        }
        byteBuf.writeShort(dataDest);
        byte[] buf = ProtostuffUtils.serializer(msg);
        byteBuf.writeShort(buf.length);
        byteBuf.writeBytes(buf);//数据
    }
}
