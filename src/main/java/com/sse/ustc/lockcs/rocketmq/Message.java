package com.sse.ustc.lockcs.rocketmq;

import org.apache.yetus.audience.InterfaceAudience;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: Message
 * Package: com.sse.ustc.lockcs.rocketmq
 * Description:
 *
 * @Author: zwd
 * @Create: 2023/6/8 - 19:13
 * @Version: v1.0
 */
public class Message {
    private Integer sid;
    private Integer cid;

    public Message() {
    }

    public Message(Integer sid, Integer cid) {
        this.cid = cid;
        this.sid = sid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

}
