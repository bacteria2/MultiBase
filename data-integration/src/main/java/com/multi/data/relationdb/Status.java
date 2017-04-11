package com.multi.data.relationdb;

/**
 * @author shepard.xia
 * @date 2017年04月11日
 * @description input useage
 */
public enum Status {
    NORMAL((short) 1),TEST((short)2),IRREGULAR((short)3),BANNED((short)4),DISABLED((short)5);

    private short status;

    Status(short status) {
        this.status = status;
    }

    public boolean statusEquals(short status){
        return this.status==status;
    }

    public short getStatus() {
        return status;
    }
}
