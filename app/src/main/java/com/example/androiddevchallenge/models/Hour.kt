import androidx.compose.runtime.Immutable
import com.example.androiddevchallenge.models.Weather

@Immutable
data class Hour(
    val time: Int,
    val weather: Weather
)
