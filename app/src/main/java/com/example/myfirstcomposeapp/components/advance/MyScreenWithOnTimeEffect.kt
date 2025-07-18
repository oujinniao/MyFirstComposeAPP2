import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme // Asegúrate de importar tu tema
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds // Para usar 2.seconds

@Composable
fun MyScreenWithOneTimeEffect(modifier: Modifier = Modifier) {
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text("Contenido de la pantalla")
        }
    }

    // ¡Aquí está el LaunchedEffect(Unit)!
    // Este bloque de código se ejecutará solo UNA VEZ cuando MyScreenWithOneTimeEffect
    // entre en la composición (es decir, cuando se muestre por primera vez).
    LaunchedEffect(Unit) { // La clave 'Unit' asegura que solo se lance una vez
        delay(2.seconds) // Espera 2 segundos
        snackbarHostState.showSnackbar(
            message = "¡Este mensaje aparece solo una vez al inicio!",
            actionLabel = "Entendido"
        )
        // Puedes añadir aquí cualquier otra tarea que solo deba ocurrir una vez
        // Por ejemplo: cargar datos iniciales, configurar listeners, etc.
    }
}

@Preview(showBackground = true, name = "OneTimeEffect Preview")
@Composable
fun MyScreenWithOneTimeEffectPreview() {
    MyFirstComposeAPPTheme {
        MyScreenWithOneTimeEffect()
    }
}