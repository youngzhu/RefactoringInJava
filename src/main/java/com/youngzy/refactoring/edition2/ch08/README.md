# Ch08 搬移

## Topic 01: 搬移函数 Move Function
getOverdraftCharge 跟类型 type 有关。所以可以把这个方法移到 Type 类

1. 将 getOverdraftCharge 方法移到 Type 类
2. 去掉 Account 类中的 getOverdraftCharge 

## Topic 02: 搬移字段 Move Field
Account 里有个 利息 字段。  
利息应该跟类型相关，所以 移到 Type 里