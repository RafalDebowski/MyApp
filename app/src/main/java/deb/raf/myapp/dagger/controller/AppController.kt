package deb.raf.myapp.dagger.controller

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
//import deb.raf.myapp.dagger.component.DaggerAppComponent
import deb.raf.myapp.dagger.module.AppModule
import deb.raf.myapp.ui.MainActivity
import javax.inject.Inject

class AppController: Application(),  HasAndroidInjector {


    @Inject
    lateinit var  dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .builder()
            .application(this)
            .appModule(AppModule())
            .build()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any>{
        return dispatchingAndroidInjector
    }
}


