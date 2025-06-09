package com.wzb.pojo;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页查询DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageQueryDTO {

    private Integer page = 1;

    private Integer pageSize = 10;

    private String sortedBy;

    private Boolean isASC = true;

    public <T> Page<T> toPage(OrderItem... items) {
        // 1.构造分页查询核心参数Page
        Page<T> pageQuery = Page.of(page, pageSize);
        // 2.封装排序参数
        if (StringUtils.isNotBlank(sortedBy)) {
            OrderItem item = new OrderItem();
            item.setColumn(sortedBy);
            item.setAsc(isASC);
            pageQuery.addOrder(item);
        } else {
            // 2.2排序参数为空，使用默认排序
            pageQuery.addOrder(items);
        }
        return pageQuery;
    }

    public <T> Page<T> toPage(String sortedBy, Boolean isASC) {
        OrderItem item = new OrderItem();
        item.setColumn(sortedBy);
        item.setAsc(isASC);
        return toPage(item);
    }

}
