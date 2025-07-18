import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize // Para la preview
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text // Importar Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment // Importar Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color // Importar Color
import androidx.compose.ui.tooling.preview.Preview // Para la preview
import androidx.compose.ui.unit.dp // Importar dp
import androidx.compose.ui.unit.sp // Importar sp
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme // Importa tu tema para la preview
import kotlinx.coroutines.delay // Importar delay
import kotlin.time.Duration.Companion.seconds // Importar .seconds

@Composable
fun MyLaunchedEffect(modifier: Modifier = Modifier, onFinished: () -> Unit = {}) { // onFinished con valor por defecto
    var timeLeft: Int by remember { mutableIntStateOf(5) }

    // Usamos 'true' como clave para que LaunchedEffect se ejecute mientras el Composable esté en pantalla.
    // La lógica de parada del contador está dentro del bucle.
    LaunchedEffect(true) {
        // Bucle para el contador regresivo
        while (timeLeft > 0) {
            delay(1.seconds)
            timeLeft--
        }
        // Una vez que el bucle termina (timeLeft es 0), llamamos a onFinished() una sola vez.
        onFinished()
    }

    //LaunchedEffect(Unit) {// <-- La clave 'Unit' significa que se ejecuta una vez al inicio
    //}

    Box(
        modifier = modifier // Modificador inicial
            .size(150.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (timeLeft > 0) timeLeft.toString() else "Finished",
            fontSize = 30.sp,
            color = Color.White // Para que el texto sea visible en fondo azul
        )
    }
}

// --- Preview para MyLaunchedEffect ---
@Preview(showBackground = true, name = "MyLaunchedEffect Preview")
@Composable
fun MyLaunchedEffectPreview() {
    MyFirstComposeAPPTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            MyLaunchedEffect(onFinished = {
                println("¡Contador terminado desde la Preview!")
            })
        }
    }
}
