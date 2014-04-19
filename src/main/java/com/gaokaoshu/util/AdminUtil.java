package com.gaokaoshu.util;

import javax.servlet.http.HttpSession;

/**
 * 判断是否是管理员
 * Created by LiuShuang on 14-4-19.
 */
public class AdminUtil {
    public static boolean isAdmin(HttpSession session) {
        try {
            if (session.getAttribute(Constant.IS_ADMIN) != null) {
                boolean isAdmin = (Boolean) session.getAttribute(Constant.IS_ADMIN);
                if (isAdmin) {
                    return true;
                }
            }
        } catch (Exception e) {
            //ignore
        }
        return false;
    }
}
