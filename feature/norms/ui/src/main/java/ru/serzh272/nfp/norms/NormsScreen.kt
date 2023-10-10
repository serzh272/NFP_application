package ru.serzh272.nfp.norms

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.flowlayout.FlowRow
import ru.serzh272.common.constants.EMPTY_STRING
import ru.serzh272.nfp.model.DomainDataHolder
import ru.serzh272.nfp.norms.model.ExerciseType
import ru.serzh272.nfp.norms.model.ExerciseUi
import ru.serzh272.nfp.norms.model.ExerciseUi.Companion.toExerciseUi
import ru.serzh272.nfp.norms.ui.R
import ru.serzh272.nfp.theme.NFPTheme
import ru.serzh272.nfp.core.theme.R as ThemeR
import ru.serzh272.nfp.core.ui.R as CoreUiR

@Composable
fun NormsScreen(modifier: Modifier = Modifier, normsViewModel: NormsViewModel = viewModel(), gridSpacing: Dp = 8.dp) {
    val uiState by normsViewModel.normsUiState.collectAsState()

    NormsScreenContent(modifier, uiState, gridSpacing, normsViewModel::handleCommand)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NormsScreenContent(modifier: Modifier = Modifier, uiState: NormsScreenUiState, gridSpacing: Dp, command: (NormsViewModel.NormsScreenCommand) -> Unit) {
    val lazyGridState = rememberLazyGridState()
    Box(modifier = modifier) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    value = uiState.searchQuery,
                    trailingIcon = if (uiState.searchQuery.isNotBlank()) {
                        {
                            IconButton(onClick = { command(NormsViewModel.NormsScreenCommand.ChangeUiState(uiState.copy(searchQuery = ""))) }) {
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = CoreUiR.drawable.ic_close_24),
                                    contentDescription = stringResource(id = R.string.search)
                                )
                            }
                        }
                    } else null,
                    singleLine = true,
                    label = { Text(text = stringResource(id = R.string.search)) },
                    onValueChange = {
                        command(NormsViewModel.NormsScreenCommand.ChangeUiState(uiState.copy(searchQuery = it)))
                    })
                IconButton(onClick = { command(NormsViewModel.NormsScreenCommand.ChangeUiState(uiState.copy(filterDialogShow = true))) }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = CoreUiR.drawable.ic_filter),
                        contentDescription = "",
                        tint = if (uiState.filter.isEmpty()) MaterialTheme.colors.primary else colorResource(id = ThemeR.color.spanish_orange)
                    )
                }
            }
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp), mainAxisSpacing = 8.dp, crossAxisSpacing = 4.dp
            ) {
                uiState.selectedExercises.forEach {
                    Surface(
                        modifier = Modifier
                            .wrapContentSize()
                            .height(40.dp), color = MaterialTheme.colors.primary, shape = RoundedCornerShape(50)
                    ) {
                        Chip(stringResource(id = CoreUiR.string.exercise, " ${it.id}"),
                            leadingIcon = ImageVector.vectorResource(id = it.iconRes ?: CoreUiR.drawable.ic_image_placeholder),
                            trailingIcon = ImageVector.vectorResource(id = CoreUiR.drawable.ic_close_24),
                            onTrailingIconClick = { command(NormsViewModel.NormsScreenCommand.SelectItem(it)) })
                    }
                }
            }
            LazyVerticalGrid(
                state = lazyGridState,
                columns = GridCells.Adaptive(96.dp),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(gridSpacing),
                verticalArrangement = Arrangement.spacedBy(gridSpacing),
                content = {

                    item(span = { GridItemSpan(maxLineSpan) }) { Header(text = "test") }
                    items(uiState.visibleExercises, key = { it.id },) { exercise ->
                        val clickable = exercise.exerciseType !in uiState.selectedExercises.map { it.exerciseType } || exercise in uiState.selectedExercises
                        val clickableColor = if (exercise in uiState.selectedExercises) MaterialTheme.colors.secondary else MaterialTheme.colors.secondaryVariant
                        ExerciseCard(
                            modifier = Modifier
                                .size(96.dp, 112.dp)
                                .combinedClickable(onLongClick = {
                                    if (!clickable) return@combinedClickable
                                    if (!uiState.selectionMode) {
                                        command(NormsViewModel.NormsScreenCommand.ChangeUiState(uiState.copy(selectionMode = true, selectedExercises = setOf(exercise))))
                                    } else {
                                        command(NormsViewModel.NormsScreenCommand.SelectItem(exercise))
                                    }
                                }) {
                                    if (uiState.selectionMode && clickable) command(NormsViewModel.NormsScreenCommand.SelectItem(exercise))
                                }
                                .animateItemPlacement(),
                            exercise = exercise,
                            backgroundColor = if (clickable) clickableColor else colorResource(id = ThemeR.color.silver_sand)
                        )
                    }
                })
        }
        if (uiState.selectedExercises.isNotEmpty()) {
            FloatingActionButton(modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp), onClick = { command(NormsViewModel.NormsScreenCommand.AddToComplex(uiState.selectedExercises)) }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = CoreUiR.drawable.ic_image_placeholder),
                    contentDescription = stringResource(R.string.add_to_complex),
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
    if (uiState.filterDialogShow) {
        Dialog(
            onDismissRequest = { command(NormsViewModel.NormsScreenCommand.ChangeUiState(uiState.copy(filterDialogShow = false))) },
        ) {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colors.surface, shape = MaterialTheme.shapes.medium)
                    .padding(8.dp)
            ) {
                Text(modifier = Modifier.fillMaxWidth(), text = stringResource(id = R.string.filter), textAlign = TextAlign.Center)
                ExerciseType.availableValues.forEach { type ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = uiState.filter.contains(type), onCheckedChange = { checked ->
                            command(NormsViewModel.NormsScreenCommand.ChangeUiState(uiState.copy(filter = if (checked) uiState.filter + type else uiState.filter - type)))
                        })
                        Text(text = stringResource(id = type.humanizeNameRes))
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.secondary
                        ), onClick = { command(NormsViewModel.NormsScreenCommand.ChangeUiState(uiState.copy(filter = emptySet()))) }) {
                        Text(text = stringResource(R.string.clear))
                    }
                    Button(modifier = Modifier.weight(1f), onClick = { command(NormsViewModel.NormsScreenCommand.ChangeUiState(uiState.copy(filterDialogShow = false))) }) {
                        Text(text = stringResource(R.string.apply))
                    }
                }
            }
        }
    }
}

@Composable
private fun Chip(
    text: String,
    leadingIcon: ImageVector,
    trailingIcon: ImageVector,
    onTrailingIconClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .wrapContentSize(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(modifier = Modifier.size(18.dp), imageVector = leadingIcon, contentDescription = EMPTY_STRING)
        Text(text = text, fontSize = 12.sp)
        IconButton(modifier = Modifier.size(18.dp), onClick = { onTrailingIconClick() }) {
            Icon(imageVector = trailingIcon, contentDescription = EMPTY_STRING)
        }
    }
}

@Composable
fun Header(modifier: Modifier = Modifier, text: String) {
    Text(text = "Test text", modifier = Modifier.fillMaxWidth())
}

@Composable
fun ExerciseCard(modifier: Modifier = Modifier, exercise: ExerciseUi, backgroundColor: Color) {
    Card(
        modifier = modifier,
        backgroundColor = backgroundColor
    ) {
        Column(Modifier.fillMaxSize()) {
            Icon(
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth()
                    .padding(start = 4.dp, top = 4.dp, end = 4.dp),
                imageVector = ImageVector.vectorResource(id = exercise.iconRes ?: CoreUiR.drawable.ic_image_placeholder),
                contentDescription = "",
                tint = MaterialTheme.colors.primary
            )
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = exercise.name,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 4
            )
        }
    }
}

@Preview(device = Devices.PIXEL_4, showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun NormsScreenPreview() {
    NFPTheme {
        val exercises = DomainDataHolder.exercises.map { it.toExerciseUi() }
        NormsScreenContent(
            modifier = Modifier
                .fillMaxSize(),
            gridSpacing = 8.dp,
            uiState = NormsScreenUiState(exercises = exercises, selectedExercises = exercises.take(2).toSet()),
            command = {},
        )
    }
}
