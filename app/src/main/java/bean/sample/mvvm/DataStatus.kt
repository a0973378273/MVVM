package bean.sample.mvvm

sealed class DataSealed {
    object NetworkStart : DataSealed()
    class NetworkFinish<T>(data: T) : DataSealed()
    class NetworkError(code: Int = -1, message: String?) : DataSealed()
}