package ir.alirezaeasazade.koin

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

class App : Application() {

    val myModule = module {
        // Define a single instance of DataRepository
        single { DataRepository() }
        // define a submodule
        // Define a factory for type Presenter (create a new instance each time)
        // Inject constructor with DataRepository
        factory<MyPresenter> { MyPresenter(get()) }
        // Define a single instance of View
        // Inject Presenter in constructor
        single { View(get()) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(myModule))
    }

}