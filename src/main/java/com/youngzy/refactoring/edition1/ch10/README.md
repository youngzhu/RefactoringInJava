# Chapter 10. Making Method Calls Simpler

## Topic 01: Rename Method

## Topic 02: Add Parameter

## Topic 03: Remove Parameter

## Topic 04: Separate Query from Modifier
让方法尽量简单。一个方法只做一件事

## Topic 05: Parameterize Method
类似的方法应该合并成一个方法，其中的不同用参数区分

## Topic 06: Replace Parameter with Explicit Methods

## Topic 07: Preserve Whole Object
参数中用到某个对象的多个属性，拿索性将整个对象传过去
如果方法的参数多了，就将他们组合成一个对象

## Topic 08: Replace Parameter with Method
主要想试一下重构菜单里的是不是这个意思。  
No。没有一步到位的，还是从 Extract Method 开始

精髓在这：把参数都去掉类