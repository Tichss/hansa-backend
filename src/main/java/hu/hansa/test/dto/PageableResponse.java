package hu.hansa.test.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageableResponse<T> {
    private int currentPage;
    private int totalPages;
    private long totalItems;
    private List<T> items;
}
