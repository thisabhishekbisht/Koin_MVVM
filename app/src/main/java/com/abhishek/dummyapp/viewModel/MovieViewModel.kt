import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abhishek.dummyapp.data.Movies
import com.abhishek.dummyapp.data.Result
import com.abhishek.dummyapp.utils.NetworkHelper
import com.abhishek.dummyapp.utils.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel(private val networkHelper: NetworkHelper) : ViewModel() {


    private var movieLiveData = MutableLiveData<Resource<List<Result>>>()
   /*get movies*/
    fun getPopularMovies() {
       if (networkHelper.isNetworkConnected()) {
           RetrofitInstance.api.getPopularMovies("566acfac3490ea46c8e4cd03a416a567")
               .enqueue(object :
                   Callback<Movies> {
                   override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                       if (response.body() != null) {
                           movieLiveData.postValue(Resource.success(response.body()!!.results))
                       } else {
                           return
                       }
                   }

                   override fun onFailure(call: Call<Movies>, t: Throwable) {
                       Log.d("TAG", t.message.toString())
                   }
               })
       }
       else{
           Log.e("Error ","Abu Else");
       }
   }

    fun observeMovieLiveData(): LiveData<Resource<List<Result>>> {
        return movieLiveData

    }
}
