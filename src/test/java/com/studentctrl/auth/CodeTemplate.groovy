package com.studentctrl.auth;

import java.util.*;
import com.ouyeel.platform.components.service.execute.engine.core.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CodeTemplate {
    static final Logger log = LoggerFactory.getLogger(this.class);

    public static void main(String[] args) {
        Map DATABLOCK = new HashMap();
        DATABLOCK.put("SERVERPARAM", new HashMap<>());
        Map testParam = (Map) DATABLOCK.get("SERVERPARAM");




        log.info("10901026分支判断");
//计数器COUNT
        if (DATABLOCK.get("COUNT") != null) {
            DATABLOCK.put("COUNT", DATABLOCK.get("COUNT") + 1);
        } else {
            DATABLOCK.put("COUNT", 0);
        }
//插入节点入参
        Map configDetailMap = new HashMap();
//页面传入List
        String configDetaiString = DATABLOCK.get("SERVERPARAM").get("CONFIG_DETAIL_LIST");
        List<HashMap> configDetailList = JsonUtil.json2Collection(configDetaiString, List.class, Map.class);
        if (configDetailList != null) {
            log.info("***************DATABLOCK.get(COUNT)=="+DATABLOCK.get("COUNT"));
            log.info("***************configDetailList.size()=="+configDetailList.size());
            if (DATABLOCK.get("COUNT") >= configDetailList.size()) {
                log.info("***************2");
                //计数结束则退出
                DATABLOCK.put("RETURN", new HashMap());
                DATABLOCK.get("RETURN").put("FLAG", "T");
                DATABLOCK.get("RETURN").put("MSG", "审核人添加成功");
                DATABLOCK.put("BRANCHLINE", "FALSE");
            } else {
                log.info("***************1");
                System.out.println("wuTaoTest1=====循环count" + DATABLOCK.get("COUNT"));
                configDetailMap.put("FACT_ID", configDetailList.get(DATABLOCK.get("COUNT")).get("FACT_ID"));
                configDetailMap.put("SALES_NO", configDetailList.get(DATABLOCK.get("COUNT")).get("SALES_NO"));
                configDetailMap.put("APPROVAL_NO", configDetailList.get(DATABLOCK.get("COUNT")).get("APPROVAL_NO"));
                configDetailMap.put("APPROVAL_NAME", configDetailList.get(DATABLOCK.get("COUNT")).get("APPROVAL_NAME"));
                configDetailMap.put("NOTICE_FLAG", configDetailList.get(DATABLOCK.get("COUNT")).get("NOTICE_FLAG"));
                configDetailMap.put("APPROVAL_STEP", configDetailList.get(DATABLOCK.get("COUNT")).get("APPROVAL_STEP"));
                configDetailMap.put("APPROVAL_MAX_MONEY", configDetailList.get(DATABLOCK.get("COUNT")).get("APPROVAL_MAX_MONEY"));
                configDetailMap.put("APPROVAL_MIN_MONEY", configDetailList.get(DATABLOCK.get("COUNT")).get("APPROVAL_MIN_MONEY"));
                configDetailMap.put("APPROVAL_SEQ", DATABLOCK.get("DATA_ROWS").get(0).get("APPROVAL_SEQ"));
                List prodList = new ArrayList();
                String str = configDetailList.get(DATABLOCK.get("COUNT")).get("PRODUCT_ID");
                if(str!=null&&!"".equals(str)){
                    String[] split = str.split(",");
                    for (int i = 0; i < split.length; i++) {
                        Map prodMap = new HashMap();
                        prodMap.putAll(configDetailMap);
                        prodMap.put("PRODUCT_ID", split[i]);
                        prodList.add(prodMap);
                    }
                }else{
                    Map prodMap = new HashMap();
                    prodMap.putAll(configDetailMap);
                    prodMap.put("PRODUCT_ID", "");
                    prodList.add(prodMap);
                }
                System.out.println("wutaoTest+configDetailMap'" + configDetailMap);
                DATABLOCK.put("configDetailMap", configDetailMap);
                DATABLOCK.put("prodList", prodList);
                DATABLOCK.put("BRANCHLINE", "TRUE");
            }
        } else {
            //无页面入参则退出
            DATABLOCK.get("RETURN").put("FLAG", "F");
            DATABLOCK.get("RETURN").put("MSG", "无新增审核人");
            DATABLOCK.put("BRANCHLINE", "FALSE");
        }
    }
}
