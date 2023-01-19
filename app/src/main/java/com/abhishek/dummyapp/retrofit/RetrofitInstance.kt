import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
	val api : MovieApiInterface by lazy {
		Retrofit.Builder()
			.baseUrl("https://api.themoviedb.org/3/movie/")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(MovieApiInterface::class.java)
	}
}
