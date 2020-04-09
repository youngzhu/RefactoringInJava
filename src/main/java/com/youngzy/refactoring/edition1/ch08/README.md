# Chapter 8. Organizing Data

## Topic 01: Self Encapsulate Field
自封装，get/set

价值体现在它有子类时
### v00
子类必须覆盖 includes 方法，否则逻辑不对
###v01
在父类的 includes 中使用 `getHigh` ，而不是 `high` 。
子类中的 includes 就可以删除

