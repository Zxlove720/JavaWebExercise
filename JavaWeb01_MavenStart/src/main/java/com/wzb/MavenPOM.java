package com.wzb;

/**
 * Maven POM
 * Project Object Model项目对象模型
 */
public class MavenPOM {
    public static void main(String[] args) {
        /*
        Maven 就是通过项目对象模型POM（Project Object Model）进行项目管理和构建的，通过POM中的一段描述信息管理项目构建

        Maven模型：
            1.构建生命周期（阶段）
            Maven中的构建流程，提供了便捷的插件进行：如需要编译，可以直接使用compile插件；需要打包，可以直接使用package插件
            2.项目对象模型
            Maven将我们自己的项目抽象成为一个对象模型，拥有自己的坐标（包括：组名（groupId）、模块名（artifactId）和版本（version））
            这样可以便于项目管理、项目集成、标准化构建部署
            3.依赖管理模型
            项目中需要使用已经开发好的jar包时，直接在pom.xml配置文件中导入依赖的坐标即可，这个依赖对应的jar包会在本机的Maven仓库中
         */


        /*
        Maven仓库：Maven用于存储资源、管理各种jar包
        仓库的本质就是磁盘中的文件夹，该文件夹用于存储开发中所有的依赖（jar包）和插件
        仓库：
            1.本地仓库：计算机上的一个目录，用于存储jar包
            2.中央仓库：由Maven团队维护的全球唯一的官方仓库
            3.远程仓库（私服）：一般由公司团队搭建的私有仓库

        引入依赖流程：
            当项目中使用坐标引入对应依赖jar包后，
            首先会查找本地仓库中是否有对应的jar包
                如果有，则在项目直接引用
                如果没有，则去中央仓库中下载对应的jar包到本地仓库
            如果搭建远程仓库(私服)，jar包的查找顺序则变为： 本地仓库 ——> 远程仓库——> 中央仓库

        Maven坐标——version
            SNAPSHOT：功能不稳定，仍然处于开发中的版本（快照版本）
            RELEASE：功能稳定，可以用于发布的版本
         */
    }
}
