# Maven

## 1. 目前掌握技术

![avatar](Pictures\1.png)

## 2. 目前技术在开发中存在的问题

    ①一个项目就是一个工程
        如果一个项目非常庞大，就不适合继续使用package划分模块。最好是每一个模块对应一个工程，利于分工协作。
        借助于Maven就可以将一个项目拆分成多个项目。
    ②项目中需要的jar包必须手动复制，粘贴到WEB-INF/lib目录下
        问题：同样的jar包重复出现在不同的项目工程中，一方面浪费存储空间，另外工程臃肿。
        借助Maven，Jar保存在仓库中，有需要使用的工程，引用这个文件接口，不需要jar包复制。
    ③jar包需要别人提我们准备好，或到官网下载
        不同技术的官网提供jar包下载形式不同。
        某些技术使用Maven或SVN提供下载
        借助于Maven可以以一种规范的方式下载jar包。因为所有知名框架或第三方工典的jar包以及按照统一的规范存放在了 Maven的中央仓库中。
    ④一个jr包依赖的其他jar包需要自己手动加入到项目中
        FileUpload组件→1O组件。commons-fileupload-1.3jar依赖于 commons-io-2.0.1jar
        jar包依赖关系复杂
        Maven会自动将被依赖的jar包导入进来

- 传统项目和 Maven项目
  ![](Pictures\2.png)
- Maven仓库
  ![](Pictures\3.png)
仓库分三类：本地仓库，远程仓库(公司内部私服)，中央仓库
- Maven标准目录结构
![](Pictures\4.png)
- Maven 命令行模式方法(Maven的生命周期)
  操作|方法名|生命周期
  -|-|-
  清除项目编译信息|clean|清理生命周期
  编译|compile|以下均为默认生命周期
  测试|test|
  打包|package|
  安装|install|
  发布|deploy|

- Maven 概念模型图
 ![](Pictures\5.png)