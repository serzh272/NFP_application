package ru.serzh272.nfp.presentation.results

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.serzh272.nfp.domain.DomainDataHolder
import ru.serzh272.nfp.domain.model.Exam
import ru.serzh272.nfp.domain.model.ExerciseWithResult
import ru.serzh272.nfp.presentation.custom.PointsIndicator
import ru.serzh272.nfp.ui.theme.NFPTheme

@Composable
fun ResultsScreen(modifier: Modifier = Modifier, viewModel: ResultsViewModel = viewModel()) {
    val uiState by viewModel.resultsUiState.collectAsState()

    ResultsScreenContent(modifier, uiState, viewModel::handleCommand)
}

@Composable
fun ResultsScreenContent(modifier: Modifier = Modifier, uiState: ResultsScreenUiState, command: (ResultsViewModel.ResultsScreenCommand) -> Unit) {
    Column(modifier = modifier) {
        LazyColumn(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(8.dp), contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)){
            items(uiState.exams, key = {it.id}){
                ExamItem(exam = it, onClick = {})
            }
        }
    }
}

@Composable
private fun ExamItem(exam: Exam, onClick: () -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(96.dp), backgroundColor = MaterialTheme.colors.secondaryVariant) {
        Row(modifier = Modifier.fillMaxSize().padding(horizontal = 12.dp), verticalAlignment = Alignment.CenterVertically) {
            Column() {
                Text(text = "text")
                Text(text = "text")
                Text(text = "text")
            }
            Spacer(modifier = Modifier.weight(1f))
            PointsIndicator(points = exam.exercises.map { ((it.result as? ExerciseWithResult.ExerciseResult.Count)?.count ?: 0) to Color.Gray }, minPoints = 30)
        }
    }
}

@Preview(device = Devices.PIXEL_4, showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun ResultsScreenPreview() {
    NFPTheme {
        ResultsScreenContent(
            modifier = Modifier
                .fillMaxSize(),
            uiState = ResultsScreenUiState(exams = DomainDataHolder.exams),
            command = {}
        )
    }
}
