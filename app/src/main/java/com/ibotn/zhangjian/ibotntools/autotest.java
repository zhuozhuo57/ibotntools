package com.ibotn.zhangjian.ibotntools;

import com.google.common.base.Strings;

/**
 * Created by zhangjian on 2018/6/7.
 */

public class autotest {
    public void manin(String[] strings) {
        System.out.print("This autotest program is begining");
        strings[0] = "devices name";
        strings[1] = "software version";
        strings[2] = "test plan";
        strings[3] = "test content";
        strings[4] = "test result";
        strings[5] = "test time";
        strings[6] = "tester";
        strings[7] = "test report url";

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Strings getdeviceid(Strings strings) {

        return strings;
    }
}
