# YueServer
悦妆web端

###
#2017-7-18
>数据库操作为mybatis半自动框架

###
#2017-7-19
>逐步转入spring mvc框架，初步登录校验跳转界面，spring超链接跳转

###
#2017-8-27
>controller 包的类，为接受前端数据发送与将数据发送至前端进行数据展现

>adaper 包的类，为数据的格式转换，字符串的编码，数据加密处理

>security 包的类，为spring-security登录验证的实现类，关于spring-security的具体实现类将都在这个包中

>bean 包的类，为mybatis的持久对象层，存放POJO

>database 包的类，为数据库框架mybatis的实现与具体数据库数据操作的方法实现

>service 到 sql 的数据传输据采用 List或Map 传输, service 到 controller 为ResultBean 传输

###
#2017-9-2
>在controller层调用相关的service层的方法即可,

>若需要增加业务需要,在service层进行接口的方法补充并与数据库对接即可

###
#2017-9-3
>数据库操作层面,service层只能见到 AdminSql 与 MerchantSql 这两个数据库操作, 这两个数据库操作根据权限实现不同的数据库权限操作

###
#2017-9-4
>修复隐藏bug, 全局共享登录用户信息, 在controller包的LoginController类的getPrincipal()方法,返回一个符合项目需求的UserDetails对象

###
#2017-9-14
>加入单例、原型设计模式，其中，adaper包中的AdaperFactory类中的方法进行获取adaper.conver和adaper.encryption的方法
>通过输入对应的MD5，Base64获取encryption；list，json，url获取convert（不限大小写）
