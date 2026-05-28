package ec.edu.puce.githubclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import ec.edu.puce.githubclient.ui.screens.RepoForm
import ec.edu.puce.githubclient.ui.screens.RepoList
import ec.edu.puce.githubclient.ui.theme.GithubClientTheme
import ec.edu.puce.githubclient.viewmodels.RepoFormViewModel
import ec.edu.puce.githubclient.viewmodels.RepoListViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GithubClientTheme {
                var currentScreen by remember { mutableStateOf("repoList") }
                val listViewModel: RepoListViewModel = viewModel()
                val formViewModel: RepoFormViewModel = viewModel() // Espacio corregido aquí

                when (currentScreen) {
                    "repoList" -> RepoList(
                        viewModel = listViewModel,
                        onNavigatetoForm = {
                            formViewModel.resetError() // Limpia el error 422 antes de entrar al formulario
                            currentScreen = "repoForm"
                        }
                    )
                    "repoForm" -> RepoForm(
                        viewModel = formViewModel, // Ahora sí se vincula correctamente y deja de estar gris
                        onBackClick = {
                            formViewModel.resetError() // Limpia el error al regresar a la lista
                            currentScreen = "repoList"
                        },
                        onSaveSuccess = {
                            listViewModel.fetchRepos()
                            formViewModel.resetError() // Limpia por seguridad tras un caso exitoso
                            currentScreen = "repoList"
                        }
                    )
                }
            }
        }
    }
}