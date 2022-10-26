package com.consistentinquiry.Oasis.models.messages;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

public class EntityPageElement<T> {

  private List<T> items;
  private long total;
  private long page;
  private long pageSize;
  private long pages;

  public EntityPageElement() {
  }

  public EntityPageElement(
      List<T> items, long total, long page, long pageSize, long pages) {
    this.items = items;
    this.total = total;
    this.page = page;
    this.pageSize = pageSize;
    this.pages = pages;
  }

  public static <E, M> EntityPageElement<E> fromPage(
      Page<M> page,
      Function<M, E> modelToElement) {
    return new EntityPageElement<>(page.getContent()
                                       .stream()
                                       .map(modelToElement)
                                       .collect(Collectors.toList()),
                                   page.getTotalElements(),
                                   page.getNumber(),
                                   page.getSize(),
                                   page.getTotalPages());
  }

  public List<T> getItems() {
    return items;
  }

  public void setItems(List<T> items) {
    this.items = items;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

  public long getPage() {
    return page;
  }

  public void setPage(long page) {
    this.page = page;
  }

  public long getPageSize() {
    return pageSize;
  }

  public void setPageSize(long pageSize) {
    this.pageSize = pageSize;
  }

  public long getPages() {
    return pages;
  }

  public void setPages(long pages) {
    this.pages = pages;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    EntityPageElement<?> that = (EntityPageElement<?>) o;
    return total == that.total && page == that.page && pageSize == that.pageSize
           && pages == that.pages && items.equals(that.items);
  }

  @Override public int hashCode() {
    return Objects.hash(items, total, page, pageSize, pages);
  }

  @Override public String toString() {
    return "EntityPageElement{" + "items=" + items + ", total=" + total
           + ", page=" + page + ", pageSize=" + pageSize + ", pages=" + pages
           + '}';
  }
}
