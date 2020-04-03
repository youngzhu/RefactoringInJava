# Ch06 Composing Methods

## Topic 01: Extract Method (package tp01)
### Step 01: 没有参数传递的抽取（v01）
printBanner
### Step 02: 需要传递参数的抽取
printDetails
### Step 03: 对变量重新赋值
getOutstanding
### Step 04: 对变量重新赋值（升级版）
不是简单的初始化，如 = 0

改造前，  
V03: `double outstanding = 0;`  
V04: `double outstanding = previousAmount * 1.2;`
