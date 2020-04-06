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
