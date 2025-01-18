package org.example.ch11;

public class StringDataItem {

    private String strData;

    public StringDataItem(String strData) {
        this.strData = strData;
    }

    public String getKey() {
        return strData;
    }

    @Override
    public String toString() {
        return String.format("{strData: %s}", strData);
    }
}
