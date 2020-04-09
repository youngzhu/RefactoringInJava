# Ch12 处理继承关系

## Topic 01: 函数上移 Pull Up Method
## Topic 02: 字段上移 Pull Up Field
## Topic 03: 构造函数上移 Pull Up Constructor Body
## Topic 04: 函数下移 Push Down Method
## Topic 05: 字段下移 Push Down Field
## Topic 06: 以子类取代类型码 Replace Type Code with Subclass
如Employee可以分为：Engineer，Manager，Salesman
## Topic 07: 移除子类  Remove Subclass
如有三个类：Person，Male，Female。后两个类应该删除
## Topic 08: 提炼超类 Extract Superclass
## Topic 09: 折叠继承体系 Collapse Hierarchy
子类和父类没有多大区别时，可以删除子类
## Topic 10: 以委托取代子类 Replace Subclass with Delegate
**Example 1: 取代继承关系**  

现需要考虑两大分类：是野生的，还是家养的。
由于超类只能有一个，就无法用继承去实现类。
### v01 欧洲燕
1. 从最简单的欧洲燕开始，建一个空的委托类 EuropeanSwallowDelegate
1. 在Bird的构造函数中将委托类初始化
1. 将欧洲燕的getAirSpeedVelocity方法，复制到委托类中
1. 修改超类的getAirSpeedVelocity：如果有委托类就调用相应方法
1. 删除欧洲燕类，和工厂方法中 其相关部分

### v02 非洲燕
1. 处理非洲燕。它的委托类构造函数需要传入参数
1. 在Bird中初始化委托类时，发现需要创建一个超类 SpeciesDelegate
1. 将getAirSpeedVelocity方法，复制到委托类中
1. 删掉原来的类

### v03 挪威蓝鹦鹉
1. 经过前面的2个例子你会发现，复制原来的类变成 委托类 更快
1. 由于覆写了父类中的 plumage 属性，所以需要反向引用父类
(这块比较复杂，不能保证以下的每一步都测试通过)
1. 在委托超类中实现它的默认行为（复制Bird中的方法 getPlumage）
1. 修改Bird中的方法 getPlumage，调用委托类
1. Bird中初始化
1. 删除原来的类

**Example 2: 去除单个子类**
### 


## Topic 11: 以委托取代超类 Replace Superclass with Delegate
