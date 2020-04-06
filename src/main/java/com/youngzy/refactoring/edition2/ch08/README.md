# Ch08 搬移

**主旨是：消除重复代码**

## Topic 01: 搬移函数 Move Function
getOverdraftCharge 跟类型 type 有关。所以可以把这个方法移到 Type 类

1. 将 getOverdraftCharge 方法移到 Type 类
2. 去掉 Account 类中的 getOverdraftCharge 

## Topic 02: 搬移字段 Move Field
Account 里有个 利息 字段。  
利息应该跟类型相关，所以 移到 Type 里

## Topic 03: 搬移语句到函数 Move Statements into Function
## Topic 04: 搬移语句到调用者 Move Statements to Callers
## Topic 05: 以函数调用取代内联代码
## Topic 06: 移到语句 Slide Statements
将有关联的语句放到一起
## Topic 07: 拆分循环 Split Loop
一个循环只做一件事
## Topic 08: 以管道取代循环 Replace Loop with Pipeline
## Topic 09: 移除死代码 Remove Dead Code