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
