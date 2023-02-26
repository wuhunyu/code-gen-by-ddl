## code-gen-by-ddl

#### 简介

这是一个在线代码生成器，核心使用 **druid** 框架 和 **freemarker** 模板引擎。其中使用 **druid** 解析 **mysql** 的 **ddl** 语句，使用 **freemarker** 生成模板。也就是在线解析 **ddl** 语句，并根据解析结果生成 Java 模板代码的一款 web 应用。

**ddl** 语句是什么，这里引用一下 **wiki**

> In the context of [SQL](https://en.wikipedia.org/wiki/SQL), **data definition** or **data description language** (**DDL**) is a syntax for creating and modifying database objects such as tables, indices, and users. DDL statements are similar to a computer [programming language](https://en.wikipedia.org/wiki/Programming_language) for defining [data structures](https://en.wikipedia.org/wiki/Data_structure), especially [database schemas](https://en.wikipedia.org/wiki/Database_schema). Common examples of DDL statements include `CREATE`, `ALTER`, and `DROP`.
>
> 谷歌翻译如下
>
> 在 SQL 的上下文中，数据定义或数据描述语言 (DDL) 是一种用于创建和修改数据库对象（例如表、索引和用户）的语法。 DDL 语句类似于用于定义数据结构（尤其是数据库模式）的计算机编程语言。 DDL 语句的常见示例包括 CREATE、ALTER 和 DROP。

我们这里说的 **ddl** 语句指的是 `CREATE TABLE`，也就是建表语句

#### 在线演示地址

[http://wuhunyu.top/code-gen](http://wuhunyu.top/code-gen)

#### 项目结构

```
code-gen-by-ddl
--code-gen-by-ddl-core
--code-gen-by-ddl-sqlparse
--code-gen-by-ddl-template
--code-gen-by-ddl-admin
```

`code-gen-by-ddl-core` 模块包含了公用的注解和枚举

`code-gen-by-ddl-sqlparse` 模块的主要作用是解析 **mysql** 的 **ddl** 语句

`code-gen-by-ddl-template` 模块的主要作用是根据模板内容生成结果

`code-gen-by-ddl-admin` 模块是 web 模块，负责对外暴露服务，以及协调 `code-gen-by-ddl-sqlparse` 和 `code-gen-by-ddl-template` 这两个模块

#### 接口

目前暴露的接口一共有三个，都写在 `top.wuhunyu.codegenbyddl.admin.controller.CodeGenController` 里面

#### 其他

1. 理论上只要 **druid** 框架支持的数据库，都可以通过这种方式(**druid** + **freemarker**)来解析并生成项目开发的模板代码。不过本项目目前只支持 mysql
2. 本项目虽然使用了 **druid** 框架，但并未接入任何数据源，也就是意味着几乎不会持久化用户提交信息，部分信息可能会以日志的方式记录在服务端

#### 缺陷(待完善)

1. **jar** 包中的文件只能以流的方式读取，目前只能读取指定的文件，还不够灵活
2. 数据类型(java 数据类型 <> mysql 数据类型)的映射关系需要用户可配置