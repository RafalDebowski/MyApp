package deb.raf.myapp.dagger.module

import dagger.Module
import dagger.Provides
import deb.raf.myapp.dagger.controller.AppController
import javax.inject.Singleton

@Module
class AppModule{

    @Provides
    @Singleton
    fun provideAppModule() : AppController {
        return AppController()
    }

}