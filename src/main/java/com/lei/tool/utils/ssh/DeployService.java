package com.lei.tool.utils.ssh;

import ch.ethz.ssh2.Connection;
import com.lei.tool.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * linux项目部署
 */
@Service
public class DeployService {

    /**
     * 获取项目信息
     * @param uuid
     * @return
     * @throws IOException
     */
    public String getStatus(String uuid)  {
        Connection connection = RemoteCommandUtil.login("172.16.3.242","root","tempus@$@");
        String result =  RemoteCommandUtil.execute(connection,"pkill -f  tomcat80");
        return result;
    }

    /**
     * 杀死进程
     */
    public void stop(){
        Connection connection = RemoteCommandUtil.login("172.16.3.242","root","tempus@$@");
        String result =  RemoteCommandUtil.execute(connection,"kill -9 tomcat80");
    }

    /**
     * 启动项目
     */
    public void start(){
        Connection connection = RemoteCommandUtil.login("172.16.3.242","root","tempus@$@");
        String result =  RemoteCommandUtil.execute(connection,"usr/local/tomcat80/bin/./startup.sh ");
    }


}
