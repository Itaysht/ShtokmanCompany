package com.example.shtokman.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.shtokman.database.Workers_db
import com.example.shtokman.model.Appear
import com.example.shtokman.model.AppearWithWorkers
import com.example.shtokman.repomodel.Workers_repo
import com.example.shtokman.model.Workers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorkersViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Workers>>
    val readAllAppear: LiveData<List<Appear>>
    val readAllBoth: LiveData<List<AppearWithWorkers>>
    var filter_id: MutableLiveData<String> = MutableLiveData("%")
    var wrkFilters: LiveData<List<AppearWithWorkers>>
    private val repository: Workers_repo

    init {
        val workerdao = Workers_db.get_database(application).workerDao()

        repository = Workers_repo(workerdao)
        readAllData = repository.readAllData
        readAllAppear = repository.readAllAppear
        readAllBoth = repository.readAllBoth
        wrkFilters = Transformations.switchMap(filter_id){ filter_id ->
            repository.read_appear(filter_id)
        }
    }

    fun setFilter(newFilter: String){
        filter_id.postValue(newFilter)
    }

    fun add_worker(worker: Workers) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.add_worker(worker)
        }
    }
    fun add_appear(appear: Appear){
        viewModelScope.launch(Dispatchers.IO){
            repository.add_appear(appear)
        }
    }
//    fun read_appear(id_worker: String){
//        viewModelScope.launch(Dispatchers.IO){
//            repository.read_appear(id_worker)
//        }
//    }
    fun delete_appear(appear: Appear){
        viewModelScope.launch(Dispatchers.IO){
            repository.delete_appear(appear)
        }
    }
    fun delete_all_appear(){
        viewModelScope.launch(Dispatchers.IO){
            repository.delete_all_appear()
        }
    }
    fun update_worker(worker: Workers){
        viewModelScope.launch(Dispatchers.IO){
            repository.update_worker(worker)
        }
    }
    fun delete_worker(worker: Workers){
        viewModelScope.launch(Dispatchers.IO){
            repository.delete_worker(worker)
        }
    }
    fun delete_all_workers(){
        viewModelScope.launch(Dispatchers.IO){
            repository.delete_all_worker()
        }
    }
}