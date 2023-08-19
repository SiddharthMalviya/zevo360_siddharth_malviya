package com.newsapp

import android.app.Activity
import android.app.Application
import com.newsapp.di.component.DaggerAppComponent
import com.newsapp.di.module.AppModule
import com.newsapp.di.module.RoomDatabaseModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class NewsApplication :Application(), HasActivityInjector  {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>
//    @Inject
//    lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .roomDatabaseModule(RoomDatabaseModule(this))
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity>? {
        return dispatchingActivityInjector
    }



//    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
//        return dispatchingFragmentInjector
//    }
}