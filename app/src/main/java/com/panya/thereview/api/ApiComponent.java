package com.panya.thereview.api;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApiModule.class
})
public interface ApiComponent {
}