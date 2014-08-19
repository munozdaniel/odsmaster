package com.wipro.wess.pdm.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class SecurityUtil {

    public static boolean checkRight(String permissionName) {
        boolean isPermitted = false;
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            if (permissionName != null) {
                isPermitted = subject.isPermitted(permissionName);
            }
        }
        return isPermitted;
    }

    public static boolean checkSitePermission(String orgId, String siteId) {
        String resultSiteId = formatSitePermission(orgId, siteId);
        return checkRight(resultSiteId);
    }

    public static String formatSitePermission(String orgId, String siteId) {
        String result = null;
        if (StringUtil.isNotEmpty(orgId) && StringUtil.isNotEmpty(siteId)) {
            StringBuffer siteIdBuff = new StringBuffer();
            siteIdBuff.append(orgId);
            siteIdBuff.append(":");
            siteIdBuff.append(siteId);
            result = siteIdBuff.toString();
        }
        return result;
    }

}
