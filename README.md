配置导航服务
=======

通过此文件，您能够更容易地使用此服务。 
--------

> #  1 下载此项目到本地
> # 2 配置项目中的ChoiceNavigation.xml文件

> # 标签详解
>> ##  2.1 steps标签

>> steps标签是用来放置所有要更改的配置数据的。

>>> ###   2.1.1 location标签

>>> location标签中填写所需配置文件的地址。`注：此地址需填写绝对路径`<br> 

>>> `例：` <br> 

>>> `<location>D:/Test.properties</location>`
### 2.1.2 step标签

>>> step标签是用来存储每一步所配置的数据。name为每一步的名字。

>>> `例：` <br> 
>>> `<step name="数据库配置">`














# > 3 实例化NavigationConfigServer对象

# > 4 在网页中更改数据
# > 5 [点击此处查看演示](http://120.27.19.38:7893/welcome.html)
