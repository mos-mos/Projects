package com.farm.constants;

/**
 * @version 1.0
 * 公众号：Java架构栈
 * @Author: 卓不凡
 */
public enum  NodeId {
     ROOTNODE(0,"根节点");

    private int node;
    private String name;

    NodeId(int node, String name) {
        this.node = node;
        this.name = name;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
