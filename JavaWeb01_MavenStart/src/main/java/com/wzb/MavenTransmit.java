package com.wzb;

/**
 * Maven依赖传递
 *
 */
public class MavenTransmit {
    public static void main(String[] args) {
        /*
        Maven 中的依赖传递可以理解为：
        若在Maven项目中导入了A依赖的坐标，A依赖了B、B依赖了C，C依赖了D，那么在项目中A、B、C、D依赖都会有，因为依赖会传递

        若依赖传递后的依赖在项目开发中确实不需要，那么可以通过Maven中的排除依赖的功能将不需要的依赖排除掉
        排除依赖：主动断开依赖的资源，被排除的资源无需指定版本

        需要写在引入该依赖的<dependency>中
        <exclusions>
            <exclusion>
                <groupId>排除依赖的组织名</groupId>
                <artifactId>排除依赖的模块名</artifactId>
            </exclusion>
        </exclusions>
         */
    }
}
