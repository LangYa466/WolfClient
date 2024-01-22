package cn.langya.util.impl.misc;

import cn.langya.Wolf;
import cn.langya.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author LangYa
 * @date 2024/1/19 下午 05:21
 */

public class ClientUtil extends Util {
    private static Logger logger =  LogManager.getLogger(Wolf.name);

    public static void loginfo(String s) {
        logger.info(s);
    }

}
