package com.wbu.hw.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeUtils {

    public static String getCode() {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        return "T-"+sdf.format(new Date());
    }

}
