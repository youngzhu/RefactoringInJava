# Step 01(package v01): 提炼函数
statement 方法太长了。

首先来处理 `switch` 部分。它是为了算出一场戏的费用。

所以抽取出一个方法，专门用来算某场戏的费用：`amountFor`。

方法返回的变量名定义为 `ret`（书中是 `result`）,方便一眼就看出这是个要返回的变量。

## 新建类 JSONUtil
移出 `loadPlays` 和 `loadInvoices` 方法，使 `Statement` 类更纯粹，更接近书中原意。

# Step 02: 减少临时变量
> 临时变量会鼓励你写长而复杂的函数
>

amountFor 方法中的2个参数并不是完全独立的。
第二个参数 play ，是通过第一个参数 performance 计算获得的。
所以可以减少变量，以一个函数取代，playFor

1. 创建 playFor 方法。在 statement 方法中调用
2. 移除 amountFor 方法中的 play 变量
3. 移除 statement 中 thisAmount 变量。内联变量

# Step 03: 提炼积分计算的逻辑
volumeCreditsFor

# Step 04: 移除 format 变量
RMB

注意：这里还将每次 / 100 保留2位小数的部分一起放到了 RMB 方法里。

# Step 05: 移除积分总和、总金额 的临时变量
1. 首先将积分总和的计算从原循环中取出，新建一个循环
2. 移动声明变量的位置，使其紧邻循环
3. 提炼函数 totalVolumeCredits
4. 使用内联函数，去除临时变量

以同样操作移除 总金额的临时变量

# 总结
1. 尽量减少临时变量。这样更方便提炼函数