package com.xyls.common.main;


import com.xyls.common.systemInfo.SysInfo;

import java.io.IOException;


public class DevExit {
    public static void devExit(){
        if(SysInfo.getSysInfo().getOsName().trim().toLowerCase().startsWith("win")){
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
    }
}
