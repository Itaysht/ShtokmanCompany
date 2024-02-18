package com.example.shtokman.repomodel

import androidx.lifecycle.LiveData
import com.example.shtokman.database.WorkersDao
import com.example.shtokman.model.Appear
import com.example.shtokman.model.AppearWithWorkers
import com.example.shtokman.model.Workers

class Workers_repo(private val worker_dao: WorkersDao) {

    val readAllData: LiveData<List<Workers>> = worker_dao.readAllData()
    val readAllAppear: LiveData<List<Appear>> = worker_dao.readAllAppear()
    val readAllBoth: LiveData<List<AppearWithWorkers>> = worker_dao.getWorkerWithAppears()

    suspend fun add_worker(worker : Workers){
        worker_dao.add_worker(worker)
    }

    suspend fun add_appear(appear: Appear){
        worker_dao.add_appear(appear)
    }
    fun read_appear(id_worker: String): LiveData<List<AppearWithWorkers>>{
        return worker_dao.getWorkerWithAppearsByID(id_worker)
    }
    suspend fun delete_appear(appear: Appear){
        worker_dao.delete_appear(appear)
    }
    suspend fun delete_all_appear(){
        worker_dao.deleteAllAppear()
    }

    suspend fun update_worker(worker: Workers){
        worker_dao.updateWorker(worker)
    }
    suspend fun delete_worker(worker: Workers){
        worker_dao.deleteWorker(worker)
    }
    suspend fun delete_all_worker(){
        worker_dao.deleteAllWorkers()
    }
}