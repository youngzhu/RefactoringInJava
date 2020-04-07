# Ch06 Composing Methods

## Topic 01: Extract Method (package tp01)
### Step 01: 没有参数传递的抽取（v01）
printBanner
### Step 02: 需要传递参数的抽取
printDetails
### Step 03: 对变量重新赋值
getOutstanding
### Step 04: 对变量重新赋值（升级版）
不是简单的初始化，如 = 0

改造前，  
V03: `double outstanding = 0;`  
V04: `double outstanding = previousAmount * 1.2;`

## Topic 02: Inline Method
如果一个方法过于简单，应该直接使用方法体代码，而不是调用方法

## Topic 03: Inline Temp
如果一个变量的表达式不复杂，应该直接使用表达式，而不是声明一个变量

如：
````
double price = product.getPrice();
return price > 1000;
````

应该换成：
````
return product.getPrice() > 1000;
````

## Topic 04: Replace Temp with Query
## Topic 05: Introduce Explaining Variable
将一些表达式声明成一个能够表达含义的变量

## Topic 06: Split Temporary Variable
不要给同一个变量赋予不同含义的值。多定义几个变量

## Topic 07: Remove Assignments to Parameters
不要给传入的参数重新赋值

## Topic 08: Replace Method with Method Object
## Topic 09: Substitute Algorithm
时代在进步，算法也在进步  
看第二版（JavaScript）的时候就在想，如果是Java该怎么优化。
没想出来。。  
书里的方法不错

