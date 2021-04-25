package deb.raf.myapp.dagger.module

import androidx.coordinatorlayout.widget.CoordinatorLayout
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import deb.raf.myapp.ui.MainActivity
import deb.raf.myapp.ui.SignedActivity

@Module
 abstract class ActivityModule {

    @ContributesAndroidInjector
     abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeSignedActivity(): SignedActivity

}