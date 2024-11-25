package com.wzb;

/**
 * Maven快速入门
 */
public class MavenStart {
    public static void main(String[] args) {
        /*
        Maven是一款用于管理和构建Java项目的工具，是Apache旗下的一个开源项目

        Maven主要的作用：
        1.依赖管理：Maven可以方便快捷的管理项目依赖的资源（jar包），避免版本冲突的问题
            不使用Maven：如果在项目中想要使用某一个jar包，必须在官网中下载对应的jar包，并且导入项目中，十分繁琐
            使用Maven：使用Maven进行项目依赖（jar包）的管理，只需要在pom.xml配置文件中添加对应依赖的坐标即可
        在pom.xml文件中添加了依赖坐标之后，Maven会自动根据配置信息描述，去下载对应的依赖；然后在项目中就可以直接使用了

        2.项目构建：Maven提供了标准化的跨平台的自动化项目构建方式
            不使用Maven：在完成了项目开发之后，代码需要进行编译、测试、打包、发布等繁琐过程，这些操作是所有的项目都需要的
        如果反复进行就显得十分麻烦
            使用Maven：通过Maven中的命令可以便捷完成项目的编译（compile）、测试（test）、打包（package）、发布（deploy）
        等操作。并且和Java一样，这些操作都是跨平台的，可移植性极强

        3.统一项目结构
            不使用Maven：Java语言的IDE有很多，比如idea和eclipse，不同的开发工具创建出来的Java项目的目录结构是不同的，
        导致了一个问题：不同的ide创建的项目不能直接互相导入，开发协同性低
            使用Maven：Maven具有一套标准的Java项目的目录结构，在不同的ide中可以便捷的互相导入

        总而言之：Maven是一款最好的管理和构建Java项目的工具

         */
        System.out.println("hello world");
        System.out.println("best Maven");
    }
}
