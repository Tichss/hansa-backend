package hu.hansa.test.util;

import java.util.List;
import java.util.stream.Collectors;

import hu.hansa.test.dto.PageableResponse;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;

public class ConversionUtil {

    /**
     * List conversion helper.
     *
     * @param list              the source list
     * @param convertedType     the target type
     * @param conversionService the conversion service
     * @param <S>               the source type
     * @param <T>               the target type
     * @return the converted list
     */
    public static <S, T> List<T> getListResponse(final List<S> list, final Class<T> convertedType,
                                                 final ConversionService conversionService) {
        return list.stream().map(item -> conversionService.convert(item, convertedType)).collect(Collectors.toList());
    }

    /**
     * Pageable response helper.
     *
     * @param page the page object
     * @param convertedType the target type
     * @param conversionService the conversion service
     * @param <T> the target type
     * @param <S> the source type
     * @return the pageable response
     */
    public static <T, S> PageableResponse<T> getPageableResponse(final Page<S> page, final Class<T> convertedType, final ConversionService conversionService) {
        return new PageableResponse<>(page.getNumber() + 1, page.getTotalPages(), page.getTotalElements(),
                page.stream().map(item -> conversionService.convert(item, convertedType)).collect(Collectors.toList()));
    }

}

