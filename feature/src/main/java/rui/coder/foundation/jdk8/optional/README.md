# Optional
这个类主要目的就是为了消除困扰人们的 `NullPointerExceptions`

## 使用
1. Optional 应该只用于返回类型,如果作为参数和入参，编译器会有提示。
2. 

## 创建Optional
1. 使用 of 只能创建不为 null 的 Optional
2. 使用 ofNullable 可以创建为null 的 Optional

## 判断是否为空 
1. isPresent

## 获取 get
1. 如果为空，抛出NoSuchElementException。

## 逻辑处理
### 存在，然后处理
1. ifPresent ：如果Optional实例有值则为其调用consumer，否则不做处理
### 有值返回，无值返回指定
1. orElse 无值返回入参
2. orElseGet 无值 返回 其 lambdas 值。
3. orElseThrow 无值  抛出supplier接口创建的异常。

## 数据处理
1. map ： 修改并返回
2. flatMap : 返回的参数 必须是 Optional
3. filter : 如果匹配返回原值，不匹配则返回空Optional