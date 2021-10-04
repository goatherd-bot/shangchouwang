package com.atguigu.crowd.entity;

import java.util.List;

/**
 * @author rookie
 * @create 2021-10-03-15:31
 */
public class ParamData {
    private List<Integer> array;

    public ParamData() {
    }

    public ParamData(List<Integer> array) {
        super();
      this.array = array;
    }

    @Override
    public String toString() {
        return "ParamData{" +
                "array=" + array +
                '}';
    }

    public void setArray(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getArray() {
        return array;
    }
}
