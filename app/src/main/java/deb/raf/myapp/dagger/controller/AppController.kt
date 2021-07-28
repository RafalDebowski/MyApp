package deb.raf.myapp.dagger.controller

import android.app.Activity
import android.app.Application
import deb.raf.myapp.dagger.module.AppModule
import deb.raf.myapp.ui.MainActivity

class AppController: Application() {


//    @Inject
//    lateinit var  dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
//
//    override fun onCreate() {
//        super.onCreate()
//
//        DaggerAppComponent
//            .builder()
//            .create(this)
//            .application(this)
//            .appModule(AppModule())
//            .build()
//            .inject(this)
//    }
//
//    override fun androidInjector(): AndroidInjector<Any>{
//        return dispatchingAndroidInjector
//    }
}


