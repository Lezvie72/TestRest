package api.consts

object Instance {

    val APP_URL: String? = System.getenv("APP_URL")

    fun getMainAppUrl(): String {
        return APP_URL ?: "https://reqres.in/"
    }

    val main_app_url = getMainAppUrl()
}