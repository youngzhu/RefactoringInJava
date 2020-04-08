# Ch11 重构API

## Topic 01: 将查询函数和修改函数分离 Separate Query from Modifier
方法尽量简单，一个方法只做一件事

## Topic 02: 函数参数化 Parameterize Function
如果2个函数很类似，只有少量值不同，则将2个函数合并，不同的地方用参数表示

## Topic 03: 移除标记参数 Remove Flag Argument
所谓标记参数，就是根据它走不同的分支

## Topic 04: 保持对象完整性 Preserve Whole Object
将数据封装成类

## Topic 05: 以查询取代参数 Replace Parameter with Query
尽量减少方法参数的个数

## Topic 06: 以参数取代查询 Replace Query with Parameter
目的：改变依赖关系，降低耦合

## Topic 07: 移除设值函数 Remove Setting Method
id之类不应该在变化的属性，应该直接在构造函数里赋值，而去掉 set 方法

## Topic 08: 以工厂函数取代构造函数 Replace Constructor with Factory Function
Java中构造函数的缺点：
1. 只能返回当前类的实例，而无法获得子类或代理类
1. 构造函数的名字是固定的

## Topic 09: 以命令取代函数 Replace Function with Command
## Topic 10: 以函数取代命令 Replace Command with Function
