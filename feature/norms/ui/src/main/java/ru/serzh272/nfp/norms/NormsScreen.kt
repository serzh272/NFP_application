package ru.serzh272.nfp.norms

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.google.accompanist.flowlayout.FlowRow
import ru.serzh272.common.constants.EMPTY_STRING
import ru.serzh272.nfp.model.DomainDataHolder
import ru.serzh272.nfp.norms.NormsViewModel.Action.AddToComplex
import ru.serzh272.nfp.norms.NormsViewModel.Action.ChangeUiState
import ru.serzh272.nfp.norms.NormsViewModel.Action.SwitchItemSelection
import ru.serzh272.nfp.norms.model.ExerciseType
import ru.serzh272.nfp.norms.model.ExerciseUi
import ru.serzh272.nfp.norms.model.ExerciseUi.Companion.toExerciseUi
import ru.serzh272.nfp.norms.ui.R
import ru.serzh272.nfp.theme.NFPTheme
import ru.serzh272.nfp.core.ui.R as CoreUiR

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NormsScreen(
    modifier: Modifier = Modifier,
    uiState: NormsViewModel.ViewState = NormsViewModel.ViewState.EMPTY,
    gridSpacing: Dp = 8.dp,
    onAction: (NormsViewModel.Action) -> Unit = { }
) {
    val lazyGridState = rememberLazyGridState()
    val isFilterApplied = remember(uiState.filter) {
        derivedStateOf(uiState.filter::isEmpty)
    }
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
                            IconButton(onClick = {
                                onAction(
                                    ChangeUiState(
                                        uiState.copy(searchQuery = "")
                                    )
                                )
                            }) {
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
                        onAction(ChangeUiState(uiState.copy(searchQuery = it)))
                    })
                IconButton(
                    onClick = {
                        onAction(ChangeUiState(uiState.copy(filterDialogShow = true)))
                    }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = CoreUiR.drawable.ic_filter),
                        contentDescription = null,
                        tint = if (isFilterApplied.value) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.tertiary
                        }
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
                            .height(40.dp), shape = RoundedCornerShape(50)
                    ) {
                        Chip(stringResource(id = CoreUiR.string.exercise, " ${it.id}"),
                            leadingIcon = ImageVector.vectorResource(
                                id = it.iconRes ?: CoreUiR.drawable.ic_image_placeholder
                            ),
                            trailingIcon = ImageVector.vectorResource(id = CoreUiR.drawable.ic_close_24),
                            onTrailingIconClick = { onAction(SwitchItemSelection(it)) })
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
                    uiState.exercises.forEach { entry ->
                        item(span = { GridItemSpan(maxLineSpan) }) {
                            Header(text = stringResource(id = entry.key.humanizeNameRes))
                        }
                        items(entry.value, key = { it.id }) { exercise ->
                            val selected = exercise.exerciseType !in uiState.selectedExercises.map { it.exerciseType } ||
                                exercise in uiState.selectedExercises
                            ExerciseCard(
                                modifier = Modifier
                                    .size(96.dp, 112.dp)
                                    .animateItemPlacement(),
                                exercise = exercise,
                                onLongClick = {
                                    if (!selected) return@ExerciseCard
                                    if (!uiState.selectionMode) {
                                        onAction(
                                            ChangeUiState(
                                                uiState.copy(selectedExercises = setOf(exercise))
                                            )
                                        )
                                    } else {
                                        onAction(SwitchItemSelection(exercise))
                                    }
                                },
                                onClick = {
                                    if (uiState.selectionMode && selected) onAction(SwitchItemSelection(exercise))
                                }
                            )
                        }
                    }

                })
        }
        if (uiState.selectedExercises.isNotEmpty()) {
            FloatingActionButton(modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp), onClick = { onAction(AddToComplex(uiState.selectedExercises)) }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = CoreUiR.drawable.ic_image_placeholder),
                    contentDescription = stringResource(R.string.add_to_complex)
                )
            }
        }
    }
    if (uiState.filterDialogShow) {
        Dialog(
            onDismissRequest = { onAction(ChangeUiState(uiState.copy(filterDialogShow = false))) },
        ) {
            var filterState by remember {
                mutableStateOf(uiState.filter)
            }
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surface, shape = MaterialTheme.shapes.medium)
                    .padding(8.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.filter),
                    textAlign = TextAlign.Center
                )
                ExerciseType.availableValues.forEach { type ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = filterState.contains(type), onCheckedChange = { checked ->
                            filterState = if (checked) filterState + type else filterState - type
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
                            containerColor = MaterialTheme.colorScheme.secondary
                        ), onClick = { filterState = emptySet() }) {
                        Text(text = stringResource(R.string.clear))
                    }
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = {
                            onAction(
                                ChangeUiState(
                                    uiState.copy(
                                        filterDialogShow = false,
                                        filter = filterState
                                    )
                                )
                            )
                        }
                    ) {
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
    InputChip(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .wrapContentSize(),
        selected = true,
        onClick = onTrailingIconClick,
        label = { Text(text = text, fontSize = 12.sp) },
        trailingIcon = {
            Icon(modifier = Modifier.size(12.dp), imageVector = trailingIcon, contentDescription = EMPTY_STRING)
        },
        leadingIcon = {
            Icon(modifier = Modifier.size(18.dp), imageVector = leadingIcon, contentDescription = EMPTY_STRING)
        }
    )
}

@Composable
fun Header(modifier: Modifier = Modifier, text: String) {
    Text(text = text, modifier = modifier.fillMaxWidth())
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExerciseCard(
    modifier: Modifier = Modifier,
    exercise: ExerciseUi,
    onLongClick: () -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .clip(CardDefaults.outlinedShape)
            .combinedClickable(
                onLongClick = onLongClick,
                onClick = onClick
            ),
    ) {
        Column(Modifier.fillMaxSize()) {
            Icon(
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth()
                    .padding(start = 4.dp, top = 4.dp, end = 4.dp),
                imageVector = ImageVector.vectorResource(id = exercise.iconRes ?: CoreUiR.drawable.ic_image_placeholder),
                contentDescription = "",
            )
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = exercise.name,
                style = MaterialTheme.typography.labelSmall,
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
        val exercises = DomainDataHolder.exercises.map { it.toExerciseUi() }.groupBy { it.exerciseType }
        NormsScreen(
            modifier = Modifier
                .fillMaxSize(),
            gridSpacing = 8.dp,
            uiState = NormsViewModel.ViewState.EMPTY.copy(
                exercises = exercises,
                selectedExercises = DomainDataHolder.exercises.map { it.toExerciseUi() }.take(2).toSet()
            ),
            onAction = {},
        )
    }
}
