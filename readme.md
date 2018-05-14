# Spring Boot Examples

这个项目是用来演示和测试如何使用Spring Boot 来构建应用

### deploy-tomcat

演示如何让Spring boot 程序既可以单独运行（内置Tomcat），也可以部署到外部的Tomcat容器中
网上有很多例子是要在引入依赖spring-boot-starter-web的时候要排除spring-boot-starter-tomcat
如下：

```maven
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

但是通过Intellij IDEA的模块向导建立模块的时候只要选择打包模式为 war， 那么他会
自动帮我们创建一个ServeletInitializer类，然后部署到Tomcat容器就能用。另外一个关键
的地方是对spring-boot-starter-tomcat依赖的使用。这里的scope用了provided。对于
provided的依赖项，事实上会参与编译，测试，运行等周期。相当于compile，
但是在打包阶段做了exclude的动作。

```maven
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-tomcat</artifactId>
    <scope>provided</scope>
</dependency>