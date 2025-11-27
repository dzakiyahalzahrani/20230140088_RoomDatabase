package com.example.a20230140088_roomdatabase.repositori

import android.app.Application
import android.content.Context
import com.example.a20230140088_roomdatabase.room.DatabaseSiwa

interface ContainerApp {
    val repositoriSiswa : RepositoriSiswa
}

class ContainerDataApp(private val context: Context):
        ContainerApp {
    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositoriSiswa(
            DatabaseSiwa.getDatabase(context).siswaDao())
    }
}

class AplikasiSiswa : Application() {

    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}