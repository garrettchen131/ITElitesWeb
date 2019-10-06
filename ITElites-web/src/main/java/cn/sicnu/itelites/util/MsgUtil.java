package cn.sicnu.itelites.util;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

import java.io.IOException;

public class MsgUtil {
    private static int appID = 1400265362;
    private static String appKey = "f21e75f74257c2229ed0017a5e594113";
    private static int count = 0;

    public static boolean send(String msgCode, String phone) {
        SmsSingleSenderResult result = null;
        SmsSingleSender sender = new SmsSingleSender(appID, appKey);
        try {
            result = sender.send(0, "86", phone, count+"====="+msgCode, "", "");
            System.err.println(result);
        } catch (HTTPException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        count++;
        return true;
    }
}
