package com.newcoder.community.entity;

/**
 * @Auther: geguofeng
 * @Date: 2020/11/11
 * @Description:
 */
public class Page {

    private int current = 1;

    private int limit = 10;

    private int rows;

    private String path;

    /**
     * 回去当前页的起始行
     * @return
     */
    public int getOffset(){
        return (current -1) * limit;
    }

    public int getTotal(){
        if(rows % limit == 0){
            return rows/limit;
        }else {
            return rows/limit+1;
        }
    }

    public int getFrom(){
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    public int getTo(){
        int to = current + 2;
        return to > getTotal()? getTotal():to;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit >=1 && limit < 100) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows >= 0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
