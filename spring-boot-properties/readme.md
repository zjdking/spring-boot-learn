1.spring boot 读取配置文件中的数据
@ConfigurationProperties(prefix = "") 将配置文件和类进行映射；然后通过类拿到配置内容
@Value()  
@PropertySource("classpath:/xx.yml") 指定读取那个配置文件    然后${} 就可以读取；

2.读取resource 下json 文件


3.配置文件加载的顺序
首先  整个项目下边的/config/.yml ==> 项目下边的xx.yml
      ==> 工程里边resource下边的config/xx.yml ==> resource下的xx.yml
但是对于maven项目打包只能导报src下的东西；所以对于外部配置文件，我们需要自己创建放在与打出的jar同级
加载顺序是  优先加载带profile的 （外部 appcation-{profile}.yml 内部）
           在加载不带profile的， 外==》内部   
