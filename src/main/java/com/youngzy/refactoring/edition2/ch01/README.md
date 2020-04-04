# Step 01，分解statement方法
statement 方法太长了。

首先来处理 `switch` 部分。它是为了算出一场戏的费用。

所以抽取出一个方法，专门用来算某场戏的费用：`amountFor`。

方法返回的变量名定义为 `ret`（书中是 `result`）,方便一眼就看出这是个要返回的变量。

## 新建类 JSONUtil
移出 `loadPlays` 和 `loadInvoices` 方法，使 `Statement` 类更纯粹，更接近书中原意。