package edu.mum.lesson7;

public class WebInfo {

    private String addr;
    private int iconId;

    public WebInfo(String addr, int icon) {
        this.addr = addr;
        this.iconId = icon;
    }

    public String getAddr() {
        return addr;
    }

    public int getIconId() {
        return iconId;
    }
}
