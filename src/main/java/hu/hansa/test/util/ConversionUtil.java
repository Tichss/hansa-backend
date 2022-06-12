package hu.hansa.test.util;

import java.util.List;
import java.util.stream.Collectors;
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

}

