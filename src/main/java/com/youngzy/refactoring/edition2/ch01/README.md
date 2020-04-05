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

# Step 06: 拆分
1. 将渲染txt部分的代码抽取出来，方面后面实现html的渲染
2. 将报表用到的字段封装到一个新的对象里
3. 创建一个空对象 StatementData，作为参数传入 renderPlainText
4. 将 customer 封装到 Data 类中
5. 将 performances 封装到 Data中
6. 新建类 EnrichPerformance 把 Play 包含进去
7. 将 renderPlainText 中的 playFor 用 data.performance.play 替换
8. 用 同样的方法处理 amountFor函数
9. 用 同样的方法处理 totalAmount 。同时改变了 totalAmount 的方法签名，加入了参数
9. 用 同样的方法处理 totalVolumeCredits 。同时改变了 totalVolumeCredits 的方法签名，加入了参数
9. 将 statement 方法中 对 data的处理抽取到一个方法中
9. 将 组装数据（create）和展示数据（statement）彻底分离，移到另一个文件中
9. 创建 html渲染

# Step 07: 重组计算过程
1. 创建一个计算类 PerformanceCalculator，在  enrichPerformance 方法中使用
1. 将 amountFor 方法移到 calculator 中
1. 将 volumeCreditsFor 方法移到 calculator 中
1. 移除 factory 类中 volumeCreditsFor 方法，
需要调整，因为 totalVolumeCredits 中用到了
1. 移除 factory 类中 amountFor 方法，
需要调整，因为 totalAmount 中用到了

# Step 08: 使用多态
1. 为calculator创建2个子类：TragedyCalculator，ComedyCalculator
1. 创建 createPerformanceCalculator 方法，根据不同的戏剧类型返回不同的计算器
1. 将 amount 的计算下移到子类中。 并将 父类中的 改为抽象函数
1. 将 volumeCredits 的计算下移到子类中。
这里 积分的计算比较特殊。只有喜剧类多了一步计算。
所以，将该方法保留在父类中，并将对 喜剧的处理下移到子类中

# 总结
1. 尽量减少临时变量。这样更方便提炼函数。而且变量越多意味着方法越长越复杂
1. 跟第一版相比，这里更好，结构更"好看"。主要体现在 引入 EnrichPerformance 。