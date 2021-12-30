package com.back.productbackend.page;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ClassName: Pagination
 *
 * 针对原来的PageBean进行优化一下，模板不需要在外层
 *
 * @author: davidwang2006@aliyun.com DavidWang
 * @date: 2020/7/28 17:37
 * @description:
 */
@ApiModel("分页查询的结果")
public class Pagination<T> {
    @ApiModelProperty(value = "每页条数")
    private Integer pageSize = 20;

    @ApiModelProperty(value = "页码")
    private Integer pageIndex = 1;

    private Integer pageStart = 0;

    @ApiModelProperty(value = "列表内容")
    private List<T> data;

    @ApiModelProperty(value = "总条数")
    private Long count;

    public static <T> Pagination<T> empty(int pageIndex, int pageSize){
        Pagination<T> page = new Pagination();
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        page.setCount(0L);
        page.setData(new ArrayList<>());
        page.setPageStart((pageIndex - 1) * pageSize);
        return page;
    }

    /**
     * 转换成另一种格式
     * @param mapper
     * @param <R>
     * @return
     */
    public <R> Pagination<R> transform(Function<? super T, ? extends R> mapper){

        Pagination newGuy = new Pagination<>();
        newGuy.setPageIndex(pageIndex);
        newGuy.setPageSize(pageSize);
        newGuy.setPageStart(pageStart);
        newGuy.setCount(count);
        List newLst = getData().stream().map(mapper).collect(Collectors.toList());
        newGuy.setData(newLst);

        return newGuy;
    }

    /**
     * 多次转换
     * @param mapper
     * @param <R>
     * @return
     */
    public <R> Pagination<R> transforms(Function<? super List<T>, ? extends List<R>> mapper){

        List<T> data = getData();
        List newData = mapper.apply(data);

        Pagination newGuy = new Pagination<>();
        newGuy.setPageIndex(pageIndex);
        newGuy.setPageSize(pageSize);
        newGuy.setPageStart(pageStart);
        newGuy.setCount(count);
        newGuy.setData(newData);

        return newGuy;
    }

    /**
     *
     * 建议以后使用此方法，较方便的进行分页处理
     * @author davidwang2006@aliyun.com wangweiwei
     * @date 2020-07-28 17:56:22
     */
    public static <T> Pagination<T> page(int pageIndex, int pageSize, Runnable run){

        try(Page page = PageHelper.startPage(pageIndex, pageSize).doSelectPage(()->run.run())){
            Pagination pagination = new Pagination();
            pagination.setCount(((Page) page).getTotal());
            pagination.setPageIndex(pageIndex);
            pagination.setPageSize(pageSize);
            pagination.setPageStart((pageIndex - 1) * pageSize);
            pagination.setData(page.getResult());
           return pagination;
        }


    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
