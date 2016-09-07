package com.alekseyorlov.luna.service.orika.configurer;

import ma.glasnost.orika.MapperFactory;

public interface MapperConfigurer {

    void configure(MapperFactory factory);

}
