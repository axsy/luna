package com.alekseyorlov.luna.config;

import com.alekseyorlov.luna.domain.Entry;
import com.alekseyorlov.luna.orika.configurer.NullMapperConfigurer;
import com.alekseyorlov.luna.orika.converter.EntryTypeConverter;
import com.alekseyorlov.luna.orika.converter.EntryStatusConverter;
import com.alekseyorlov.luna.orika.converter.EntryTaxonomiesConverter;
import com.alekseyorlov.luna.orika.mapper.EntryElementsMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class OrikaConfigurer extends NullMapperConfigurer {

    private final static String ENUMERATION_CONVERTER_ID = "enumerationStringConverter";

    private final static String TAXONOMIES_CONVERTER_ID = "taxonomiesConverter";

    private final static String ENTRY_TYPE_CONVERTER_ID = "entryTypeConverter";

    @Autowired
    private EntryElementsMapper mapper;

    @Autowired
    private EntryStatusConverter statusConverter;

    @Autowired
    private EntryTaxonomiesConverter taxonomiesConverter;

    @Autowired
    private EntryTypeConverter entryTypeConverter;

    @Override
    public void configure(MapperFactory factory) {
        registerCustomConverters(factory);

        factory.classMap(Entry.class, com.alekseyorlov.luna.dto.Entry.class)
                .fieldAToB("id", "id")
                .field("title", "title")
                .field("slug", "slug")
                .field("createdAt", "createdAt")
                .field("updatedAt", "updatedAt")
                .field("publishedAt", "publishedAt")
                .field("unpublishedAt", "unpublishedAt")
                .fieldMap("type", "type")
                    .converter(ENTRY_TYPE_CONVERTER_ID)
                    .add()
                .fieldMap("status", "status")
                    .converter(ENUMERATION_CONVERTER_ID)
                    .add()
                .fieldMap("taxonomies", "taxonomies")
                    .converter(TAXONOMIES_CONVERTER_ID)
                    .add()
                .customize(mapper)
                .register();
    }

    private void registerCustomConverters(MapperFactory factory) {
        factory.getConverterFactory().registerConverter(new PassThroughConverter(Instant.class));

        ConverterFactory converterFactory = factory.getConverterFactory();
        converterFactory.registerConverter(
                ENUMERATION_CONVERTER_ID, statusConverter
        );
        converterFactory.registerConverter(
                TAXONOMIES_CONVERTER_ID, taxonomiesConverter
        );
        converterFactory.registerConverter(
                ENTRY_TYPE_CONVERTER_ID, entryTypeConverter
        );
    }
}
