# Topic 01(tp01): 提炼函数 Extract Method
## Step 01(v01): 无局部变量
printBanner

## Step 02: 有局部变量
printDetails  
updateDueDate

## Step 03: 有局部变量（再赋值）
getOutstanding

# Topic 02: 内联函数 Inline Method
对简单的函数，应该直接使用函数体，去掉函数

# Topic 03: 提炼变量 Extract Variable / Introduce Variable(IDEA)
有些表达式长且复杂，难以理解。可以增加局部变量，帮助理解

# Topic 04: 内联变量 Inline Variable（略）
简单的表达式就直接用其本身，不用声明一个临时变量了，如 
`double basePrice = order.basePrice`

# Topic 05: 改变函数声明 
略

# Topic 06: 封装变量 Encapsulate Variable

# Topic 07: 重命名变量 Rename Variable

# Topic 08: 引入参数对象 Introduce Parameter Object
有一些数据项总是结伴而行，总是反复出现在各种函数中，
如开始时间和结束时间、温度的上限和下限 等，这时可以将其组合成一个新的数据结构。
## Step 01: 引入新类 NumberRange
1. 在 readingOutsideRange 方法中引入 NumberRange对象，暂不使用
1. 将原先的 min，max 参数使用的地方换成 NumberRange对象
1. 删除 min，max 参数

## Step 02: 将是否包含的这种行为抽取为一个方法
contains

# Topic 09: 函数组合成类 Combine Functions into Class
这次不一样，从测试类先开始
## 问题
1. 基础费用 baseCharge 在 client1 和 2 中被重复计算了

## Step 01: 将读取的数据结构封装成一个类 Reading
1. 将 client3 中 calculateBaseCharge 方法移到 Reading
1. 将 calculateBaseCharge 改为 getBaseCharge 
1. 改造 client1 
1. 改造 client2。分2步，首先将 baseCharge 替换掉
1. 再将税费的计算 getTaxableCharge 移到 Reading

# Topic 10: 独立函数组合成变换函数 Combine Functions into Transform
跟 09 很类似。

# Topic 11: 拆分 Split Phase
跟提前方法类似，都是将大段代码拆分成易于理解和复用的小单元。
