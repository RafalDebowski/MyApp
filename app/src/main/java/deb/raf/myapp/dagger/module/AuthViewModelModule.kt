package deb.raf.myapp.dagger.module

import androidx.lifecycle.ViewModel
import com.facebook.AccessToken
import com.google.firebase.auth.AuthCredential
import dagger.Binds
import dagger.Module
import dagger.Provides
import deb.raf.myapp.ViewModel.AuthViewModel
import deb.raf.myapp.model.User

@Module
 class AuthViewModelModule {

    @Provides
     fun provideAuthViewModel() : AuthViewModel{
         return AuthViewModel()
     }


}