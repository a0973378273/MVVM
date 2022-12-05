package bean.sample.mvvm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class CoroutineViewModel : ViewModel() {
    private val mutex = Mutex()
    fun runMutex() {
        var counter = 0
        println("runCoroutine start")
        runBlocking {
            repeat(200000) {
                launch(Dispatchers.Default) {
                    mutex.withLock {
                        counter++
                    }
                }
            }
            println("runCoroutine counter: $counter")
        }
        println("runCoroutine end")
    }

    suspend fun runJob() = coroutineScope {
        val job = MainScope().launch {
            println("job block start")
            delay(1000)
            println("job block end")
        }
    }

    suspend fun joinJob() = coroutineScope {
        val job = launch {
            println("job block start")
            delay(1000)
            println("job block end")
        }
        println("job join start")
        job.join()
        println("job join end")
    }

    suspend fun cancelJob() = coroutineScope {
        val job = launch {
            println("job block start")
            delay(1000)
            println("job block end")
        }
        println("job cancel start")
        job.cancel()
        println("job cancel end")
    }

    suspend fun startJob() = coroutineScope {
        val job = launch (start = CoroutineStart.LAZY) {
            println("job block start")
            delay(1000)
            println("job block end")
        }
        println("job start start")
        println("job start run ${job.start()}")
        println("job start end")
    }

    suspend fun runDeferred() = coroutineScope {
        val deferred = GlobalScope.async {
            println("async block start")
            delay(1000)
            println("async block end")
            "return async"
        }
    }

    suspend fun runDeferredAwait() = coroutineScope {
        val deferred = GlobalScope.async {
            println("async block start")
            delay(1000)
            println("async block end")
            "return async"
        }
        println("deferred await start")
        println("deferred await run: ${deferred.await()}" )
        println("deferred await end")
    }
}