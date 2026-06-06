package ec.edu.puce.githubclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import ec.edu.puce.githubclient.models.Repository
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
                // A Surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var currentScreen by remember { mutableStateOf("repoList") }
                    var selectedRepo by remember { mutableStateOf<Repository?>(null) }
                    
                    val listViewModel: RepoListViewModel = viewModel()
                    val formViewModel: RepoFormViewModel = viewModel()

                    when (currentScreen) {
                        "repoList" -> RepoList(
                            viewModel = listViewModel,
                            onNavigatetoForm = {
                                selectedRepo = null
                                formViewModel.resetError()
                                currentScreen = "repoForm"
                            },
                            onEditRepo = { repo ->
                                selectedRepo = repo
                                formViewModel.resetError()
                                currentScreen = "repoForm"
                            }
                        )
                        "repoForm" -> RepoForm(
                            repoToEdit = selectedRepo,
                            viewModel = formViewModel,
                            onBackClick = {
                                formViewModel.resetError()
                                currentScreen = "repoList"
                            },
                            onSaveSuccess = {
                                listViewModel.fetchRepos()
                                formViewModel.resetError()
                                currentScreen = "repoList"
                            }
                        )
                    }
                }
            }
        }
    }
}
