package com.example.sabrina_hm4_3m;

import java.io.Serializable;

public class Continent implements Serializable {

    private String name;
    private String flag;

    public Continent(String name, String flag) {
        this.name = name;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
