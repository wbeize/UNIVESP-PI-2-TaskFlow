package br.com.taskflow.domain.entities

import jakarta.persistence.*
import java.time.Instant

@MappedSuperclass
abstract class BaseModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(name = "create_time", nullable = false, updatable = false)
    val createTime: Instant = Instant.now(),

    @Column(name = "creating_user_id", nullable = false, updatable = false)
    val creatingUserId: Long = 0L,

    @Column(name = "update_time", nullable = true)
    var updateTime: Instant? = null,

    @Column(name = "updating_user_id", nullable = true)
    var updatingUserId: Long? = null,

    @Version
    val version: Int = 0
)
