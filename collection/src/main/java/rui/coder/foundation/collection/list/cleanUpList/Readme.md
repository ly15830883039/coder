# 清理`list`
[toc]

有时候，`list` 会“脏”。`list`可能为空，或者存在重复的数据，我们不光要将它们取出来，还有取的很快

## 清理 `list`中存在空
### 1. 使用java api 完成对list 的去除空数据
1. list 中提供了remove 方法 
2. removeAll方法可以去重
### 2. 使用 谷歌 guava
1. Iterables.removeIf 
2. Iterables.filter
### 3. 使用 apache commons collections 的
1. CollectionUtils.filter
### 4. 使用lambdas表达式
1. parallelStream 的filter 
2. Stream 的filter 
3. 新版本的list 新特性 removeIf

## 清理 `list`中的重复数据
### 1. 使用普通的java 实现
1. 通过set 这个数据结构来实现
### 2. 使用 谷歌 guava
1. Lists.newArrayList(Sets.newHashSet(list)); 本质上还是使用 上面的方式， 只不过是使用guava的 方式的去 new了
### 3.  使用lambdas表达式 Stream api
1. Stream 的distinct 方法

# 来源
1. [Removing all Nulls from a List in Java](http://www.baeldung.com/java-remove-nulls-from-list?utm_source=email-newsletter&utm_medium=email&utm_campaign=auto_36_java&tl_inbound=1&tl_target_all=1&tl_period_type=3)
2. [Removing all duplicates from a List in Java](http://www.baeldung.com/java-remove-duplicates-from-list?utm_source=email-newsletter&utm_medium=email&utm_campaign=auto_36_java&tl_inbound=1&tl_target_all=1&tl_period_type=3)