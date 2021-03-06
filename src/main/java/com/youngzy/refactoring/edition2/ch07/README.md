# Ch07 封装

## Topic 01: 封装记录 Encapsulate Record
将常见的数据结构，如json，封装成一个对象

## Topic 02: 封装集合 Encapsulate Collection
修改操作并不总是显而易见的。

所以，将修改控制住范围，可减少意外修改导致的错误。

### Step 01: 
1. 给 Person 类新增 添加和删除课程的方法
1. 为了将修改范围控制住，get方法返回一个副本，
即使对课程列表有操作也不会影响

## Topic 03: 以对象取代基本类型 Replace Primitive with Object
如电话号码，一个类（包含区号 和号码）要比几个字符串用着更方便

见 05。

## Topic 04: 以查询取代临时变量 Replace Temp with Query
同 内联变量

## Topic 05: 提炼类 Extract Class
1. 新建类 TelephoneNumber
1. 在Person类中引入 TelephoneNumber，并在构造函数中初始化
1. 将 officeAreaCode，officeNumber 复制到 TelephoneNumber
1. 在 getTelephoneNumber 中 使用 TelephoneNumber.toString
1. 将 TelephoneNumber 中变量重命名，去掉 office 元素

## Topic 06: 内联类 Inline Class
跟05刚好相反。

## Topic 07: 隐藏委托关系 Hide Delegate
`manager = person.department.manager`  
改为  
`manager = person.manager`

这样，对客户端就隐藏了 Person 和 Department 的关系。  
万一 Dept 的对外接口变了，也只需要修改 Person 类，而不影响客户端

## Topic 08: 移除中间人 Remove Middle Man
跟 07 刚好相反

## Topic 09: 替换算法 Substitute Algorithm
如果有了更好的算法，或者语言升级有了新特性，就换掉老算法
