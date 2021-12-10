package uz.abduvali.multtask

import android.app.Application
import uz.abduvali.multtask.di.AppComponent
import uz.abduvali.multtask.di.DaggerAppComponent
import javax.inject.Inject

class App @Inject constructor() : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .factory()
            .create(this)
    }
}