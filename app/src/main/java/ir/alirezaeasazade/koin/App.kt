package ir.alirezaeasazade.koin

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

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

val mymodule2 = module {
    single { AAAAA() }
}

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(myModule, mymodule2))
    }

}