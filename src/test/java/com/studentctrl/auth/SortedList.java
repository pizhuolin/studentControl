package com.studentctrl.auth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedList<T> extends ArrayList<T> {
    public void Add(T item) {
        //查询新元素在现有集合中的位置
        int position = getIndex(this, item);

        //如果小于0则表示，元素在集合中不存在
        if (position < 0) {
            position = ~position; //使用“按位求补运算符”确定新元素的插入位置
        }
        this.add(position, item);
    }

    public void ModifySorted(T item, int index) {
        int position = getIndex(this, item);;
        if (position < 0) {
            return;
        }
        this.set(position, item);

    }


    private int getIndex(List<T> list, T item) {
        for (int i = 0; i < list.size(); i++) {
            if (item == list.get(i)) {
                return i;
            }
        }

        return -1;
    }
}
