package com.wzb;

/**
 * Maven生命周期（lifeCycle）
 *
 */
public class MavenLifeCycle {
    public static void main(String[] args) {
        /*
        Maven的生命周期就是为了对所有的构建过程进行抽象和统一；描述了一次项目构建，经历哪些阶段

        在Maven出现之前，项目构建的生命周期就已经存在，开发人员不停对项目进行清理，编译，测试及部署；这是十分繁琐的
        Maven从大量项目及构建工具中学习反思，总结出一套高度完美的、易扩展的项目构建生命周期
        Maven对项目构建的生命周期划分为3套相互独立的生命周期：
            1.clean：项目构建需要的清理工作
            2.default：项目构建的核心工作：编译、测试、打包、安装、部署等
            3.site：生成报告，发布站点等
        三套生命周期中有很多阶段，只需要知道以下阶段即可
        clean：移除上一次构建生成的文件（target中的字节码文件等）
        compile：编译项目的源代码
        test：结合单元测试框架运行测试（junit）
        package：将编译后的文件进行打包（jar包，放在target目录中）
        install：安装项目到本地仓库

        Maven的生命周期是抽象的，生命周期本身不做任何实际工作，在Maven的设计中，实际的任务是由对应的插件完成的

        生命周期的顺序是：clean --> validate --> compile --> test --> package -->
        verify --> install --> site --> deploy
        需要特别关注的生命周期：clean -->  compile --> test --> package --> install
        注意：在同一套生命周期！！！中，我们在执行后面的生命周期时，前面的生命周期都会执行（特别注意是在同一套生命周期中）

         */


        /*
        生命周期的执行方式：
            1.idea工具右侧的Maven工具栏，选择对应的生命周期双击直接执行
            2.在项目的目录（必须是Maven项目）中通过Maven命令执行：mvn compile、mvn clean……

         */
    }
}
