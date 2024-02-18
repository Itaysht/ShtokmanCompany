package com.example.shtokman.model

import androidx.room.Embedded
import androidx.room.Relation

data class AppearWithWorkers(
    @Embedded val worker: Workers,
    @Relation(
        parentColumn = "id",
        entityColumn = "creatorID"
    )
    val appears: List<Appear>
)