# Chapter 8. Organizing Data

## Topic 01: Self Encapsulate Field
自封装，get/set

价值体现在它有子类时
### v00
子类必须覆盖 includes 方法，否则逻辑不对
###v01
在父类的 includes 中使用 `getHigh` ，而不是 `high` 。
子类中的 includes 就可以删除

## Topic 02: Replace Data Value with Object
## Topic 03: Change Value to Reference
## Topic 04: Change Reference to Value
## Topic 05: Replace Array with Object
````
String[] arr;
arr[0]，表示名称
arr[1]，表示得分
arr[2]，表示失分
````

可以创建一个类
````
class Game {
private String name, wins, loses;
}
````

## Topic 06: Duplicate Observed Data
## Topic 07: Change Unidirectional Association to Bidirectional
## Topic 08: Change Bidirectional Association to Unidirectional
## Topic 09: Replace Magic Number with Symbolic Constant
## Topic 10: Encapsulate Field
## Topic 11: Encapsulate Collection
对集合的操作重新封装 addXXX, remove 等方法
````
public Set getCourses() {
 return Collections.unmodifiableSet(_courses);
 }
 ````
## Topic 12: Moving Behavior into the Class
## Topic 13: Replace Record with Data Class
## Topic 14: Replace Type Code with Class
枚举，如 血型
## Topic 15: Replace Type Code with Subclasses
如员工，包括 经理、销售，工程师等

## Topic 16: Replace Type Code with State/Strategy
不能创建子类时可使用。  
如 普通员工可以晋升为经理，如果有两个类就不太合适。
用 `setType` 可以在员工和经理直接切换