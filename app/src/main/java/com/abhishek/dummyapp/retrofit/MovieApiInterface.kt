import com.abhishek.dummyapp.data.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiInterface {
	@GET("popular?")
	fun getPopularMovies(@Query("api_key") api_key : String) : Call<Movies>
}
