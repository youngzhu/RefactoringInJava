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

## 增加HTML实现
这时增加HTML实现要方便的多，而且会减少很多重复代码

## Step 05: 用多态替换条件语句
1. 在A对象中对B对象的某个属性值使用 switch ，不好。改之。将Rental中的getCharge方法复制到Movie中，Rental调用Movie的方法
2. 删除Rental中的方法。
3. 对 getFrequentRenterPoints 一样，重复上2步

### 状态模式
1. 创建新类：Price ...
2. 将Movie中 priceCode 从基本类型改为 Price 对象
3. 将 Movie 中的 getCharge 方法移到 Price 中
4. 使用多态，将 getCharge 的实现分布到子类中
5. 将 Price 中的 getCharge 改为抽象方法
6. 对 getFrequentRenterPoints 方法，做同样的事情。
不同的是，该方法不必分散到所有子类中。
所以父类中的方法不必改为抽象。
只对特定子类实现即可，其余子类共享父类的。

## 总结
最后使用多态时，**为什么不是创建 Movie 的子类 ChildrenMovie ... ，
而是新建了一个 Price 类？**

我的第一反应也是对 Movie 创建子类。

问题在于这可能影响Movie的外部行为。
具体来说 就是 Test 类创建Movie的地方也需要改了。

而引入 Price 类，再使用多态则不用。改变 只 在 Movie 类中发生。

对Movie创建子类也是可以的，但这个应该是在设计阶段。  
重构时引入 Price 类，可以缩小影响的范围。
