package org.example.ch11;

public class DataItem {

    private int iData;

    public DataItem(int iData) {
        this.iData = iData;
    }

    public int getKey() {
        return iData;
    }

    @Override
    public String toString() {
        return String.format("{iData: %s}", iData);
    }
}
