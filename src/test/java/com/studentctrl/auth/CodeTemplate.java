package com.studentctrl.auth;

import java.util.*;

public class CodeTemplate {
    public static void main(String[] args) {
        Map DATABLOCK = new HashMap();
        DATABLOCK.put("SERVERPARAM", new HashMap<>());
        Map testParam = (Map) DATABLOCK.get("SERVERPARAM");

        int i = 0;
        List<Map<String, ?>> testList = new ArrayList<>();
        while(i < 10) {
            testParam.put("id", i);
            testParam.put("name", "小李");
            testParam.put("fs", "16");
            testParam.put("bj", "女");
            testList.add(testParam);
            i++;
        }
        DATABLOCK.put("testList", testList);

        List allList = (List) DATABLOCK.get("testList");

        if (allList.size() <= 0) {
            DATABLOCK.put("RETURN", false);
            return;
        }

        DATABLOCK.put("RETURN", true);
        DATABLOCK.put("testMap", allList.get(0));

        List deleteList = (List) DATABLOCK.get("testList");
        deleteList.remove(0);
        DATABLOCK.put("testList", deleteList);
    }
}
