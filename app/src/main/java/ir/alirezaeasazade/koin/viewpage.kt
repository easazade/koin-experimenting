package ir.alirezaeasazade.koin

class View(val presenter: Presenter)
interface Presenter
class MyPresenter(val repository: Repository) : Presenter
interface Repository
class DataRepository()