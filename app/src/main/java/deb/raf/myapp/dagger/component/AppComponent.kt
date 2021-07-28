package deb.raf.myapp.dagger.component

import android.app.Activity
import android.app.Application
import deb.raf.myapp.ViewModel.AuthViewModel
import deb.raf.myapp.dagger.controller.AppController
import deb.raf.myapp.dagger.module.ActivityModule
import deb.raf.myapp.dagger.module.AppModule
import deb.raf.myapp.dagger.module.AuthViewModelModule

//@Singleton
//@Component(modules = [
//    AuthViewModelModule::class,
//    AndroidSupportInjectionModule::class,
//    AppModule::class,
//    ActivityModule::class
//])
interface AppComponent {

//    @Component.Builder
//    interface Builder{
//
//        @BindsInstance
//        fun application(application: Application) : Builder
//
//        fun appModule(appModule : AppModule) : Builder
//
//        fun build() : AppComponent
//    }
//
//    fun contributeActivity(activity: Activity)
//
//     fun provideAuthViewModel() : AuthViewModel
//
//     fun inject(app: AppController)
}