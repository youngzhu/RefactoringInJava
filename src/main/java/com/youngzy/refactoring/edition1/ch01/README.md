## Step 01(v01): Extract Method

`switch` 部分就是计算某一部电影的费用。

将其抽取出一个方法：amountFor，专门用来计算某部电影的费用

## Step 02: Move Method
`amountFor`方法只用到了 Rental 对象，没用到 Customer 信息。

方法放在了错误的对象里。

改之。放到 Rental 里更合适。

遵照小步改进的原则（每完成一步都要测试）：
1. 将 amountFor 方法复制到 Rental，需调整。然后Customer 的 amountFor 方法直接调用 Rental 的新方法。delegate to the new method.
2. 将所有用到 Customer.amountFor 的地方 换成 Rental.getCharge 
3. 删除 Customer.amountFor 方法
