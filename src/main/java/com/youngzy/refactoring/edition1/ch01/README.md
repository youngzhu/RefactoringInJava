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
4. 由于 `thisAmount`变量不会再改变，显得有点多余，直接用 `Rental.getCharge` 替代。Replace Temp with Query

> IDEA 的 `Replace Temp with Query` 菜单，会直接在类里新增一个方法。所以现实中要做就尽早。
>这里尊重原文，手动改一下。
>
## Step 03：抽取积分计算的代码
1. Extract Method：getFrequentRenterPoints
2. 将上述方法移到 Rental 类
3. 删除 Customer.getFrequentRenterPoints 方法

## Step 04: Removing Temps
局部变量多了会滋生问题。  
优点：变量抽取成方法之后方便复用  
缺点：可能导致重复代码，如遍历

对相同的列表多几次遍历，对性能几乎没影响。但代码逻辑会更清晰。

> 直接用 IDEA 的 `Replace Temp with Query` 菜单会出错，因为它不是一个只读变量，而是会改变。所以要手动重构
>

1. 将变量 totalAmount 替换成方法 getTotalCharge
1. 将变量 frequentRenterPoints 替换成方法 getTotalfrequentRenterPoints
