# Step 01(package v01): 提炼函数
statement 方法太长了。

首先来处理 `switch` 部分。它是为了算出一场戏的费用。

所以抽取出一个方法，专门用来算某场戏的费用：`amountFor`。

方法返回的变量名定义为 `ret`（书中是 `result`）,方便一眼就看出这是个要返回的变量。

## 新建类 JSONUtil
移出 `loadPlays` 和 `loadInvoices` 方法，使 `Statement` 类更纯粹，更接近书中原意。

# Step 02: 减少临时变量
amountFor 方法中的2个参数并不是完全独立的。
第二个参数 play ，是通过第一个参数 performance 计算获得的。
所以可以减少变量，以一个函数取代，playFor

1. 创建 playFor 方法。在 statement 方法中调用
2. 移除 amountFor 方法中的 play 变量
3. 移除 statement 中 thisAmount 变量。内联变量

# Step 03: 提炼积分计算的逻辑
volumeCreditsFor



# 总结
1. 尽量减少临时变量。这样更方便提炼函数