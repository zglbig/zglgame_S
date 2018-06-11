package org.zgl.tcp.proxy.socket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.zgl.tcp.proxy.message.IoMessagePackage;

/**
 * @作者： big
 * @创建时间： 2018/6/5
 * @文件描述：
 */
public class TcpServerSimpleChannelInboundHandler extends SimpleChannelInboundHandler<IoMessagePackage> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, IoMessagePackage msg) throws Exception {

    }
}
