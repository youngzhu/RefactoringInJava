# Chapter 11. Dealing with Generalization

## Topic 01: Pull Up Field
将相同的字段移到父类

## Topic 02: Pull Up Method

## Topic 03: Pull Up Constructor Body
使用 super(xx) 初始化相同的信息

## Topic 04: Push Down Method
只跟某个子类相关的，移到子类中

## Topic 05: Push Down Field

## Topic 06: Extract Subclass
如果某些属性很少用到，或者只是某些特殊场景用到，则创建一个子类

## Topic 07: Extract Superclass
两个类有太多相似之处，给他们建一个父类

## Topic 08: Extract Interface

## Topic 09: Collapse Hierarchy
去掉继承关系

## Topic 10: Form Template Method
模板方法：
````
a = xxx; // 2个类中有差别
b = yyy; // 有差别
return a + b; // 无差别
````
这时可以创建一个模板对象

````
class TemplateObject {
    getA();
    getB();
    // 上面（不同的部分）交给各子类实现
    // 相同的部分交给父类
    getReturn();
}
````

从第一章的 例子开始。

### v01 准备
1. 建3个空的类：Statement，TextStatement，HtmlStatement
1. 将 Customer 中的 statement 方法移到 TextStatement 中
1. 同样的方式，处理 htmlStatement
1. 修改HtmlStatement中方法的名字，同 TextStatement，一样的名字方便模版化

### v02 开始模板化
将相同/类似的步骤抽取出来
1. headerString
1. footerString
1. eachRentalString
1. 将以上3个方法复制到父类中，并抽象化
1. 将statement方法剪切到父类中，删除子类中的该方法

## Topic 11: Replace Inheritance with Delegation
如果子类只用到父类一小部分的特性，那就把继承换成委托

## Topic 12: Replace Delegation with Inheritance