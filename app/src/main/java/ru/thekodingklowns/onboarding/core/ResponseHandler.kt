package ru.thekodingklowns.onboarding.core

import android.util.Log
import retrofit2.HttpException
import ru.thekodingklowns.onboarding.R
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ResponseHandler {
    suspend operator fun <T> invoke(block: suspend () -> T) = try {
	    Resource.Success(block())
    } catch (e: Exception) {
        Log.e(javaClass.name, e.toString())
        val errorCode = when (e) {
            is HttpException -> e.code()
            is SocketTimeoutException -> ErrorCodes.SocketTimeOut.code
            is UnknownHostException -> ErrorCodes.UnknownHost.code
            else -> Int.MAX_VALUE
        }
	    Resource.Error(getErrorMessage(errorCode))
    }

    private fun getErrorMessage(code: Int) = when (code) {
        ErrorCodes.UnknownHost.code   -> R.string.no_connection
        ErrorCodes.SocketTimeOut.code -> R.string.timeout
        401                           -> R.string.unauthorized
        404                           -> R.string.not_found
        in 400..499             -> R.string.check_entered_data
        in 500..599             -> R.string.server_error
        else                          -> R.string.something_went_wrong
    }

    private enum class ErrorCodes(val code: Int) {
        SocketTimeOut(-1),
        UnknownHost(-2)
    }
}