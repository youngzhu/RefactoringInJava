# Ch10 简化条件逻辑

## Topic 01: 分解条件表达式 Decompose Conditional
先读懂代码：夏天跟其他季节的计算方法不一样

1. 将判断是否夏天的方法提取到一个方法里
1. 将夏天的算法抽取到一个方法里：summerCharge
1. 将其他季节的算法抽取到一个方法里：regularCharge
1. 最后，使用三目运算符

## Topic 02: 合并条件表达式 Consolidate Conditional Expression
条件不同，最终行为一致的，可以合并为一个表达式

`if (A) return 0; `   
`if (B) return 0;`

改为 `if (A || B) return 0;`

也可以将 A和B 合并为一个有意义的函数

## Topic 03: 以卫语句取代循环嵌套条件语句 Replace Nested Conditional with Guard Clauses
所谓卫语句就是比较特殊的检查条件，应该立刻返回。
if-else 分支是平等的。卫语句是给该条件以特别的重视。

## Topic 04: 以多态取代条件表达式 Replace Conditional with Polymorphism
## Topic 05: 引入特例 Introduce Special Case
### v01
1. 给 customer 类新增一个方法：isUnknown()
1. 新建特殊类 UnknownCustomer，继承自 customer 
1. 在 Client 类新增一个 isUnknown(customer) 方法，并替换所有检查的地方
1. 修改 Site 的 getCustomer，如果为null，则返回 UnknownCustomer 对象
1. 在 UnknownCustomer 中 覆盖 getName 方法，返回一个默认的名字
### v02
1. clientOne 就可以去掉条件判断
1. 同样的方式处理 clientTwo
1. clientThree 是个更新操作，用一个空方法覆盖（测试类有问题）
1. 处理 clientFour
1. 移除Client类中的 isUnknown(Customer customer) 方法
 

