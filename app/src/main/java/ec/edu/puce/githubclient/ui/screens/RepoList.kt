package ec.edu.puce.githubclient.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ec.edu.puce.githubclient.ui.components.RepoItem

@Composable
fun RepoList(
    modifier: Modifier = Modifier
){
    Column {
        RepoItem(
            name = "repositorio de Israel",
            description = "repositorio creado por Israel",
            avatarURL = "https://www.google.com/url?sa=t&source=web&rct=j&url=https%3A%2F%2Fwww.revistagq.com%2Fnoticias%2Farticulo%2Fpatricio-spin-off-bob-esponja&ved=0CBUQjRxqFwoTCPj37siSt5QDFQAAAAAdAAAAABAH&opi=89978449",
            language = "JAVAAAA"
        )
        RepoItem(
            name = "repositorio de Israel",
            description = "repositorio creado por Israel",
            avatarURL = "https://www.google.com/url?sa=t&source=web&rct=j&url=https%3A%2F%2Fwww.revistagq.com%2Fnoticias%2Farticulo%2Fpatricio-spin-off-bob-esponja&ved=0CBUQjRxqFwoTCPj37siSt5QDFQAAAAAdAAAAABAH&opi=89978449",
            language = "PYTHON"
        )
        RepoItem(
            name = "repositorio de Israel",
            description = "repositorio creado por Israel",
            avatarURL = "https://www.google.com/url?sa=t&source=web&rct=j&url=https%3A%2F%2Fwww.revistagq.com%2Fnoticias%2Farticulo%2Fpatricio-spin-off-bob-esponja&ved=0CBUQjRxqFwoTCPj37siSt5QDFQAAAAAdAAAAABAH&opi=89978449",
            language = "KOTLIN"
        )
        RepoItem(
            name = "repositorio de Israel",
            description = "repositorio creado por Israel",
            avatarURL = "https://www.google.com/url?sa=t&source=web&rct=j&url=https%3A%2F%2Fwww.revistagq.com%2Fnoticias%2Farticulo%2Fpatricio-spin-off-bob-esponja&ved=0CBUQjRxqFwoTCPj37siSt5QDFQAAAAAdAAAAABAH&opi=89978449",
            language = "CSS"
        )
        RepoItem(
            name = "repositorio de Israel",
            description = "repositorio creado por Israel",
            avatarURL = "https://www.google.com/url?sa=t&source=web&rct=j&url=https%3A%2F%2Fwww.revistagq.com%2Fnoticias%2Farticulo%2Fpatricio-spin-off-bob-esponja&ved=0CBUQjRxqFwoTCPj37siSt5QDFQAAAAAdAAAAABAH&opi=89978449",
            language = "MUDBLAZOR"
        )
    }
}